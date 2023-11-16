<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-dark navbar-expand-lg bg-negro">
    <div class="container-fluid">
        <a class="navbar-brand fuente-navbar-brand" href="./">PrograModa</a>
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
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar mx-2" href="catalogo">Catalogo</a>
                </li>
                
                <li class="nav-item"> 
                    <c:choose>
                        <c:when test="${false}"> <!-- nota: {usuario.estadoLogin = 1} es lo mismo que un {true}, pero no se si es posible hacer 'x = boolean', por eso el 1-->
                            <a class="nav-link fuente-navbar-estandar me-5" href="perfil">${usuario.nombreCompleto}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link fuente-navbar-estandar me-5" href="inicioSesion">Iniciar Sesión</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <c:if test="${true}"> <!-- si el usuario está logueado, mostrar billetera-->
                    <li class="nav-item"> 
                        <span class="d-flex fuente-navbar-brand me-2">$ 2,00</span> <!-- ${usuario.billetera} -->
                    </li>
                    <li>
                        <button type="button" class="btn btn-light rounded-pill fw-bolder fs-4 py-0" href="billetera" >+</button>
                    </li>
                </c:if>
            </ul>
            <c:choose>
                <c:when test="${false}"> <!-- nota: {usuario.estadoLogin = 1} es lo mismo que un {true}, pero no se si es posible hacer 'x = boolean', por eso el 1-->
                <span class="d-flex fuente-navbar-brand me-2">Bienvenido a PrograModa</span>
                </c:when>
                <c:otherwise>
                    <span class="d-flex fuente-navbar-estandar me-2">¿No tienes cuenta?</span>
                    <a href="registro">Registrate</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>