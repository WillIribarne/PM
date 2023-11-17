package Servlets;

import Modelos.Compra;
import Modelos.CompraProducto;
import Modelos.Producto;
import Modelos.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MasInfoUserServlet", value = "/masinfo")
public class MasInfoUserServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("Vistas/masInfoUser.jsp").forward(req, resp);
//    } 
//    
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //lista de productos
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        HttpSession session = httpRequest.getSession();
//        
//        String b = req.getParameter("valBoton"); //id de la compra 
//        int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
// 
//
//        List <Producto> productosSeleccionados = new Compra().getProductoComprados(boton, (List<CompraProducto>) session.getAttribute("registroCompras"));
//        session.setAttribute("productosSeleccionados", productosSeleccionados); 
//        
//    } 
    
}
