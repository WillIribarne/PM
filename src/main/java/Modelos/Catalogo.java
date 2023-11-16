/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Agustina
 */
public class Catalogo {
   private List <Producto> catalogo;

    public Catalogo(List <Producto> cat) {
        this.catalogo = new LinkedList<>();
    }

    public Catalogo() {
    }

    public void setCatalogo(List<Producto> catalogo) {
        this.catalogo = catalogo;
    }
    
    public void aumentoStock(int id) {
        for (Producto p : catalogo){
            if(p.getId_producto()==id){
                p.setCantidad(); //aumento el stock
            }
        }
    }
   
    public void disminuyoStock(int id) {
        for (Producto p : catalogo){
            if(p.getId_producto()==id){
                p.disminuirCantidad(); //disminuyo el stock
            }
        }
    }
    
    
    
    //añado producto al catalogo
    
    //aumento stock
    
    //disminuyo stock
    
//    public boolean existeEnLaLista(){
//       boolean flag=false;
//       
//        return flag;
//    }
//    
    public void modificoLaCantidad(Producto p){
        p.setCantidad();
    }
//    
//    public void valeUnoLaCantidad(Producto p){
//        p.setCantidad(1);
//    }
//    
//    public boolean chequeo(Producto p){
//        boolean flag=false;
//        for(Producto x : carr){
//            if(x.getId_producto()==p.getId_producto()){
//                flag=true;
//                modificoLaCantidad(x); //aumento el contador de cantidad
//            }
//        }
//        
//        if(flag==false) valeUnoLaCantidad(p);
//        
//        return flag;
//    }
//    
//    public List addProductoAlCarrito (Producto p){
//        if(carr.isEmpty()){
//            List <Producto> carrito = new LinkedList<>();
//        }
//        
//        //chequeo si ya existe en la lista
//        boolean f=chequeo(p);
//        
//        //lo agrego
//        if(f==false){
//            carr.add(p);
//        }
//          
//        return carr;
//    }
//
//    public boolean estaVacio(){
//        return (carr.isEmpty());
//    }
//    public void modificarCosto (double precioAgregado){
//        this.precio=this.precio+precioAgregado;
//    }
//    
//    public void modificarCosto (){
//        this.precio=0;
//    }
//    
//    public List<Producto> getCarr() {
//        return carr;
//    }
//
//    public double getPrecio() {
//        return precio;
//    }
//    
//    public void resetPrecio() {
//        this.precio=0;
//    }
//    
//    public void vaciarCarrito (){
//        carr.clear();
//    }
//    
    public void devolverAlCatalogo(List <Producto> carritoDevuelto) throws Exception{
        for (Producto p : carritoDevuelto){    
       for(Producto x : catalogo){
            if(x.getId_producto()==p.getId_producto()){                
                x.setCantidad(x.getStock()+p.getStock()); //aumento el contador de cantidad
//                x.modificarEnLaBD();
//                //lo modifico en la BD
            }           
            }
        }
        
        modificarEnLaBD();
    }
    
 
    public List<Producto> getCatalogo() {
        return catalogo;
    }

    private void modificarEnLaBD() throws Exception {
      for(Producto p : catalogo){
             p.modificarEnLaBD(p);
         }
    }
}
