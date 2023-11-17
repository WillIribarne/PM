
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
    public void add(Producto producto) throws Exception {
    String query = "INSERT INTO producto (nombre, marca, categoria, precio, stock, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            //ver el id
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setString(2, producto.getMarca());
            
            preparedStatement.setString(3,  producto.getCat().name());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setInt(5, producto.getStock());
            preparedStatement.setString(6, producto.getDescripcion());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
     }

    @Override
    public void update(Producto p) throws Exception {
        String query = "UPDATE producto SET nombre = ?, marca = ?, categoria = ?, precio = ?,stock=?, descripcion = ? WHERE id_producto = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, p.getNombre());
            preparedStatement.setString(2, p.getMarca());
            preparedStatement.setString(3,  p.getCat().name());
            preparedStatement.setDouble(4, p.getPrecio());
            preparedStatement.setInt(5, p.getStock());
            preparedStatement.setString(6, p.getDescripcion());
            preparedStatement.setInt(7, p.getId_producto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
  
    public void update2(double pre, int st, int id) throws Exception {
        String query = "UPDATE producto SET precio = ?,stock=? WHERE id_producto = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setDouble(1, pre);
            preparedStatement.setInt(2, st);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    public void updateStock(int id, int stock) throws Exception {
        String query = "UPDATE producto SET stock = ? WHERE id_producto = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        String query = "DELETE FROM producto WHERE id_producto = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }}

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
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = rsRowTo(resultSet);
                }
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
