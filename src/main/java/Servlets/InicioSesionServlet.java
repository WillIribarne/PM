package Servlets;

import Modelos.Perfil;
import Modelos.PerfilDAO;
import Modelos.Usuario;
import Modelos.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InicioSesionServlet", value = "/inicioSesion")
public class InicioSesionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
             req.getRequestDispatcher("Vistas/inicioSesion.jsp").forward(req, resp);
       
        //Si viene de un filter, será con una ruta como "/login?origen=/perfil" o "/login?origen=/restringida"
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // resp.sendRedirect("http://localhost:8080/pm");
            
            String nom = req.getParameter("usuario");
            String pass = req.getParameter("clave");
            Usuario user = new UsuarioDAO().autenticar(nom, pass); //chequeo si el usuario es existente
            
            if (user != null) { //si existe el usuario
                
                //chequeo que el usuario exista
                HttpSession session = req.getSession(); // Pido la sesión actual
                session.setMaxInactiveInterval(1800); // Seteo tiempo máximo de inactividad (en segundos)
                session.setAttribute("userLogueado", user); // Asigno la info del usuario a la sesión
                Perfil perfil = new PerfilDAO().getByID(user.getId_usuario());
                HttpSession sessionPerfil = req.getSession();
                sessionPerfil.setMaxInactiveInterval(1800); // Seteo tiempo máximo de inactividad (en segundos)
                sessionPerfil.setAttribute("perfilLogueado", perfil); // Asigno la info del usuario a la sesión

                resp.sendRedirect(req.getContextPath());

            //req.getContextPath(): va a PM la principal
            //redirect porque no tengo por que recordarme otra vez el user y la contra

            } else {
                
                
                //Usar el modelo para chequear si el registro fue exitoso.
                //Siempre redirigir a registroEstado.jsp., éste se va a encargar de mostrar lo necesario en caso de reg. exitoso o fallido
                // req.getRequestDispatcher("Vistas/inicioSesionEstadoMal.jsp").forward(req, resp);
                req.setAttribute("hayError", true);
                req.setAttribute("mensajeError", "Datos de inicio de sesion incorrectos!");
                
                req.getRequestDispatcher("Vistas/inicioSesion.jsp").forward(req, resp);
                
                // req.setAttribute("hayError", true);
                // req.setAttribute("mensajeError", "Datos incorrectos incorrectas!");
                // doGet(req, resp);
            }
        } catch (Exception ex) {
            Logger.getLogger(InicioSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}