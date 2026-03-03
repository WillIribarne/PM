package Servlets;

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

@WebServlet(name = "ListadoUsuariosServlet", value = "/listadousuarios")
public class ListadoUsuariosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        try {
            HttpSession session = req.getSession(); // Pido la sesión actual
            
            List <Perfil> listadoPerfil = new PerfilDAO().getAll();
            List <Usuario> listadoUser= new UsuarioDAO().getAll();
            
            session.setAttribute("listadoPerfil", listadoPerfil);
            session.setAttribute("listadoUser", listadoUser);
            
            req.getRequestDispatcher("Vistas/listadoUsuarios.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(ListadoUsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
