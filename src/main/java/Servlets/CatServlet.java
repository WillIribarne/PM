/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Modelos.Carrito;
import Modelos.Catalogo;
import Modelos.Producto;
import Modelos.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustina
 */

@WebServlet(name = "CatServlet", value = "/catalogoropa")
public class CatServlet extends HttpServlet {
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        //agarro los productos a la session para que se muestre en el catalogo
        HttpSession session = req.getSession(); // Pido la sesión actual
        ProductoDAO pDAO = new ProductoDAO();

        //lo hago con la lista de catalogo
        Catalogo cat = new Catalogo();
        int n=0;
        if(session.getAttribute("userLogueado")!=null) n= (int) session.getAttribute("tipoUser");
        
        if(n==2){ //usuario admin
           cat.setCatalogo(pDAO.getAll());
        }
        else //final o no logueado
        {
           //cat.setCatalogo(pDAO.getAll());
           cat.setCatalogo(pDAO.getAll(), 0);
        }
        //cat.setCatalogo(pDAO.getAll());
        session.setAttribute("productos", cat.getCatalogo());
          
    } catch (Exception ex) {
        Logger.getLogger(CatServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    req.getRequestDispatcher("Vistas/catalogoTotal.jsp").forward(req, resp);

    } 
   
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
       //tipoUser==2 admin tipoUser==1 final
        HttpSession session = req.getSession(); // Pido la sesión actual
        int n=0;
        if(session.getAttribute("userLogueado")!=null) n= (int) session.getAttribute("tipoUser");
        
       if(n==2){ //usuario admin
                      try //final o no logueado
            {
                String b = req.getParameter("valorButton"); // Obtener el valor del botón
                int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
                
                Producto p = new ProductoDAO().get(boton);
                //Producto p = new ProductoDAO().get(3);
                session.setAttribute("pedit", p);
                
                req.getRequestDispatcher("Vistas/editarProducto.jsp").forward(req, resp);
            } catch (Exception ex) {
                Logger.getLogger(CatServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       }
       else //usuario final
       {
           if (session != null && session.getAttribute("userLogueado") != null){
            //antes de mandar al jsp de compras, chequea si queres agregar un producto y ver el carrito o unicamente ver el carrito
            
            ///********
            // Obtener el valor seleccionado del menú desplegable
            int cantidadSeleccionada = Integer.parseInt(req.getParameter("cantidad"));
            ///***********
            String b = req.getParameter("valorButton"); // Obtener el valor del botón "Carrito" que fue presionado
            int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
 
            //(boton==0) significa solamene ver el carrito
            if(boton!=0){
                try {
                    //agrego el producto seleccionado al carrito
                    Producto p = new ProductoDAO().get(boton); //traigo el producto seleccionado 
                    Carrito carr = (Carrito) session.getAttribute("carrito");
                   
                    
                    //saco un stock del catalogo
                    ProductoDAO pDAO = new ProductoDAO();
                    pDAO.updateStock(p.getId_producto(),p.getStock(), cantidadSeleccionada);
                    
                    Catalogo catal = new Catalogo();
                    catal.setCatalogo(pDAO.getAll());
                    session.setAttribute("productos", catal.getCatalogo());
                    
                    //cantidadSeleccionada: cantidad elegida
                    
                    //obtengo la cantidad elegida y se la doy al producto
                    //agrego al carrito
                    carr.addProductoAlCarrito(p,cantidadSeleccionada);
                    //modifico el costo total a pagar
                    carr.modificarCosto(p.getPrecio());
                                        
                    // Actualiza  la sesión
                    session.setAttribute("carrito", carr);
                    //session.setAttribute("productos", catal.getCatalogo());
                   
                } catch (Exception ex) {
                    Logger.getLogger(CatServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else
            {
                //chequeo si el carrito esta vacio
               Carrito carr = (Carrito) session.getAttribute("carrito");
               if (carr.estaVacio()){
                    req.setAttribute("hayError", true);
                    req.setAttribute("mensajeError", "No hay ningun producto en el carrito");
                }
            }          
            //*****MODIFICADO****************************************
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
   
}
