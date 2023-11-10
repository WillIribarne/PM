
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductoDAO implements DAO{
    List <Producto> productos;

    public ProductoDAO() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void create(Object entidad) throws Exception {

    }

    @Override
    public void add(Object entidad) throws Exception {

    }

    @Override
    public void update() throws Exception {

    }

    @Override
    public void delete() throws Exception {

    }

    @Override
    public List getAll() {
        List <Producto> productos = new LinkedList<>();
        String query = "SELECT * FROM recetas";
        try(Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();){
            while (rs.next()){ //.next(): devuelve el siguiente elemento y devuelve si tiene algo o esta vacío (boolean)
                productos.add(rsRowToProducto(rs));
            }
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return productos;
    }

    @Override
    public Object getById(Object id) throws Exception {
        return null;
    }

    private Producto rsRowToProducto(ResultSet rs) throws SQLException {
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
