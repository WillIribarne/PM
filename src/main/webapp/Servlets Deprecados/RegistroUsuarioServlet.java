package Servlets;

import Modelos.Compra;
import Modelos.Perfil;
import Modelos.Producto;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RegistroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    try {
        HttpSession session = req.getSession(); // Pido la sesión actual
        //mostrar solo las compras del usuario
        //tabla: registro compras
        Perfil p = (Perfil) session.getAttribute("perfilLogueado");
        List <RegistroCompras> registroCompras = new RegistroComprasDAO().getRegistroCompra(p.getId_perfil());
        
        //tabla:compras
        Compra c = new Compra ();
        List <Compra> compra = c.obtenerComprasDelUser(registroCompras);
        c.invertir(compra);
        session.setAttribute("registroCompras", compra); 
        
        req.getRequestDispatcher("Vistas/listaComprasUsuario.jsp").forward(req, resp);
  
        //redireccionar
         } catch (Exception ex) {
        Logger.getLogger(RegistroUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.getRequestDispatcher("Vistas/masInfoUser.jsp").forward(req, resp);
  
   }
   

}
