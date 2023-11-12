
package Modelos;

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
    
    
   
}
