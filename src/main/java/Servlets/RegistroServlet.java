package Servlets;

import Modelos.Perfil;
import Modelos.Usuario;
import Modelos.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RegistroServlet", value = "/registro")
public class RegistroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Vistas/registroForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Usar el modelo para chequear si el registro fue exitoso.
        //Siempre redirigir a registroEstado.jsp., éste se va a encargar de mostrar lo necesario en caso de reg. exitoso o fallido

        String user = req.getParameter("usuario");
        String pass = req.getParameter("clave");
        String nom = req.getParameter("nombre");
        String ape = req.getParameter("apellido");
        String date = req.getParameter("dateInput");
        String email = req.getParameter("emailInput");
        String domicilio = req.getParameter("domicilio");
        String telefono = req.getParameter("telInput");
        String foto = req.getParameter("photoInput");
        
        Perfil p = new Perfil(nom,ape,date,email,domicilio,telefono,foto);
        Usuario u = new Usuario(user, pass);

        //--------------------------------------------------------------------
        //verifico que esten cargados los datos
        if (u.sonCorrectosLosDatos(u) == true) { 
            req.setAttribute("mensaje", true);
            req.setAttribute("mensajeInfo", "Felicitaciones! Su usuario ha sido creado con éxito" );
        } else {
            req.setAttribute("mensaje", true);
            req.setAttribute("mensajeInfo", "ERROR - No se pudo crear el usuario, por favor complete todos los campos pedidos" );
        }
        //--------------------------------------------------------------------
        req.getRequestDispatcher("Vistas/registroEstado.jsp").forward(req, resp);   
       
    }
}
