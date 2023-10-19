/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Agustina
 */
public class UsuarioDAO {

    public Usuario autenticar(String nombre, String pass) {
        Usuario u = null;
        if (pass.equals("123")) {
            switch (nombre) {
                case "homero":
                    u = new Usuario(nombre, pass);
                    break;
                case "bart":
                    u = new Usuario(nombre, pass);
            }
        }
        return u;
    }
    
    
    
}
