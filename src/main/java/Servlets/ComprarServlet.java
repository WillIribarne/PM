package Servlets;

import Modelos.Carrito;
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

@WebServlet(name = "ComprarServlet", value = "/comprar")
    public class ComprarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        req.getRequestDispatcher("Vistas/comprar.jsp").forward(req, resp);

    }

    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String b = req.getParameter("butt"); // Obtener el valor del botón "Carrito" que fue presionado
        int boton = Integer.parseInt(b); // Convertir el valor a entero si es necesario
        
        HttpSession session = req.getSession(); // Pido la sesión actual
        
        if(boton==1){ //comprar
            //chequea el saldo
            Carrito c = (Carrito)session.getAttribute("carrito");
            Perfil p = (Perfil) session.getAttribute("perfilLogueado");
            if(p.getBilletera()>=c.getPrecio()) //saldo suficiente
            {
                req.setAttribute("hayError", true);
                
            }
            else //saldo insuficiente
            {
                req.setAttribute("hayError", false);
            }
              
            req.getRequestDispatcher("Vistas/estadoCompra.jsp").forward(req, resp);
   
        }
        else if (boton==3)//vaciar carrito
        {
            Carrito c = (Carrito)session.getAttribute("carrito");
            List <Producto> product = c.getCarr();
            product.clear();
            req.getRequestDispatcher("Vistas/catalogo.jsp").forward(req, resp);
                
        }
    }
    
}
    