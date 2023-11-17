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

@WebServlet(name = "EditarProductoServlet", value = "/editarProducto")
public class EditarProductoServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.getRequestDispatcher("Vistas/editarProducto.jsp").forward(req, resp);

}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
    try {
        HttpSession sessionProducto = req.getSession(); // Pido la sesión actual
        Producto p = (Producto) sessionProducto.getAttribute("pedit") ;
        
        String precio = req.getParameter("precio");
        double pre = Double.parseDouble(precio);
        String stock = req.getParameter("stock");
        int sto = Integer.parseInt(stock);
        
        //Producto pModificado = new Producto(p.getNombre(),p.getMarca(),p.getCat(),2,2,p.getDescripcion());
        ProductoDAO pDAO = new ProductoDAO();
        pDAO.update2(pre,sto,p.getId_producto());
        
        req.setAttribute("mensajeInfo", true); //configuro el mensaje de estado
                   
        
         req.getRequestDispatcher("Vistas/estadoProducto.jsp").forward(req, resp);   
     } catch (Exception ex) {
        Logger.getLogger(EditarProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

}

}
