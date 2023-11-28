
package Modelos;

import java.sql.Date;
import java.util.List;

public class Perfil {
    private int id_perfil;
    private String nombre;
    private String apellido;
    private String fechaNac; //modificar
    private String email;
    private double billetera;
    private String domicilio;
    private String telefono;
    private String foto; //ver
    private int id_usuario=0;
    int cont=0;
    
    public Perfil(String nombre, String apellido, String fecha, String email, String domicilio, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fecha;
        this.email = email;
        this.billetera = 0;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = "foto";
    }
    
    public Perfil(Perfil p, int ID) {
        this.nombre = p.nombre;
        this.apellido = p.apellido;
        this.fechaNac = p.fechaNac;
        this.email = p.email;
        this.billetera = 0;
        this.domicilio = p.domicilio;
        this.telefono = p.telefono;
        this.foto =foto;
        this.id_usuario=ID;
    }
    
    public Perfil(Perfil p) {
        this.nombre = p.nombre;
        this.apellido = p.apellido;
        this.fechaNac = p.fechaNac;
        this.email = p.email;
        this.billetera = 0;
        this.domicilio = p.domicilio;
        this.telefono = p.telefono;
       this.foto = "foto";
        this.id_usuario=p.id_perfil;
    }

    public Perfil(int id_perfil, String nombre, String apellido, String fechaNac, String email, double billetera, String domicilio, String telefono,String foto,int id_usuario) {
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.billetera = billetera;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = foto;
        this.id_usuario=id_usuario;
    }
    
    public Perfil() {

    }


    public void setBilletera(double billetera) {
        this.billetera = billetera;
    }
    
    public boolean sonCorrectosLosDatos (Perfil p) {
        boolean flag;
        
        flag = !(p.nombre.isEmpty() || p.apellido.isEmpty());
        return flag;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public double getBilletera() {
        return billetera;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFoto() {
        return foto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getCont() {
        return cont;
    }
    
//    public List retortaCatalogo(){
//        
//    }
    
    
}
