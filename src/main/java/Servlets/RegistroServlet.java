package Servlets;

import Modelos.Perfil;
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
       
       req.getRequestDispatcher("Vistas/registroEstado.jsp").forward(req, resp);
   
        
    }
}
