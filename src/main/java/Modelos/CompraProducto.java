
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

    public CompraProducto(int id_compra_producto, int compra_id_compra, int producto_id_producto, int cantidad) {
        this.id_compra_producto = id_compra_producto;
        this.compra_id_compra = compra_id_compra;
        this.producto_id_producto = producto_id_producto;
        this.cantidad = cantidad;
    }
    
    
}
