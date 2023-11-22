package Servlets;

import Modelos.Carrito;
import Modelos.Catalogo;
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

@WebServlet(name = "CatalogoAdminServlet", value = "/catalogoAdmin")
public class CatalogoAdminServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        //agarro los productos a la session para que se muestre en el catalogo
        HttpSession sessionProducto = req.getSession(); // Pido la sesión actual
        ProductoDAO pDAO = new ProductoDAO();

        //lo hago con la lista de catalogo
        Catalogo cat = new Catalogo();
        cat.setCatalogo(pDAO.getAll());
        sessionProducto.setAttribute("productos", cat.getCatalogo());
          
    } catch (Exception ex) {
        Logger.getLogger(CatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    req.getRequestDispatcher("Vistas/catalogoAdmin.jsp").forward(req, resp);

}

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        HttpSession session = req.getSession(); // Pido la sesión actual
       
        String b = req.getParameter("IDproduct"); // Obtener el valor del botón
        int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
 
        Producto p = new ProductoDAO().get(boton);
        //Producto p = new ProductoDAO().get(3);
        session.setAttribute("pedit", p);
       
       req.getRequestDispatcher("Vistas/editarProducto.jsp").forward(req, resp);

    } catch (Exception ex) {
        Logger.getLogger(CatalogoAdminServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
                                   
    
}

}
