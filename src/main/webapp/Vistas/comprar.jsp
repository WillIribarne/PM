<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Comprar Producto"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  <div class="container bg-negro p-5 my-5">
    <div class="row">
      <div class="col-sm-6">
        <p class="text-light"> <span class="fw-bolder">Carrito</span> <span class="text-success"></span></p>
        <c:forEach items="${carrito.carr}" var="producto">
          <div class="bg-secondary my-2">
            <p class="text-light"><span class="badge fs-6 fw-bolder">Nombre: </span>${producto.nombre}</p>
            <p class="text-light"><span class="badge fs-6 fw-bolder">Marca: </span>${producto.marca}</p>
            <p class="text-light"><span class="badge fs-6 fw-bolder">Descripcion: </span>${producto.descripcion}</p>
            <p class="text-light"><span class="badge fs-6 fw-bolder">Precio: </span>${producto.precio}</p>
          </div>    
        </c:forEach>
      </div>
      <div class="col-md-6">
        <h2>
          <p class="text-light"> <span class="fw-bolder">Billetera:</span> <span class="text-success">${perfilLogueado.billetera}</span></p>
        </h2>
        <h2>
          <p class="text-light"> <span class="fw-bolder">Precio a pagar:</span> <span class="text-success">${carrito.precio}</span></p>
        </h2>
        <div class="d-flex justify-content-center">
          <c:choose>
            <c:when test="${mensajeError != null && mensajeError == 'No hay ningun producto en el carrito'}">
              <div class="container text-light">
                <h3>${mensajeError}</h3>
              </div>
              <a class="btn btn-lg btn-warning me-lg-5 me-2"  href="catalogo" role="button">Seguir viendo el catálogo</a>
            </c:when>
            <c:otherwise>
              <div class="text-center">
                <a class="btn btn-lg btn-success me-lg-5 my-3 p-md-2" href="catalogo" role="button">Comprar</a>
                <br>
                <a class="btn btn-lg btn-warning me-lg-5 mb-3 p-md-2" href="catalogo" role="button">Seguir viendo el catálogo</a>
                <br>
                <a class="btn btn-lg btn-danger me-lg-5 mb-3 p-md-2" href="catalogo" role="button">Vaciar carrito</a>
                <br>
              </div> 
            </c:otherwise>  
          </c:choose>
        </div>
      </div>
    </div>
  </div>
  <c:import url="/footer.jsp"/>
</body>
</html>