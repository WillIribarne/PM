
package Modelos;

public class Producto {
   private int id_producto;
   private String nombre;
   private String marca;
   private Categoria cat;
   private float precio;
   private int stock;
   private String descripcion;

    public Producto(int id_producto, String nombre, String marca, Categoria cat, float precio, int stock, String descripcion) {
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
   
}
