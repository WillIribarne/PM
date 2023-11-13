<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Tu Tienda de Moda"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
    <div class="container rounded-5 bg-negro p-5 my-5">
        <div class="row align-items-center"
            <h1 class="text-light m-5">${mensajeError}</h1>>
            <c:choose>
            <c:when test="${hayError}">
                <h1 class="text-light m-5">"MUCHAS GRACIAS POR COMPRAR EN PROGRAMODA! - Su compra se realizo con exito</h1>
            </c:when>
            <c:when test="${not hayError}">> <!-- cuando billetera < precio -->
                <div class="col-md-8">
                    <p class="fs-1 text-light text-center m-5">ERROR - No se pudo realizar la compra debito a que tu billetera no dispone del saldo necesario para realizar la compra</p>
                </div>
                <div class="col-md-2">
                    <a class="btn btn-lg btn-success"  href="billetera" role="button">Agregar dinero</a>
                    <a class="btn btn-lg btn-success"  href="" role="button">Volver al carrito</a>
                </div>
            </c:when>
            <c:otherwise>
                <h1 class="text-light text-center m-5">Ocurrió un error inesperado. Intentalo nuevamente.</h1>
            </c:otherwise>
        </c:choose>
        </div>
        <div class="row">
            <div class="col-md-6 d-flex justify-content-center">
                <a class="btn btn-secondary btn-lg fuente-botones-index m-xl-5 my-3" href="./" role="button">Volver a Inicio</a>
            </div>
            <div class="col-md-6 d-flex justify-content-center">
                <a class="btn btn-warning btn-lg fuente-botones-index m-xl-5 my-3" href="catalogo" role="button">Ir a catálogo</a>
            </div>
        </div>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>