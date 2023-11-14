
package Modelos;

public class CompraProducto {
    private int id_compra_producto;
    private int compra_id_compra;
    private int producto_id_producto;
    private int cantidad;

    public CompraProducto() {
        this.id_compra_producto = id_compra_producto;
        this.compra_id_compra = compra_id_compra;
        this.producto_id_producto = producto_id_producto;
        this.cantidad = cantidad;
    }

    public CompraProducto( int id_compra, int id_producto, int cant) {
        this.compra_id_compra = id_compra;
        this.producto_id_producto = id_producto;
        this.cantidad = cant;
    }

    public int getId_compra_producto() {
        return id_compra_producto;
    }

    public int getCompra_id_compra() {
        return compra_id_compra;
    }

    public int getProducto_id_producto() {
        return producto_id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
}
