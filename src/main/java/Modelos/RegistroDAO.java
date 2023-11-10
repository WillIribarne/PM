
package Modelos;

public class RegistroDAO {
    public boolean existeRegistro(String user){
        boolean flag=false;
        
        switch (user){
            case "juan":
                flag=true;
                break;
            case "user1":
                flag=true;
                break;
            case "user2":
                flag=true;
                break;
        }
        
        return flag;
    }
}
