package Servlets;

import Modelos.Categoria;
import Modelos.Producto;
import Modelos.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CatalogoServlet", value = "/catalogo")
public class CatalogoServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        //agarro los productos a la session para que se muestre en el catalogo
        HttpSession sessionProducto = req.getSession(); // Pido la sesión actual
        ProductoDAO pDAO = new ProductoDAO();
        sessionProducto.setAttribute("productos", pDAO.getAll());
        
        
    } catch (Exception ex) {
        Logger.getLogger(CatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    req.getRequestDispatcher("Vistas/catalogo.jsp").forward(req, resp);
}

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
//        
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        HttpSession session = httpRequest.getSession();
//        
//        //cuando apreto el boton del carrito:
//        //si inicio sesion: puede agregar al carrito
//        //si no inicio sesion: te manda a que inicies
//        if (session != null && session.getAttribute("userLogueado") != null){
//            //antes de mandar al jsp de compras, chequea si queres agregar un producto y ver el carrito o unicamente ver el carrito
//            
//            int boton = Integer.parseInt(req.getParameter("boton")); //obtengo el boton que apreto
//            if(boton==0){
//            //solamente muestro el carrito
//            }
//            else
//            {
//                try {
//                    //agrego el producto al carrito y muestro el carrito completo
//                    Producto p = new ProductoDAO().get(boton); //traigo el producto seleccionado 
//                    //lo agrego a la lista
//                    List<Producto> product = (List<Producto>) session.getAttribute("sessionCarrito");
//                    product.add(p);
//                } catch (Exception ex) {
//                    Logger.getLogger(CatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            }
//             
//            //llevo a la pagina de comprar
            req.getRequestDispatcher("Vistas/comprar.jsp").forward(req, resp);
//        }
//        else{
//            req.setAttribute("hayError", true);
//            req.setAttribute("mensajeError", "ATENCIÓN: Debe iniciar sesion antes de realizar una compra");
//            req.getRequestDispatcher("Vistas/inicioSesion.jsp").forward(req, resp);
//           
//        }
//        
//        //visualizar carrito
//        
//       
//       
//    
   }
}
