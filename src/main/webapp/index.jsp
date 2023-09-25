<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="header.jsp">
    <c:param name="tituloPagina" value="PM - Tu negocio de moda"/>
  </c:import>
<body>
<c:import url="navbar.jsp" />
<div class="container-fluid m-0 p-0 g-0 bg-verde">
  <div class="row align-items-start">
    <div class="col-md-6 p-0">
      <img src="imgs/PM-Index.jpeg" class="img-fluid" alt="">
    </div>
    <div class="col-md-6 p-0 bg-verde">
      <div class="text-center p-0">
        <div class="row">
          <div class="container">
            <button type="button" class="btn btn-secondary btn-lg m-l-5 m-md-4 m-sm-3 m-2 p-xl-5 p-md-4 p-sm-3 p-2 fuente-botones-index">Ver catálogo</button>
          </div>
          <div class="container">
            <button type="button" class="btn btn-secondary btn-lg m-l-5 m-md-4 m-sm-3 m-2 p-xl-5 p-md-4 p-sm-3 p-2 fuente-botones-index">Sobre nosotros</button>
          </div>
          <div class="container">
            <button type="button" class="btn btn-secondary btn-lg m-l-5 m-md-4 m-sm-3 m-2 p-xl-5 p-md-4 p-sm-3 p-2 fuente-botones-index">Otro boton falopa</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
