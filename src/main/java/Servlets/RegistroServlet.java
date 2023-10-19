package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
   
        String nom = req.getParameter("usuario");
        String pass = req.getParameter("clave");
        String date = req.getParameter("dateInput");
        String email = req.getParameter("emailInput");
        String domicilio = req.getParameter("domicilio");
        String telefono = req.getParameter("telInput");
        String foto = req.getParameter("photoInput");
        
        
    }
}
