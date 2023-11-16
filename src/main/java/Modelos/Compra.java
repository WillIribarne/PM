
package Modelos;

import java.sql.Date;

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
    
    
    
}
