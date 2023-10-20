<%-- 
    Document   : inicioSesionEstado
    Created on : 18 oct. 2023, 18:42:39
    Author     : Agustina
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
<c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Tu negocio de moda"/>
</c:import>
<body>
<c:import url="/navbar.jsp" />
<!-- Acá hay que usar un c:choose para modificar el contenido del .jsp (= si el registro fue exitoso o no) -->
<div class="container bg-negro p-5 my-5">
    <div class="row justify-content-center m-5">
        <p class="text-light text-center">Se ha iniciado sesion de manera correcta :)</p>
    </div>
</div>
<c:import url="/footer.jsp" />
</body>
</html>
