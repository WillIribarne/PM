<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
<c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Perfil"/>
</c:import>
<body>
<c:import url="/navbar.jsp" />
<div class="container bg-negro p-md-5 my-5">
    <div class="d-flex align-items-start m-5">
        <p class="text-light text-center fs-1 fw-bolder">Mi perfil: ${userLogueado.nombre}</p>
    </div>
    <div class="row m-5 justify-content-between">
        <div class="col-md-6">                                                           
            <img src="recursos/imgs/PM-Index.jpeg" width="120" height="120"> <!-- esto es la foto -->
        </div>
        <div class="col-md-6 d-flex justify-content-end my-2 py-md-4">
            <a class="btn btn-info btn fs-4 fw-bold" href="" role="button">Ver compras anteriores</a>
        </div>
    </div>
    <div class="row m-5">
        <div class="col-md-6">
            <h2>
                <p class="badge text-bg-light">Nombre Completo: </p>
                <p class="text-light">${perfilLogueado.nombre}  ${perfilLogueado.apellido}</p>
            </h2>
            <h4>
                <p class="badge text-bg-light">Email:</p>
                <p class="text-light">${perfilLogueado.email}</p>
                <p class="badge text-bg-light">Domicilio:</p>
                <p class="text-light">${perfilLogueado.domicilio}</p>
            </h4>
        </div>
        <div class="col-md-6">
            <h4>
                <p class="badge text-bg-light">Fecha de nacimiento:</p>
                <p class="text-light">${perfilLogueado.fechaNac}</p>
                <p class="badge text-bg-light">Teléfono:</p>
                <p class="text-light">${perfilLogueado.telefono}</p>
            </h4>
            <div class="container rounded-pill bg-light">
                <div class="row text-center">
                    <h1><p class="m-2">Billetera: <span class="fw-bold">${perfilLogueado.billetera}</span></p></h1>
                </div>
            </div>
            <div class="d-flex justify-content-end m-2">
                <a class="btn btn-success" href="billetera" role="button">Agregar dinero</a>
             </div>
        </div>
    </div>
    <div class="row m-5 justify-content-between">
        <div class="col-md-6">
            <a class="btn btn-primary btn-lg fuente-botones-index my-2" href="" role="button">Editar Perfil</a>
        </div>
        <div class="col-md-6">
            <a class="btn btn-secondary btn-lg fuente-botones-index my-2" href="cerrarsesion" role="button">Cerrar Sesión</a>
        </div>
    </div>
</div>

<c:import url="/footer.jsp" />
</body>
</html>