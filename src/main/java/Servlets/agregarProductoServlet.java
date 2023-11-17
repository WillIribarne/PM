package Servlets;

import Modelos.Categoria;
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

@WebServlet(name = "agregarProductoServlet", value = "/producto")
public class agregarProductoServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("Vistas/agregarProducto.jsp").forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
    try {
        Producto p = new Producto();
        String nombre = req.getParameter("nombre");
        String marca = req.getParameter("marca");
        String descrip = req.getParameter("descripcion");
//        String categoriaSeleccionada = req.getParameter("categoria");
//        Categoria cat = Categoria.valueOf(categoriaSeleccionada);
        //Categoria cat = Categoria.valueOf(("Categoria"));
//         String cat = req.getParameter("Categoría");
        // Obtener el valor seleccionado del parámetro 'categoria'
        String selectedValue = req.getParameter("categoria");
        Categoria cat = p.devolverCategoria(selectedValue);
        //Categoria cat = Categoria.valueOf(selectedValue);

        String precio = req.getParameter("precio");
        double pre = Double.parseDouble(precio);
        String stock = req.getParameter("stock");
        int sto = Integer.parseInt(stock);
        
        Producto prod = new Producto(nombre,marca,cat,pre,sto,descrip);
//        Producto prod = new Producto("ropa","ropa",Categoria.Remera,500,2,"una descri");
        ProductoDAO pDAO = new ProductoDAO();
        
        pDAO.add(prod);

        
        req.getRequestDispatcher("Vistas/registroEstado.jsp").forward(req, resp);   
    } catch (Exception ex) {
        Logger.getLogger(agregarProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
    }
}
