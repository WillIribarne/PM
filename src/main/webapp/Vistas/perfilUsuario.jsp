<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
<c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Perfil"/>
</c:import>
<body>
<c:import url="/navbar.jsp" />
<div class="container bg-negro p-5 my-5">
    <div class="row m-5 justify-content-between">
        <div class="d-flex align-items-start">
            <p class="text-light text-center fs-1 fw-bolder">Perfil del usuario</p>
        </div>
        <div>
            <img src="recursos/imgs/PM-Index.jpeg" width="120" height="120"> <!-- esto es la foto -->
        </div>
    </div>
    <div class="row m-5">
        <div class="col-md-6">
            <h2>
                <p class="badge text-bg-light">Nombre Completo:</p>
                <p class="text-light">${userLogueado.nombre}</p>
                <!-- <p class="text-light text-center">Apellido:</p> (esto es medio al pedo, mejor poner nombre completo) -->
            </h2>
            <h4>
                <p class="badge text-bg-light">Email:</p>
                <p class="text-light">juanCaballo@horse.com</p>
                <p class="badge text-bg-light">Domicilio:</p>
                <p class="text-light">Mojo Dojo Casa House</p>
            </h4>
        </div>
        <div class="col-md-6">
            <h4>
                <p class="badge text-bg-light">Fecha de nacimiento:</p>
                <p class="text-light">5/4/1999</p>
                <p class="badge text-bg-light">Teléfono:</p>
                <p class="text-light">0303456</p>
            </h4>
            <div class="container rounded-pill bg-light">
                <div class="row text-center">
                    <h1><p class="m-2">Billetera: <span class="fw-bold">$2,00</span></p></h1>
                </div>
            </div>
            <div class="d-flex justify-content-end m-2">
                <button type="button" class="btn btn-success" href="billetera">Agregar dinero</button>
            </div>
        </div>
    </div>
    <div class="row m-5">
        <div class="col-md-6">
            <a class="btn btn-primary btn-lg fuente-botones-index" href="" role="button">Editar Perfil</a>
        </div>
        <div class="col-md-6 d-flex justify-content-end">
            <a class="btn btn-secondary btn-lg fuente-botones-index" href="cerrarsesion" role="button">Cerrar Sesión</a>
        </div>
    </div>
</div>

<c:import url="/footer.jsp" />
</body>
</html>
