/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Agustina
 */
public class PerfilDAO implements DAO<Perfil, Integer, String>{

    @Override
    public void create(Perfil e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getValorBilletera (int ID)throws Exception{
       double valorBilletera=0;
        String query = "SELECT * FROM perfil WHERE id_usuario = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                   valorBilletera = resultSet.getDouble("billetera");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return valorBilletera;
    
    }
 
    public double updateBilletera(int ID, double valorAgregado) throws Exception {
    double valorActual=getValorBilletera(ID); //obtengo lo que hay dentro de billetera
    double nuevoValor=valorActual+valorAgregado; //genero el nuevo valor de la billetera
    String query = "UPDATE perfil SET billetera = ? WHERE id_usuario = ?";
    
    try (Connection con = ConnectionPool.getInstance().getConnection();
         PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setDouble(1, nuevoValor);
        preparedStatement.setInt(2, ID);
        preparedStatement.executeUpdate();

    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    return nuevoValor;
 }
    
    @Override
    public void add(Perfil p) throws Exception {
        String query = "INSERT INTO perfil (nombre,apellido,fechaNac,email,billetera,domicilio,telefono,foto,id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            //ver el id
            preparedStatement.setString(1, p.getNombre());
            preparedStatement.setString(2, p.getApellido());
            preparedStatement.setString(3, "...");
            preparedStatement.setString(4, "...");
            preparedStatement.setDouble(5, p.getBilletera());
            preparedStatement.setString(6, p.getDomicilio());
            preparedStatement.setString(7, p.getTelefono());
            preparedStatement.setString(8, p.getFoto());
            preparedStatement.setInt(9, p.getId_usuario());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Perfil e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public List getProducts(Categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Perfil getByID(Integer ID) throws Exception {
        Perfil perfil = null;
        String query = "SELECT * FROM perfil WHERE id_usuario = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, ID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    perfil = rsRowTo(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return perfil;
    }

    @Override
    public int getID(String nombre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Perfil rsRowTo(ResultSet rs) throws Exception { 
        return new Perfil(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("fechaNac"),
                    rs.getString("email"),
                    rs.getFloat("billetera"),
                    rs.getString("domicilio"),
                    rs.getString("telefono"),
                    rs.getString("foto"),
                    rs.getInt("id_usuario")
            );
    }

    @Override
    public List<Perfil> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Perfil get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
