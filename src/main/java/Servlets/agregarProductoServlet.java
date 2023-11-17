package Servlets;

import Modelos.Compra;
import Modelos.Perfil;
import Modelos.Producto;
import Modelos.RegistroCompras;
import Modelos.RegistroComprasDAO;
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

@WebServlet(name = "agregarProductoServlet", value = "/agregarproducto")
public class agregarProductoServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("Vistas/agregarProducto.jsp").forward(req, resp);
    }
}
