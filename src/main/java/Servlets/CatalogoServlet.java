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
        ProductoDAO pDAO = new ProductoDAO();
        
        List<Producto> productos = pDAO.getAll();
           
        //lo subo a la sesion
        HttpSession sessionCatalogo = req.getSession(); // Pido la sesión actual
        sessionCatalogo.setMaxInactiveInterval(1800); // Seteo tiempo máximo de inactividad (en segundos)
        sessionCatalogo.setAttribute("productos", productos); // Asigno la info del usuario a la sesión
       
    } catch (Exception ex) {
        Logger.getLogger(CatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }    
        req.getRequestDispatcher("Vistas/catalogo.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpSession session = httpRequest.getSession();
        if (session != null && session.getAttribute("userLogueado") != null)req.getRequestDispatcher("Vistas/comprar.jsp").forward(req, resp);
        else{
            req.setAttribute("hayError", true);
            req.setAttribute("mensajeError", "ATENCIÓN: Debe iniciar sesion antes de realizar una compra");
            req.getRequestDispatcher("Vistas/inicioSesion.jsp").forward(req, resp);
           
        }
    
   }
}
