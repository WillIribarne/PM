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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Agustina
 */
public class UsuarioDAO implements DAO<Usuario, Integer, String>{

    @Override
    public void create(Usuario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Usuario u) throws Exception {
       String query = "INSERT INTO usuario (nombre, contrasenia, Tipo) VALUES (?, ?, ?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            //ver el id
            preparedStatement.setString(1, u.getNombre());
            preparedStatement.setString(2, u.getContrasenia());           
           // preparedStatement.setString(3, TipoUsuario.Final); 
            preparedStatement.setString(3, TipoUsuario.Final.name());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Usuario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List getUserTipo (TipoUsuario t) throws Exception {
        List <Usuario> user = new LinkedList<>();
        String query = "SELECT * FROM Usuario WHERE Tipo = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
           preparedStatement.setString(1, t.name());            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user.add(rsRowTo(resultSet));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public List getProducts(Categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    


    public Usuario autenticar(String nombre, String pass)throws Exception  {

        Usuario user = null;
        
        String query = "SELECT * FROM usuario WHERE nombre = ? AND contrasenia = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, pass);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = rsRowTo(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }

    public boolean existeElUsuario(String user)throws Exception  {
        boolean flag=false;
        
        String query = "SELECT * FROM usuario WHERE nombre = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { //lo encuentra
                    flag=true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return flag;
    }
    
    @Override
    public List getAll() throws Exception {
        List <Usuario> user = new LinkedList<>();
        String query = "SELECT * FROM usuario";
        try(Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();){
            while (rs.next()){ //.next(): devuelve el siguiente elemento y devuelve si tiene algo o esta vacío (boolean)
                user.add(rsRowTo(rs));
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return user;
    }
    
    @Override
    public Usuario rsRowTo(ResultSet rs) throws Exception {
        //
        int id = rs.getInt("id_usuario");
        String nombre = rs.getString("nombre");
        String marca = rs.getString("contrasenia");
        TipoUsuario u = TipoUsuario.valueOf(rs.getString("Tipo"));
   
        return new Usuario( id,nombre,marca,u);
    }    

    @Override
    public Usuario getByID(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
        @Override
    public int getID(String nombre) throws Exception {
        String query = "SELECT * FROM usuario WHERE nombre = ?";
        Usuario user = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = rsRowTo(resultSet);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user.getId_usuario();
    
       }

}
