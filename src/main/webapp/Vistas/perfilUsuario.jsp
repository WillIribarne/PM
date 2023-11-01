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
            <p class="text-light text-center">PERFIL DEL USUARIO</p>
            <p class="text-light text-center">Nombre: ${userLogueado.nombre}</p>
            <p class="text-light text-center">Apellido:</p>
            <p class="text-light text-center">Fecha:</p>
            <p class="text-light text-center">Domicilio:</p>
            <p class="text-light text-center">Telefono:</p>
            <p class="text-light text-center">FOTO:</p>
    </div>
</div>

<button type="submit" class="btn btn-primary">Cerrar Sesion</button>
<c:import url="/footer.jsp" />
</body>
</html>
