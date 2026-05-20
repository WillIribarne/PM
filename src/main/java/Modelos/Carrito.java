package Modelos;

import java.util.LinkedList;
import java.util.List;

public class Carrito {
    private List<Producto> carr;
    private double precio;

    public Carrito() {
        this.carr = new LinkedList<>();
        this.precio = 0;
    }

    public void addProductoAlCarrito(Producto p, int cant) {
        boolean existe = false;
        // Chequeamos si ya está en el carrito
        for (Producto x : carr) {
            if (x.getId_producto() == p.getId_producto()) {
                x.aumentoCantidad(cant);
                existe = true;
                break;
            }
        }
        // Si no estaba, lo agregamos
        if (!existe) {
            p.setCantidad(cant);
            carr.add(p);
        }
        // Actualizamos el costo total
        this.precio += (p.getPrecio() * cant);
    }

    public boolean estaVacio() {
        return carr.isEmpty();
    }

    public void vaciarCarrito() {
        carr.clear();
        this.precio = 0;
    }

    public List<Producto> getCarr() { return carr; }
    public void setCarr(List<Producto> carr) { this.carr = carr; }
    public double getPrecio() { return precio; }
}
