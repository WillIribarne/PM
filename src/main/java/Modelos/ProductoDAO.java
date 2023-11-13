
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductoDAO implements DAO<Producto, Integer, String>{

    @Override
    public void create(Producto e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Producto e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Producto e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() throws Exception {
        List <Producto> productos = new LinkedList<>();
        String query = "SELECT * FROM producto";
        try(Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();){
            while (rs.next()){ //.next(): devuelve el siguiente elemento y devuelve si tiene algo o esta vacío (boolean)
                productos.add(rsRowTo(rs));
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return productos;
    }

    @Override
    public List getProducts(Categoria cat) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto getByID(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
        public Producto get(Integer ID) throws Exception{
        Producto product = null;
        String query = "SELECT * FROM producto WHERE id_producto = ?";
        try(Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();){
            ps.setInt(1, ID);
                if (rs.next()) {
                    product = rsRowTo(rs);
                }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return product;
    }

    @Override
    public int getID(String l) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto rsRowTo(ResultSet rs) throws Exception {
        int id = rs.getInt("id_producto");
        String nombre = rs.getString("nombre");
        String marca = rs.getString("marca");
        Categoria cat = Categoria.valueOf(rs.getString("categoria"));
        double precio = rs.getDouble("precio");
        int stock = rs.getInt("stock");
        String descripcion = rs.getString("descripcion");
        return new Producto(id, nombre, marca, cat, precio, stock, descripcion);   
    }
 
}
