
package Modelos;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String contrasenia;
    private String tipo; //cambiar en la bd

    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.tipo="final";
    }


    //falta chequear si existe o no el usuarii a crear
    
    public boolean sonCorrectosLosDatos(Usuario s){
        boolean flag;
        
        if(nombre.isEmpty() || contrasenia.isEmpty()){
            flag=false;  
        }
        else
        {
             flag=true;
        }
        
        return flag;
        //return (s.nombre!=null && s.contrasenia!=null);
    }
    
   

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    
    
}
