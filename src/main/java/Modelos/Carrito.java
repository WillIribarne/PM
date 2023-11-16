
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

    public void setCarr(List<Producto> carr) {
        this.carr = carr;
    }
    
    public boolean existeEnLaLista(){
       boolean flag=false;
       
        return flag;
    }
    
    public void modificoLaCantidad(Producto p){
        p.setCantidad();
    }
    
    public void valeUnoLaCantidad(Producto p){
        p.setCantidad(1);
    }
    
    public boolean chequeo(Producto p){
        boolean flag=false;
        for(Producto x : carr){
            if(x.getId_producto()==p.getId_producto()){
                flag=true;
                modificoLaCantidad(x); //aumento el contador de cantidad
            }
        }
        
        if(flag==false) valeUnoLaCantidad(p);
        
        return flag;
    }
    
    public List addProductoAlCarrito (Producto p){
        if(carr.isEmpty()){
            List <Producto> carrito = new LinkedList<>();
        }
        
        //chequeo si ya existe en la lista
        boolean f=chequeo(p);
        
        //lo agrego
        if(f==false){
            carr.add(p);
        }
          
        return carr;
    }

    public boolean estaVacio(){
        return (carr.isEmpty());
    }
    public void modificarCosto (double precioAgregado){
        this.precio=this.precio+precioAgregado;
    }
    
    public void modificarCostoACero (){
        this.precio=0;
    }
    
    public List<Producto> getCarr() {
        return carr;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void resetPrecio() {
        this.precio=0;
    }
    
    public void vaciarCarrito (){
        carr.clear();
    }
    
    public void devolverAlCarrito(List <Producto> carritoDevuelto){
        for (Producto p : carritoDevuelto){
            addProductosDevueltos(p);         
       }
    }
    
    public void addProductosDevueltos (Producto p){
        for(Producto x : carr){
            if(x.getId_producto()==p.getId_producto()){                
                modificoLaCantidad(x); //aumento el contador de cantidad
            }
        }
    }   
}
