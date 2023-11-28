
package Modelos;

import java.util.LinkedList;
import java.util.List;

public class Producto {
   private int id_producto;
   private String nombre;
   private String marca;
   private Categoria cat;
   private double precio;
   private int stock;
   private String descripcion;
   

    public Producto(int id_producto, String nombre, String marca, Categoria cat, double precio, int stock, String descripcion) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.cat = cat;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }
    
     public Producto() {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.cat = cat;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }
    
     public Producto(String nombre, String marca, Categoria cat, double precio, int stock, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.cat = cat;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }
     
    public int getId_producto() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public Categoria getCat() {
        return cat;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public int setCantidad() {
        return stock++;
    }
    
    public int setCantidad(int n) {
        return stock=n;
    }
      
    public int disminuirCantidad() {
        return stock--;
    }

    public void modificarEnLaBD(Producto p) throws Exception {
        ProductoDAO pDAO = new ProductoDAO();
         pDAO.update(p);
    }

    public Categoria devolverCategoria(String selectedValue) {
        Categoria cat = null;
       switch  (selectedValue){
           case "Zapatillas":
               cat=Categoria.Zapatillas;
               break;
           case "Ojotas":
               cat=Categoria.Ojotas;
                break;
            case "Zapatos":
                cat=Categoria.Zapatos;
                break;
            case "Pantalon":
                cat=Categoria.Pantalon;
                break;
            case "Pollera":
                cat=Categoria.Pollera;
                break;
            case "Remera":
                cat=Categoria.Remera;
                break;
            case "Campera":
                cat=Categoria.Campera;
                break;
            case "Buzo":
                cat=Categoria.Buzo;
                break;
            case "Guantes":
                cat=Categoria.Guantes;
                break;
            case "Gorro":
                cat=Categoria.Gorro;
                break;
             default:
                cat=Categoria.Gorro;
                break;
       }
       
       return cat;
    }
    
    
 }
