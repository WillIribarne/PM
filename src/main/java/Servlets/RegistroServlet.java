package Servlets;

import Modelos.Perfil;
import Modelos.Usuario;
import Modelos.UsuarioDAO;
import Modelos.DAO;
import Modelos.PerfilDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String date = req.getParameter("fecha");
        String email = req.getParameter("correo");
        String domicilio = req.getParameter("domicilio");
        String telefono = req.getParameter("tel");
        String foto = req.getParameter("photoInput");
        
        Perfil p = new Perfil(nom,ape,date,email,domicilio,telefono,foto);
        Usuario u = new Usuario(user, pass);
        UsuarioDAO uDAO = new UsuarioDAO();
        
        //--------------------------------------------------------------------
        //verifico que esten cargados los datos
        req.setAttribute("mensaje", true);
        try {
            if(uDAO.existeElUsuario(u.getNombre())==false){ //chequeo que no sea existente el nombre de usuario
                //if (u.sonCorrectosLosDatos(u) == true && p.sonCorrectosLosDatos(p)  == true) {
                try {
                    req.setAttribute("mensajeInfo", "Felicitaciones! Su usuario ha sido creado con éxito" );
                    //creo en la bd el perfil y el usuariocreacion
                    PerfilDAO pDAO = new PerfilDAO();
                    uDAO.add(u);
                    Perfil pp = new Perfil(p,uDAO.getID(u.getNombre()));
                    
                    pDAO.add(pp);
                } catch (Exception ex) {
                    Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } else {
                req.setAttribute("mensajeInfo", "ERROR - No se pudo crear el usuario, por favor complete todos los campos pedidos."
                        + "             En el caso de que los haya completado todos, modifique el nombre de usuario debido a que ya existe" );
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //--------------------------------------------------------------------
        req.getRequestDispatcher("Vistas/registroEstado.jsp").forward(req, resp);   
       
    }
}
