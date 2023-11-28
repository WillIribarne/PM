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
                
                <!--
                <%--
                <c:choose>
                        <c:when test="${tipoUser==2}"> 
                            <li class="nav-item">
                             <a class="nav-link fuente-navbar-estandar mx-2" href="catalogoAdmin">Catalogo</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                             <li class="nav-item">
                             <a class="nav-link fuente-navbar-estandar mx-2" href="catalogo">Catalogo</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                 --%>           ******VIENE LO NUEVOOO*****
                  -->          
                <li class="nav-item">
                    <a class="nav-link fuente-navbar-estandar mx-2" href="catalogoropa">Catalogo</a>
                </li>
                            
                
                <li class="nav-item"> 
                    <c:choose>
                        <c:when test="${usuarioIngresado}"> 
                            <a class="nav-link fuente-navbar-estandar me-5" href="perfil">Hola ${perfilLogueado.nombre} ${perfilLogueado.apellido} :)</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link fuente-navbar-estandar me-5" href="inicioSesion">Iniciar Sesión</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                
               <c:choose>
                <c:when test="${usuarioIngresado && tipoUser==1}">
                    <li class="nav-item">
                        <a class="nav-link fuente-navbar-estandar me-5" href="billetera">Billetera: $ ${perfilLogueado.billetera} </a>
                        </li>
                </c:when>
                </c:choose>
            
            </ul>
            <c:choose>
                <c:when test="${usuarioIngresado}">
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