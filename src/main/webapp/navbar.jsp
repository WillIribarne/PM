<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-dark navbar-expand-lg bg-negro">
    <div class="container-fluid">
        <a class="navbar-brand fuente-navbar-brand" href="./">PM</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar mx-2" href="./">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar mx-2" href="info">Quienes Somos</a>
                </li>
                <li class="nav-item dropdown mx-2">
                    <a class="nav-link dropdown-toggle fuente-navbar-estandar" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Catálogo</a>
                    <ul class="dropdown-menu bg-dark">
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Zapatillas</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Ojotas</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Zapatos</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Pantalones</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Polleras</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Remeras</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Camperas</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Buzos</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Guantes</a></li>
                        <li><a class="dropdown-item fuente-navbar-estandar" href="#">Gorros</a></li>
                    </ul>
                <li class="nav-item"> <!-- Este debería ser un choose entre el boton Iniciar Sesión y el nombre del perfil del usuario logueado -->
                    <a class="nav-link fuente-navbar-estandar me-5" href="inicioSesion">Iniciar Sesión</a>
                </li>
                </li>
            </ul>
            <span class="d-flex fuente-navbar-estandar me-2">¿No tienes cuenta?</span>
            <a href="registro">Registrate</a>
        </div>
    </div>
</nav>