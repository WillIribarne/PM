
package Modelos;

public class Perfil {
    private int id_perfil;
    private String nombre;
    private String apellido;
    private String fechaNac; //modificar
    private String email;
    private float billetera;
    private String domicilio;
    private String telefono;
    private String foto; //ver
    private int id_usuario;
    int cont=0;
    
    public Perfil(String nombre, String apellido, String fecha, String email, String domicilio, String telefono, String foto) {
        this.id_perfil = 0;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fecha;
        this.email = email;
        this.billetera = 0;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = foto;
        this.id_usuario = 0;
    }

    public boolean verificacionDatos (Perfil p) {
        return(//nombre!= null   &&
               //apellido!=null  &&
               fechaNac!=null     &&
               email!= null) ;          
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

    public float getBilletera() {
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

    public int getCont() {
        return cont;
    }
    
    
    
    
}
