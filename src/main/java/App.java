import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import Modelos.*;
import java.util.*;
import java.time.LocalDate;

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

        // DAOs
        UsuarioDAO uDAO = new UsuarioDAO();
        PerfilDAO pDAO = new PerfilDAO();
        ProductoDAO prodDAO = new ProductoDAO();
        CompraDAO cDAO = new CompraDAO();
        RegistroComprasDAO regCompDAO = new RegistroComprasDAO();

        // --- RUTAS PÚBLICAS ---

        app.before(ctx -> {
            Usuario user = ctx.sessionAttribute("userLogueado");
            if (user != null) {
                ctx.attribute("userLogueado", user);
                ctx.attribute("perfilLogueado", ctx.sessionAttribute("perfilLogueado"));
                ctx.attribute("tipoUser", ctx.sessionAttribute("tipoUser"));
            }
        });

        app.get("/", ctx -> {
            Map<String, Object> modelo = new HashMap<>();

            Usuario user = ctx.sessionAttribute("userLogueado");
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");
            Integer tipo = ctx.sessionAttribute("tipoUser");

            modelo.put("userLogueado", user);
            modelo.put("perfilLogueado", perfil);
            modelo.put("tipoUser", tipo);

            ctx.render("index.html", modelo);
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

        app.get("/perfil", ctx -> {
            if (ctx.sessionAttribute("userLogueado") == null) {
                ctx.redirect("/inicioSesion");
                return;
            }
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("userLogueado", ctx.sessionAttribute("userLogueado"));
            modelo.put("perfilLogueado", ctx.sessionAttribute("perfilLogueado"));
            modelo.put("tipoUser", ctx.sessionAttribute("tipoUser"));
            ctx.render("vistas/perfilUsuario.html", modelo);
        });

        app.get("/cerrarsesion", ctx -> {
            ctx.req().getSession().invalidate();
            ctx.redirect("/");
        });

        // CATÁLOGO Y CARRITO
        app.get("/catalogoropa", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("productos", prodDAO.getAll());
            modelo.put("tipoUser", ctx.sessionAttribute("tipoUser"));
            ctx.render("vistas/catalogoTotal.html", modelo);
        });

        app.post("/catalogoropa", ctx -> {
            if (ctx.sessionAttribute("userLogueado") == null) {
                ctx.redirect("/inicioSesion");
                return;
            }
            int idProd = Integer.parseInt(ctx.formParam("valorButton"));
            int cantidad = Integer.parseInt(ctx.formParam("cantidad"));

            Carrito carrito = ctx.sessionAttribute("carrito");
            Producto p = prodDAO.get(idProd);

            if (p != null && p.getStock() >= cantidad) {
                carrito.addProductoAlCarrito(p, cantidad);
                carrito.modificarCosto(p.getPrecio() * cantidad);
                ctx.sessionAttribute("carrito", carrito);
            }
            ctx.redirect("/comprar");
        });

        app.get("/comprar", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("carrito", ctx.sessionAttribute("carrito"));
            modelo.put("perfilLogueado", ctx.sessionAttribute("perfilLogueado"));
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
                ctx.redirect("/catalogoropa");
            }
        });

        // BILLETERA
        app.get("/billetera", ctx -> ctx.render("vistas/agregaABilletera.html"));

        app.post("/billetera", ctx -> {
            Perfil perfil = ctx.sessionAttribute("perfilLogueado");
            double monto = Double.parseDouble(ctx.formParam("boton"));
            double nuevoSaldo = pDAO.updateBilletera(perfil.getId_usuario(), monto);
            perfil.setBilletera(nuevoSaldo);
            ctx.sessionAttribute("perfilLogueado", perfil);
            ctx.redirect("/perfil");
        });

        // HISTORIAL DE COMPRAS
        app.get("/registroUsuario", ctx -> {
            Perfil p = ctx.sessionAttribute("perfilLogueado");
            List<RegistroCompras> regs = regCompDAO.getRegistroCompra(p.getId_perfil());
            List<Compra> compras = new Compra().obtenerComprasDelUser(regs);
            ctx.render("vistas/listaComprasUsuario.html", Map.of("registroCompras", compras, "perfilLogueado", p));
        });

        // --- RUTAS DE ADMINISTRADOR ---

        app.get("/producto", ctx -> ctx.render("vistas/agregarProducto.html"));

        app.post("/producto", ctx -> {
            String nombre = ctx.formParam("nombre");
            String marca = ctx.formParam("marca");
            String desc = ctx.formParam("descripcion");
            double precio = Double.parseDouble(ctx.formParam("precio"));
            int stock = Integer.parseInt(ctx.formParam("stock"));
            Categoria cat = new Producto().devolverCategoria(ctx.formParam("categoria"));

            prodDAO.add(new Producto(nombre, marca, cat, precio, stock, desc));
            ctx.render("vistas/estadoProducto.html", Map.of("mensajeInfo", false));
        });

        app.get("/listadousuarios", ctx -> {
            ctx.render("vistas/listadoUsuarios.html", Map.of(
                    "listadoPerfil", pDAO.getAll(),
                    "listadoUser", uDAO.getAll()
            ));
        });

        app.get("/listadoproductostotal", ctx -> {
            ctx.render("vistas/listadoCompras.html", Map.of("listadoComprasTotal", cDAO.getAll()));
        });
    }
}