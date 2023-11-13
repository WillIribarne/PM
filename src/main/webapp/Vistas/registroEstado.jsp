<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
<c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Tu negocio de moda"/>
</c:import>
<body>
<c:import url="/navbar.jsp" />

<div class="container bg-negro p-5 my-5">
    <div class="row justify-content-center m-5">
            
        <!-- registro exitoso o no -->
        <c:if test="${mensaje}">
        <div class="container text-light">
            <h3>${mensajeInfo}</h3>
        </div>
        </c:if>
           
        <!-- opcion de enlace a mostrar -->
        <c:choose>
        <c:when test="${mensajeInfo == 'Felicitaciones! Su usuario ha sido creado con éxito'}">
            <p class="text-light text-center">Haga click <a href="inicioSesion">aquí</a> para iniciar sesión.</p>
        </c:when>
        <c:otherwise>
            <p class="text-light text-center">Haga click <a href="registro">aquí</a> para volver a registrarse.</p>
        </c:otherwise>
        </c:choose>

 </div>
</div>
<c:import url="/footer.jsp" />
</body>
</html>
