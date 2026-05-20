package Servicios;

import io.javalin.http.Context;
import Modelos.Usuario;
import java.util.HashMap;
import java.util.Map;

public class sesion {
    public static Map<String, Object> crearModeloBase(Context ctx) {
        Map<String, Object> modelo = new HashMap<>();

        Usuario user = ctx.sessionAttribute("userLogueado");

        modelo.put("userLogueado", user);
        modelo.put("perfilLogueado", ctx.sessionAttribute("perfilLogueado"));
        modelo.put("tipoUser", ctx.sessionAttribute("tipoUser"));
        modelo.put("usuarioIngresado", user != null);

        return modelo;
    }
}
