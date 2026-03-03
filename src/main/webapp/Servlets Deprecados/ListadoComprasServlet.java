package Servlets;

import Modelos.Compra;
import Modelos.CompraDAO;
import Modelos.Perfil;
import Modelos.PerfilDAO;
import Modelos.Producto;
import Modelos.TipoUsuario;
import Modelos.Usuario;
import Modelos.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ListadoComprasServlet", value = "/listadoproductostotal")
public class ListadoComprasServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        try {
            HttpSession session = req.getSession(); // Pido la sesión actual
            
            List <Compra> compra = new CompraDAO().getAll();
            
            session.setAttribute("listadoComprasTotal", compra);
            
            req.getRequestDispatcher("Vistas/listadoCompras.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(ListadoUsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
