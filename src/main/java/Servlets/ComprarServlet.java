package Servlets;

import Modelos.Carrito;
import Modelos.Categoria;
import Modelos.Compra;
import Modelos.CompraDAO;
import Modelos.CompraProducto;
import Modelos.CompraProductoDAO;
import Modelos.Perfil;
import Modelos.PerfilDAO;
import Modelos.Producto;
import Modelos.ProductoDAO;
import Modelos.RegistroCompras;
import Modelos.RegistroComprasDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ComprarServlet", value = "/comprar")
    public class ComprarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        req.getRequestDispatcher("Vistas/comprar.jsp").forward(req, resp);

    }

    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String b = req.getParameter("butt"); // Obtener el valor del botón "Carrito" que fue presionado
        int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
        
        HttpSession session = req.getSession(); // Pido la sesión actual
        
        if(boton==1){ //comprar
            //chequea el saldo
            Carrito c = (Carrito)session.getAttribute("carrito");
            Perfil p = (Perfil) session.getAttribute("perfilLogueado");
            if(p.getBilletera()>=c.getPrecio()) //saldo suficiente
            {
                try {
                    req.setAttribute("hayError", true);
                    //resto la $ de la billetera debido a que se realizo la compra
                   // p.setBilletera(p.getBilletera()-c.getPrecio());
                    PerfilDAO pDAO = new PerfilDAO();
                    pDAO.setBilletera(p.getId_perfil(),p.getBilletera(),c.getPrecio());
                    p.setBilletera(p.getBilletera()-c.getPrecio());
                    
                    
                    List <Producto> product = c.getCarr();
                                      
                    //subo la compra a la BD
                    //*tabla: registroCompra
                    //RegistroCompras rC = new RegistroCompras(25);
                    RegistroCompras regCompras = new RegistroCompras(p.getId_perfil());
                    RegistroComprasDAO rCDAO = new RegistroComprasDAO();
                    rCDAO.add(regCompras);
                    int id = rCDAO.getID();
                    regCompras.setId_registro_compras(id);
//                    
                    //*tabla: compra
                    LocalDate fechaActual = LocalDate.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-yyyy-MM");
                    String fecha = fechaActual.format(formato);
                      
                    Compra comp = new Compra(regCompras.getId_registro_compras(),fecha,c.getPrecio());
                    CompraDAO cDAO = new CompraDAO();
                    cDAO.add(comp); //id registro compra
                    id=cDAO.getID();
                    comp.setId_compra(id);
           
                    //*tabla: compra_producto: cargo todos los productos comprados
                    CompraProductoDAO comprProduDAO = new CompraProductoDAO();
                    
                    //modificar el carrito
                    for(Producto x : product){
                       CompraProducto comprProd = new CompraProducto(comp.getId_compra(),x.getId_producto() ,x.getStock());
                       comprProduDAO.add(comprProd);
                    }
    
    //              vacio el carrito
                    product.clear();
                } catch (Exception ex) {
                    Logger.getLogger(ComprarServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            else //saldo insuficiente
            {
                req.setAttribute("hayError", false);
            }
              
            req.getRequestDispatcher("Vistas/estadoCompra.jsp").forward(req, resp);
   
        }
        else if (boton==3)//vaciar carrito
        {
            
            Carrito c = (Carrito)session.getAttribute("carrito");
            c.resetPrecio();
            List <Producto> product = c.getCarr();
            product.clear();
            req.getRequestDispatcher("Vistas/catalogo.jsp").forward(req, resp);
            session.setAttribute("carrito", c);    
        }
    }
    
}
    