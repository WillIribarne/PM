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
import java.util.ArrayList;
import java.util.LinkedList;
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
    
        
        HttpSession session = req.getSession(); // Pido la sesión actual
        
        //cuando apreto el boton del carrito:
        //si inicio sesion: puede agregar al carrito
        //si no inicio sesion: te manda a que inicies
        if (session != null && session.getAttribute("userLogueado") != null){
            //antes de mandar al jsp de compras, chequea si queres agregar un producto y ver el carrito o unicamente ver el carrito
            
            String b = req.getParameter("valorBoton"); // Obtener el valor del botón "Carrito" que fue presionado
            int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
 
            //(boton==0) significa solamene ver el carrito
            if(boton!=0){
                try {
                    //agrego el producto seleccionado al carrito
                    Producto p = new ProductoDAO().get(boton); //traigo el producto seleccionado 
                    List <Producto> product = (List <Producto>) session.getAttribute("carrito");
                    if(product.isEmpty()){
                        List <Producto> carrito = new LinkedList<>();
                    }
                    product.add(p);

                    // Actualiza el vector en la sesión
                    session.setAttribute("carrito", product);
                   
                } catch (Exception ex) {
                    Logger.getLogger(CatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else
            {
                //chequeo si el carrito esta vacio
                List <Producto> product = (List <Producto>) session.getAttribute("carrito");    
                if (product.isEmpty()){
                    req.setAttribute("hayError", true);
                    req.setAttribute("mensajeError", "No hay ningun producto en el carrito");
                }
                
            }
             
            //llevo a la pagina de comprar
            req.getRequestDispatcher("Vistas/comprar.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("hayError", true);
            req.setAttribute("mensajeError", "ATENCIÓN: Debe iniciar sesion antes de realizar una compra");
            req.getRequestDispatcher("Vistas/inicioSesion.jsp").forward(req, resp);
           
        }
        
        
                
       
    
   }
}
