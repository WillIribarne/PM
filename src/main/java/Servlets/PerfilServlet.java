package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PerfilServlet", value = "/perfil")
public class PerfilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //aca hay que validar si hay una sesión existente o no.
        //Si la hay, redireccionar a perfilUsuario con los datos del usuario.
        //Si no la hay, mandar a inicioSesion.jsp.
        //Por ahora solamente vamos a mandar a inicioSesion hasta que empecemos con el ingreso de datos
        resp.sendRedirect("http://localhost:8080/pm/inicioSesion");
    }
}
