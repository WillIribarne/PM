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
        <p class="text-light text-center">Felicitaciones! Su usuario ha sido creado</p>
        <p class="text-light text-center">Haga click <a href="inicioSesion">aquí</a> para iniciar sesión.</p>
    </div>
</div>
<c:import url="/footer.jsp" />
</body>
</html>
