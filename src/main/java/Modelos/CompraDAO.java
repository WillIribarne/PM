/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Agustina
 */
public class CompraDAO implements DAO<Compra, Integer, String>{

    @Override
    public void create(Compra e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void add(Compra c) throws Exception {
        String query = "INSERT INTO compra (id_registro_compras,fecha,monto) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            //ver el id
            preparedStatement.setInt(1, c.getId_registro_compra());
            preparedStatement.setString(2, c.getFecha());
            preparedStatement.setDouble(3, c.getMonto());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getID() throws Exception {
    int lastId = -1;

    // Consulta SQL para obtener el último ID directamente
    String query = "SELECT MAX(id_compra) AS last_id FROM compra";

    try (Connection con = ConnectionPool.getInstance().getConnection();
         PreparedStatement preparedStatement = con.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        if (resultSet.next()) {
            lastId = resultSet.getInt("last_id");
        }

    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }

    return lastId;
}
    
    @Override
    public void update(Compra e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Compra> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getProducts(Categoria cat) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Compra getByID(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Compra get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getID(String l) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    public Compra getRegistroCompra(int id) throws Exception {
        Compra compra = null;
        String query = "SELECT * FROM compra WHERE id_registro_compras = ?";

        try (Connection con = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            // Configurar el parámetro ID
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    compra = rsRowTo(rs);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return compra;
    }

     @Override
    public Compra rsRowTo(ResultSet rs) throws Exception {
        return new Compra(
                    rs.getInt("id_compra"),
                    rs.getInt("id_registro_compras"),
                    rs.getString("fecha"),
                    rs.getDouble("monto"));
    }
    
}
