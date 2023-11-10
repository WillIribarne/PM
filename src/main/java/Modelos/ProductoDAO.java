//
//package Modelos;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class ProductoDAO implements DAO{
//    List <Producto> productos;
//
//    public ProductoDAO() {
//        this.productos = new ArrayList<>();
//    }
//
//    @Override
//    public void create(Object entidad) throws Exception {
//
//    }
//
//    @Override
//    public void add(Producto producto) throws Exception {
//    String query = "INSERT INTO producto (nombre, marca, categoria, precio, stock, descripcion) VALUES (?, ?, ?, ?, ?, ?)";
//        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            //ver el id
//            preparedStatement.setString(2, producto.getNombre());
//            preparedStatement.setString(3, producto.getMarca());
//            preparedStatement.setString(4, producto.getCat());
//            preparedStatement.setDouble(5, producto.getPrecio());
//            preparedStatement.setInt(6, producto.getStock());
//            preparedStatement.setString(7, producto.getDescripcion());
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//    
////    @Override
//    public void add(Usuario usuario) throws Exception {
//    String query = "INSERT INTO usuario (nombre, contraseria, Tipo) VALUES (?, ?, ?)";
//        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            //ver el id
//            preparedStatement.setString(2, usuario.getNombre());
//            preparedStatement.setString(3, usuario.getContrasenia());
//            preparedStatement.setString(4, usuario.getTipo());
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//    
////    @Override
//    public void add(Perfil perfil) throws Exception {
//    String query = "INSERT INTO perfil (nombre,apellido,fechaNac,email,billetera,domicilio,telefono,foto,id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            //ver el id
//            preparedStatement.setString(2, perfil.getNombre());
//            preparedStatement.setString(3, perfil.getApellido());
//            preparedStatement.setString(4, perfil.getFechaNac());
//             preparedStatement.setString(3, perfil.getEmail());
//            preparedStatement.setDouble(4, perfil.getBilletera());
//             preparedStatement.setString(3, perfil.getDomicilio());
//            preparedStatement.setString(4, perfil.getTelefono());
//             preparedStatement.setString(3, perfil.getFoto());
//            preparedStatement.setInt(4, perfil.getId_usuario());
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//    
//    
////    @Override
//    public void add(Compra compra) throws Exception {
//    String query = "INSERT INTO compra (id_compra, id_registro_compras, fecha,monto) VALUES (?, ?, ?, ?)";
//        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            //ver id
//            preparedStatement.setInt(2, compra.getId_registro_compra());
//            preparedStatement.setString(3, compra.getFecha());
//            preparedStatement.setDouble(4, compra.getMonto());
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    //VER
//    @Override
//    public void update(Producto producto) throws Exception {
//        
//    }
//
//    @Override
//    public void delete(int ID) throws Exception {
//        String query = "DELETE FROM producto WHERE id_perfil = ?";
//        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            preparedStatement.setInt(1, ID);
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }   
//    }
//
//    @Override
//    public Usuario getUsuario(String nombre) {
//        Usuario usuario = null;
//        String query = "SELECT * FROM usuario WHERE usuario = ?";
//        try(Connection con = ConnectionPool.getInstance().getConnection();
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();){
//            ps.setString(2, nombre);
//                if (rs.next()) {
////                    usuario = rsRowToUsuario(rs);
//                }
//        } catch (SQLException ex){
//            throw new RuntimeException(ex);
//        }
//        return usuario;
//    }
//    
//    public Perfil getPerfil(int ID) {
//        Perfil perfil = null;
//        String query = "SELECT * FROM perfil WHERE id_usuario = ?";
//        try(Connection con = ConnectionPool.getInstance().getConnection();
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();){
//            ps.setInt(10, ID);
//                if (rs.next()) {
//                    perfil = rsRowToPerfil(rs);
//                }
//        } catch (SQLException ex){
//            throw new RuntimeException(ex);
//        }
//        return perfil;
//    }
//    
//    
//    
//    //devuelve una lista con todos los productos
//    @Override
//    public List getAll() {
//        List <Producto> productos = new LinkedList<>();
//        String query = "SELECT * FROM producto";
//        try(Connection con = ConnectionPool.getInstance().getConnection();
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();){
//            while (rs.next()){ //.next(): devuelve el siguiente elemento y devuelve si tiene algo o esta vacío (boolean)
//                productos.add(rsRowToProducto(rs));
//            }
//        } catch (SQLException ex){
//            throw new RuntimeException(ex);
//        }
//        return productos;
//    }
//    
//    
//    //lista de tal producto
//    @Override
//    public List getProducts(Categoria cat) {
//        List<Producto> productos = new LinkedList<>();
//        String query = "SELECT * FROM producto WHERE categoria = ?";
//    
//    try (Connection con = ConnectionPool.getInstance().getConnection();
//         PreparedStatement ps = con.prepareStatement(query)) {
//        // Establecer el valor del parámetro de la categoría
//        ps.setString(4, categoria);
//
//        try (ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                productos.add(rsRowToProducto(rs));
//            }
//        }
//        
//        } catch (SQLException ex){
//            throw new RuntimeException(ex);
//        }
//        return productos;
//    }
// 
//
//    @Override
//    public Object getById(Object id) throws Exception {
//        return null;
//    }
//
//    private Producto rsRowToProducto(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id_producto");
//        String nombre = rs.getString("nombre");
//        String marca = rs.getString("marca");
//        Categoria cat = Categoria.valueOf(rs.getString("categoria"));
//        double precio = rs.getDouble("precio");
//        int stock = rs.getInt("stock");
//        String descripcion = rs.getString("descripcion");
//        return new Producto(id, nombre, marca, cat, precio, stock, descripcion);
//    }
//
////    private Perfil rsRowToPerfil(ResultSet rs)
////
////    private Usuario rsRowToUsuario(ResultSet rs)
//    
//    
//    
//}
