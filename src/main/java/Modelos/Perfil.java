
package Modelos;

public class Perfil {
    private int id_perfil;
    private String nombre;
    private String apellido;
    private Fecha fecha; //agregar
    private String email;
    private float billetera;
    private String domicilio;
    private String telefono;
    private String foto; //ver
    private int id_usuario;
    int cont=0;
    
    public Perfil(int id_perfil, String nombre, String apellido, Fecha fecha, String email, float billetera, String domicilio, String telefono, String foto, int id_usuario) {
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.email = email;
        this.billetera = 0;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = foto;
        this.id_usuario = id_usuario;
    }

    public Perfil autenticar (String nombre, String apellido, Fecha fecha, String email, String domicilio, String telefono, String foto) {
        
        Perfil p = null;
        
        id_perfil=cont;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.email = email;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto = foto;
        id_usuario=cont;
        
        cont++;
          
        return p;
        
    }
    
    
    
    
    
}
