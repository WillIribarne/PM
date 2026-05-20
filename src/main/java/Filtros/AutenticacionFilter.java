package filtros;

import io.javalin.http.Context;
import Modelos.Usuario;

public class AutenticacionFilter {

    // Filtro para rutas que requieren CUALQUIER usuario logueado
    public static void verificarUsuarioLogueado(Context ctx) {
        Usuario user = ctx.sessionAttribute("userLogueado");

        if (user == null) {
            ctx.redirect("/inicioSesion");
        }
    }

    // Filtro para rutas exclusivas de ADMINISTRADOR
    public static void verificarAdministrador(Context ctx) {
        Usuario user = ctx.sessionAttribute("userLogueado");
        Integer tipoUser = ctx.sessionAttribute("tipoUser"); // 2 = Admin, 1 = Final

        if (user == null || tipoUser == null || tipoUser != 2) {
            ctx.redirect("/");
        }
    }
}