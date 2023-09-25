<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-dark navbar-expand-lg bg-negro">
    <div class="container-fluid">
        <a class="navbar-brand fuente-navbar-brand" href="#">PM</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar mx-2" href="#">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar mx-2" href="#">Quienes Somos</a>
                </li>
                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle fuente-navbar-estandar" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Catálogo
                    </a>
                    <ul class="dropdown-menu bg-dark">
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Categorías</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Etiquetas</a></li>
                    </ul>
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar me-5" href="#">Iniciar Sesión</a>
                </li>
                </li>
            </ul>
            <span class="d-flex fuente-navbar-estandar me-2">¿No tienes cuenta?</span>
            <a href="RegistroServlet">Registrate</a>
        </div>
    </div>
</nav>