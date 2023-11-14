/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Agustina
 */
public class RegistroComprasDAO implements DAO<RegistroCompras, Integer, String>{

    @Override
    public void create(RegistroCompras e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void add(RegistroCompras e) throws Exception {
        String query = "INSERT INTO registro_compras (id_perfil) VALUES (?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            //ver el id
            preparedStatement.setInt(1, e.getId_perfil());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(RegistroCompras e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RegistroCompras> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getProducts(Categoria cat) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RegistroCompras getByID(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RegistroCompras get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    //devuelve el ultimo id
//    public int getID() throws Exception {
//        RegistroCompras x=null;
//        //agarra el id del ultimo registro
//        String query = "SELECT * FROM registro_compras WHERE id_registro_compras = (SELECT MAX(id_registro_compras) FROM registro_compras)";
//         try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    x=rsRowTo(resultSet);
//                }
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return x.getId_registro_compras();
//   }

 public int getID() throws Exception {
    int lastId = -1;

    // Consulta SQL para obtener el último ID directamente
    String query = "SELECT MAX(id_registro_compras) AS last_id FROM registro_compras";

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
    public RegistroCompras rsRowTo(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getID(String l) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
