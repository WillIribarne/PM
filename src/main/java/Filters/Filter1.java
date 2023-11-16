
package Filters;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if (session != null && session.getAttribute("userLogueado") != null) {   
            chain.doFilter(request, response); // Ir al siguiente en la cadena de filters
            //request.setAttribute("usuarioIngresado", true);
        } else {
            request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "ATENCIÓN: Debe iniciar sesion primero");
            request.getRequestDispatcher("Vistas/inicioSesion.jsp").forward(request, response);
        }
    }
}
