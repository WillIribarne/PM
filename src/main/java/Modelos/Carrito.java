
package Modelos;

import java.util.LinkedList;
import java.util.List;

public class Carrito {
   private List <Producto> carr;
   private double precio;

    public Carrito(List <Producto> carrito) {
        this.carr = new LinkedList<>();
        this.precio = 0;
    }

    public Carrito() {
    }
    
    public List addProductoAlCarrito (Producto p){
        if(carr.isEmpty()){
            List <Producto> carrito = new LinkedList<>();
        }
        
        carr.add(p);
        
        return carr;
        
    }

    public boolean estaVacio(){
        return (carr.isEmpty());
    }
    public void modificarCosto (double precioAgregado){
        this.precio=this.precio+precioAgregado;
    }
    
    public void modificarCosto (){
        this.precio=0;
    }
    
    public List<Producto> getCarr() {
        return carr;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void vaciarCarrito (){
        
    }
                    
}
