
package Modelos;

import java.sql.Date;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compra {
    private int id_compra;
    private int id_registro_compra;
    private String fecha;
    private double monto;

    public Compra() {
        this.id_compra = id_compra;
        this.id_registro_compra = id_registro_compra;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Compra(int id_compra, int id_registro_compra, String fecha, double monto) {
        this.id_compra = id_compra;
        this.id_registro_compra = id_registro_compra;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Compra(int id, String fec, double m) {
        this.id_registro_compra = id;
        this.fecha = fec;
        this.monto = m;
    }

    public int getId_compra() {
        return id_compra;
    }

    public int getId_registro_compra() {
        return id_registro_compra;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
    
    public List obtenerComprasDelUser(List<RegistroCompras> reg_compras){
        List <Compra> compras = new LinkedList<>();
        Compra c = new Compra();
        CompraDAO cDAO = new CompraDAO();
        
        for (RegistroCompras rc : reg_compras){ try {
            //x cada registrocompra hay una compra
            compras.add(cDAO.getRegistroCompra(rc.getId_registro_compras()));
            } catch (Exception ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        return compras;
    }

    public void invertir(List<Compra> compra) {
        Collections.reverse(compra);
    }
    
    public List getProductoComprados (int boton, List <CompraProducto> lista){
        List <Producto> productosComprados = new LinkedList<>();
        ProductoDAO pDAO = new ProductoDAO();
        
        for(CompraProducto l : lista){
            if(l.getId_compra_producto()==boton){
                try {
                    productosComprados.add(pDAO.get(l.getProducto_id_producto()));
                } catch (Exception ex) {
                    Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return productosComprados;
    }
    
    
}
