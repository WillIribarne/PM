import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import Modelos.*;
import java.util.*;
import java.time.LocalDate;
import Filtros.AutenticacionFilter;
import Servicios.sesion;

public class App {

    public static void main(String[] args) {

        // 1. CONFIGURACIÓN DE THYMELEAF
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix(System.getProperty("user.dir") + "/src/main/resources/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false); // Para ver cambios en caliente

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);
        JavalinRenderer.register(new JavalinThymeleaf(engine), ".html");

        // Acá se ejecuta la app (el puerto podria estar en un .env)
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("src/main/webapp", Location.EXTERNAL); //agrega los archivos estaticos externos (i.e. assets de diseño)
        }).start(8080);

        // --- CREACION DE DAOs ---
        UsuarioDAO uDAO = new UsuarioDAO();
        PerfilDAO pDAO = new PerfilDAO();
        ProductoDAO prodDAO = new ProductoDAO();
        CompraDAO cDAO = new CompraDAO();
        CompraProductoDAO cpDAO= new CompraProductoDAO();
        RegistroComprasDAO regCompDAO = new RegistroComprasDAO();

        // --- FILTROS DE SEGURIDAD ---

        app.before("/listadoUsuarios", AutenticacionFilter::verificarAdministrador);
        app.before("/agregarProducto", AutenticacionFilter::verificarAdministrador);
        app.before("/editarProducto", AutenticacionFilter::verificarAdministrador);
        app.before("/eliminarProducto", AutenticacionFilter::verificarAdministrador);
        app.before("/listadoCompras", AutenticacionFilter::verificarAdministrador);
        app.before("/estadoProducto", AutenticacionFilter::verificarAdministrador);
        app.before("/billetera", AutenticacionFilter::verificarUsuarioFinal);

        // --- RUTAS PÚBLICAS ---

        app.get("/", ctx -> {
            Map<String, Object> model = new HashMap<>();

            Usuario user = ctx.sessionAttribute("userLogueado");
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");
            Integer tipo = ctx.sessionAttribute("tipoUser");

            model.put("userLogueado", user);
            model.put("perfilLogueado", perfil);
            model.put("tipoUser", tipo);

            // AGREGAMOS ESTA LÍNEA (que es la que busca tu navbar.html)
            model.put("usuarioIngresado", user != null);

            ctx.render("index.html", model);
        });

        app.get("/info", ctx -> ctx.render("vistas/quienesSomos.html"));

        // LOGIN
        app.get("/inicioSesion", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            if (ctx.queryParam("error") != null) {
                modelo.put("hayError", true);
                modelo.put("mensajeError", "Datos de inicio de sesión incorrectos.");
            }
            ctx.render("vistas/inicioSesion.html", modelo);
        });

        app.post("/inicioSesion", ctx -> {
            String user = ctx.formParam("usuario");
            String clave = ctx.formParam("clave");
            try {
                Usuario u = uDAO.autenticar(user, clave);
                if (u != null) {
                    Perfil p = pDAO.getByID(u.getId_usuario());
                    ctx.sessionAttribute("userLogueado", u);
                    ctx.sessionAttribute("perfilLogueado", p);
                    ctx.sessionAttribute("tipoUser", u.getTipo().equals(TipoUsuario.Administrador) ? 2 : 1);
                    ctx.sessionAttribute("carrito", new Carrito());
                    ctx.redirect("/");
                } else {
                    ctx.redirect("/inicioSesion?error=true");
                }
            } catch (Exception e) {
                ctx.redirect("/inicioSesion?error=true");
            }
        });

        // REGISTRO
        app.get("/registro", ctx -> ctx.render("vistas/registroForm.html"));

        app.post("/registro", ctx -> {
            String user = ctx.formParam("usuario");
            String pass = ctx.formParam("clave");
            String nom = ctx.formParam("nombre");
            String ape = ctx.formParam("apellido");
            String date = ctx.formParam("fecha");
            String email = ctx.formParam("correo");
            String domicilio = ctx.formParam("domicilio");
            String tel = ctx.formParam("tel");


            Map<String, Object> modelo = new HashMap<>();
            try {
                if (!uDAO.existeElUsuario(user)) {
                    Usuario u = new Usuario(user, pass);
                    uDAO.add(u);
                    int idNuevo = uDAO.getID(user);
                    Perfil pp = new Perfil(nom,ape,date,email,domicilio,tel);
                    Perfil p = new Perfil(pp, idNuevo);
                    pDAO.add(p);
                    modelo.put("mensajeInfo", "Felicitaciones! Su usuario ha sido creado con éxito");
                } else {
                    modelo.put("mensajeInfo", "ERROR - El usuario ya existe.");
                }
            } catch (Exception e) {
                modelo.put("mensajeInfo", "ERROR - No se pudo procesar el registro.");
            }
            ctx.render("vistas/registroEstado.html", modelo);
        });

        // --- RUTAS DE USUARIO LOGUEADO ---

        app.get("/perfilUsuario", ctx -> {
            Usuario user = ctx.sessionAttribute("userLogueado");
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");
            if (user == null) {
                ctx.redirect("/inicioSesion");
                return;
            }
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("userLogueado", user);
            modelo.put("perfilLogueado", perfil);
            modelo.put("tipoUser", ctx.sessionAttribute("tipoUser"));
            modelo.put("usuarioIngresado", true); // Para que el navbar no se rompa aquí

            ctx.render("vistas/perfilUsuario.html", modelo);
        });

        app.get("/cerrarSesion", ctx -> {
            ctx.req().getSession().invalidate();
            ctx.redirect("/");
        });

        // CATÁLOGO Y CARRITO
        app.get("/catalogoTotal", ctx -> {
            Map<String, Object> modelo = new HashMap<>();

            // 1. Cargamos los productos (fundamental para que se vea el catálogo)
            modelo.put("productos", prodDAO.getAll());

            // 2. Pasamos datos de sesión para el Navbar
            Usuario user = ctx.sessionAttribute("userLogueado");
            modelo.put("userLogueado", user);
            modelo.put("perfilLogueado", ctx.sessionAttribute("perfilLogueado"));
            modelo.put("tipoUser", ctx.sessionAttribute("tipoUser"));
            modelo.put("usuarioIngresado", user != null);

            ctx.render("vistas/catalogoTotal.html", modelo);
        });

        app.post("/catalogoTotal", ctx -> {
            Usuario user = ctx.sessionAttribute("userLogueado");
            Integer tipo = ctx.sessionAttribute("tipoUser");

            // Solo el Usuario Final (1) usa este POST para el carrito
            if (user != null && tipo != null && tipo == 1) {
                String idString = ctx.formParam("idParaAccion");
                String cantString = ctx.formParam("cantidad");

                if (idString != null && !idString.isEmpty()) {
                    int idProd = Integer.parseInt(idString);
                    int cantidad = (cantString != null) ? Integer.parseInt(cantString) : 1;

                    Producto p = prodDAO.getByID(idProd);
                    if (p != null) {
                        Carrito carrito = ctx.sessionAttribute("carrito");
                        if (carrito == null) {
                            carrito = new Carrito();
                            ctx.sessionAttribute("carrito", carrito);
                        }
                        carrito.addProductoAlCarrito(p, cantidad);
                        ctx.redirect("/comprar");
                        return;
                    }
                }
            }
            ctx.redirect("/catalogoTotal");
        });

        app.get("/comprar", ctx -> {
            String idStr = ctx.queryParam("id_producto");
            if (idStr == null) {
                ctx.redirect("/catalogoTotal");
                return;
            }

            Producto p = prodDAO.getByID(Integer.parseInt(idStr));
            Map<String, Object> modelo = sesion.crearModeloBase(ctx);
            modelo.put("producto", p);

            ctx.render("vistas/comprar.html", modelo);
        });

        app.post("/comprar", ctx -> {
            String accion = ctx.formParam("butt");
            Carrito carrito = ctx.sessionAttribute("carrito");
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");

            if ("1".equals(accion)) { // COMPRAR
                if (perfil.getBilletera() >= carrito.getPrecio()) {
                    // Lógica de persistencia de compra aquí similar al ComprarServlet original
                    // prodDAO.updateStock, cDAO.add, etc.
                    double resto = perfil.getBilletera() - carrito.getPrecio();
                    pDAO.updateBilletera(perfil.getId_usuario(), -carrito.getPrecio()); // Restar
                    perfil.setBilletera(pDAO.getValorBilletera(perfil.getId_usuario()));
                    ctx.sessionAttribute("perfilLogueado", perfil);
                    carrito.vaciarCarrito();
                    ctx.render("vistas/estadoCompra.html", Map.of("hayError", true)); // true es éxito según tu JSP
                } else {
                    ctx.render("vistas/estadoCompra.html", Map.of("hayError", false));
                }
            } else if ("3".equals(accion)) { // VACIAR
                carrito.vaciarCarrito();
                ctx.redirect("/catalogoTotal");
            }
        });

        app.post("/confirmarCompra", ctx -> {
            int idProd = Integer.parseInt(ctx.formParam("id_producto"));
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");
            Producto p = prodDAO.get(idProd);

            // Preparar modelo para la vista
            Map<String, Object> modelo = sesion.crearModeloBase(ctx);

            // 1. Validación: Stock
            if (p.getStock() <= 0) {
                modelo.put("compraExitosa", false);
                modelo.put("mensajeError", "Error: No hay stock disponible de este producto.");
                ctx.render("vistas/estadoCompra.html", modelo);
            }

            // 2. Validación: Saldo
            if (perfil.getBilletera() < p.getPrecio()) {
                modelo.put("compraExitosa", false);
                modelo.put("mensajeError", "Error: Saldo insuficiente para realizar la compra.");
                ctx.render("vistas/estadoCompra.html", modelo);
            }

            try {
                // --- LÓGICA DE COMPRA EXITOSA (Sin carrito) ---
                p.setStock(p.getStock() - 1);
                prodDAO.update(p);

                perfil.setBilletera(perfil.getBilletera() - p.getPrecio());
                pDAO.update(perfil);

                RegistroCompras rc = new RegistroCompras(perfil.getId_perfil());
                regCompDAO.add(rc);

                int idRegistro = regCompDAO.getLastId();
                Compra c = new Compra(idRegistro, java.time.LocalDate.now().toString(), p.getPrecio());
                cDAO.add(c);

                CompraProducto cp = new CompraProducto(idRegistro, p.getId_producto(), 1);
                cpDAO.add(cp);

                // Renderizar vista de éxito
                modelo.put("compraExitosa", true);
                ctx.render("vistas/estadoCompra.html", modelo);

            } catch (Exception e) {
                e.printStackTrace();

                modelo.put("compraExitosa", false);
                modelo.put("mensajeError", "Ocurrió un error inesperado al procesar la compra");
                ctx.render("vistas/estadoCompra.html", modelo);
            }
        });

        // BILLETERA
        app.get("/billetera", ctx -> {
            Map<String, Object> modelo = sesion.crearModeloBase(ctx);
            ctx.render("vistas/agregaABilletera.html", modelo);
        });


        app.post("/billetera", ctx -> {
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");
            double monto = Double.parseDouble(ctx.formParam("boton"));
            double nuevoSaldo = pDAO.updateBilletera(perfil.getId_usuario(), monto);
            perfil.setBilletera(nuevoSaldo);
            ctx.sessionAttribute("perfilLogueado", perfil);
            ctx.redirect("/perfilUsuario");
        });

        // HISTORIAL DE COMPRAS
        app.get("/registroUsuario", ctx -> {
            Perfil p = ctx.sessionAttribute("perfilLogueado");
            List<RegistroCompras> regs = regCompDAO.getRegistroCompra(p.getId_perfil());
            List<Compra> compras = new Compra().obtenerComprasDelUser(regs);
            ctx.render("vistas/listaComprasUsuario.html", Map.of("registroCompras", compras, "perfilLogueado", p));
        });

        // --- RUTAS DE ADMINISTRADOR ---

        app.get("/agregarProducto", ctx -> {
            Map<String, Object> modelo = sesion.crearModeloBase(ctx);
            ctx.render("vistas/agregarProducto.html", modelo);
        });

        app.post("/agregarProducto", ctx -> {
            String nombre = ctx.formParam("nombre");
            String marca = ctx.formParam("marca");
            String desc = ctx.formParam("descripcion");
            double precio = Double.parseDouble(ctx.formParam("precio"));
            int stock = Integer.parseInt(ctx.formParam("stock"));
            Categoria cat = new Producto().devolverCategoria(ctx.formParam("categoria"));

            prodDAO.add(new Producto(nombre, marca, cat, precio, stock, desc));

            Map<String, Object> modelo = sesion.crearModeloBase(ctx);
            modelo.put("mensajeInfo", false);
            ctx.render("vistas/estadoProducto.html", modelo);
        });

        app.get("/editarProducto", ctx -> {
            String idStr = ctx.queryParam("id_producto");

            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                Producto p = prodDAO.getByID(id);

                if (p != null) {
                    ctx.sessionAttribute("pedit", p);
                    Map<String, Object> modelo = sesion.crearModeloBase(ctx);
                    modelo.put("pedit", p);
                    ctx.render("vistas/editarProducto.html", modelo);
                    return;
                }
            }
            ctx.redirect("/catalogoTotal");
        });

        app.post("/editarProducto", ctx -> {
            Producto pOriginal = ctx.sessionAttribute("pedit");
            if (pOriginal != null) {
                int id = Integer.parseInt(ctx.formParam("id_producto"));
                double nuevoPrecio = Double.parseDouble(ctx.formParam("precio"));
                int nuevoStock = Integer.parseInt(ctx.formParam("stock"));

                // Creamos el objeto nuevo manteniendo los datos fijos del original
                Producto productoEditado = new Producto(
                        id,
                        pOriginal.getNombre(),
                        pOriginal.getMarca(),
                        pOriginal.getCat(),
                        nuevoPrecio,
                        nuevoStock,
                        pOriginal.getDescripcion()
                );

                prodDAO.update(productoEditado);
            }
            ctx.sessionAttribute("pedit", null);
            ctx.redirect("/catalogoTotal");
        });

        app.get("/listadoUsuarios", ctx -> {
            Map<String, Object> modelo = sesion.crearModeloBase(ctx);

            modelo.put("listadoPerfil", pDAO.getAll());
            modelo.put("listadoUser", uDAO.getAll());

            ctx.render("vistas/listadoUsuarios.html", modelo);
        });

        app.get("/listadoCompras", ctx -> {
            Map<String, Object> modelo = sesion.crearModeloBase(ctx);
            modelo.put("listadoComprasTotal", cDAO.getAll());
            ctx.render("vistas/listadoCompras.html", modelo);
        });

        app.get("/eliminarProducto", ctx -> {
            String idStr = ctx.queryParam("id_producto");

            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                Producto p = prodDAO.getByID(id);

                if (p != null) {
                    Map<String, Object> modelo = sesion.crearModeloBase(ctx);
                    modelo.put("pedit", p);
                    ctx.render("vistas/eliminarProducto.html", modelo);
                    return;
                }
            }
            ctx.redirect("/catalogoTotal");
        });

        app.post("/eliminarProducto", ctx -> {
            String idStr = ctx.formParam("id_producto"); // Ahora viene del formulario oculto

            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                try {
                    prodDAO.delete(id);
                } catch (Exception e) {
                    System.out.println("Error al eliminar el producto: " + e.getMessage());
                }
            }
            ctx.redirect("/catalogoTotal");
        });

    }
}