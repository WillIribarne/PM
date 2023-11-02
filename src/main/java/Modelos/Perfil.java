
package Modelos;

public class Perfil {
    private int id_perfil;
    private String nombre;
    private String apellido;
    private String fecha; //modificar
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
        this.fecha = fecha;
        this.email = email;
        this.billetera = 0;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = foto;
        this.id_usuario = 0;
    }

    public boolean verificacionDatos (String nombre, String apellido, String fecha, String email, String domicilio, String telefono, String foto) {
        return(nombre!= null   &&
               apellido!=null  &&
               fecha!=null     &&
               email!= null) ;          
    }
    
    
    
    
}
