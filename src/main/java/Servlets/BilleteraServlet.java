package Servlets;

import Modelos.Categoria;
import Modelos.Perfil;
import Modelos.PerfilDAO;
import Modelos.Producto;
import Modelos.ProductoDAO;
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

@WebServlet(name = "BilleteraServlet", value = "/billetera")
public class BilleteraServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       req.getRequestDispatcher("Vistas/agregaABilletera.jsp").forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //modifico el valor de la billetera
            HttpServletRequest httpRequest = (HttpServletRequest) req;
            HttpSession session = httpRequest.getSession();
            Perfil perfilLogueado = (Perfil) session.getAttribute("perfilLogueado");
            PerfilDAO pDAO = new PerfilDAO();
            
            //me dijo cual fue el boton apretado
            // Obtener el valor del botón presionado
            String boton = req.getParameter("boton");
            int valorAAgregar=0;
            // Realizar la lógica según el botón presionado
            switch (boton) {
                case "100":
                   valorAAgregar=100;
                    break;
                case "500":
                    valorAAgregar=500;
                    break;
                case "1000":
                    valorAAgregar=1000;
                    break;
                case "5000":
                    valorAAgregar=5000;
                    break;
                case "10000":
                    valorAAgregar=10000;
                    break;
                case "20000":
                    valorAAgregar=20000;
                    break;
            }
        
            //agrego el valor en la billetera
            double nuevoValorBilletera=pDAO.updateBilletera(perfilLogueado.getId_usuario(), valorAAgregar);

           //modifico el valor de billetera en la sesion
           perfilLogueado.setBilletera(nuevoValorBilletera);

            // Actualizar el objeto en la sesión
            session.setAttribute("perfilLogueado", perfilLogueado);
            
            req.getRequestDispatcher("Vistas/perfilUsuario.jsp").forward(req, resp);
                
            
            //modifico los datos de la sesion
            //session.setAttribute("billetera", );
        } catch (Exception ex) {
            Logger.getLogger(BilleteraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
