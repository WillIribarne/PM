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
        
        <!-- opcion de enlace a mostrar -->
        <c:choose>
        <c:when test="${mensajeInfo == false}">
            <p class="text-light text-center"> Se creó con éxito el usuario. Haga click <a href="producto">aquí</a> para agregar otro producto o <a href="catalogoropa">aquí</a> para ver el catalogo.</p>
        </c:when>
        <c:otherwise>
            <p class="text-light text-center"> Se modificó con éxito el usuario. Haga click <a href="catalogoropa">aquí</a> para volver al catalogo.</p>
        
        </c:otherwise>
        </c:choose>

 </div>
</div>
<c:import url="/footer.jsp" />
</body>
</html>
