
package Filters;
import Modelos.TipoUsuario;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        //chequeo si es usuario final o administrador
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        TipoUsuario tipoUser =  (TipoUsuario) session.getAttribute("userLogueado.Tipo");
                   
        if (tipoUser.equals(TipoUsuario.Final)) {   
            request.setAttribute("tipoUsuario", true);
        } else {
            request.setAttribute("tipoUsuario", false);
        }
    }
}
