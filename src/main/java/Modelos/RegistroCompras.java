
package Modelos;

import java.util.List;

public class RegistroCompras {
    private int id_registro_compras;
    private int id_perfil;

    public RegistroCompras() {
        this.id_registro_compras = id_registro_compras;
        this.id_perfil = id_perfil;
    }

    public RegistroCompras(int id) {
        this.id_perfil = id;
    }

    public RegistroCompras(int id_registro_compras, int id_perfil) {
        this.id_registro_compras = id_registro_compras;
        this.id_perfil = id_perfil;
    }

    public void setId_registro_compras(int id) {
        this.id_registro_compras = id;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getId_registro_compras() {
        return id_registro_compras;
    }

    public int getId_perfil() {
        return id_perfil;
    }
    
    public void getRegistroDeCOmpras(){
       //HACER
    }

}
