
package Modelos;

public class Compra {
    private int id_compra;
    private int id_registro_compra;
    private Fecha fecha;
    private float monto;

    public Compra() {
        this.id_compra = id_compra;
        this.id_registro_compra = id_registro_compra;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Compra(int id_compra, int id_registro_compra, Fecha fecha, float monto) {
        this.id_compra = id_compra;
        this.id_registro_compra = id_registro_compra;
        this.fecha = fecha;
        this.monto = monto;
    }
    
    
    
}
