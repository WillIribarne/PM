<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Tu negocio de moda"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp" />
    <div class="container bg-negro p-5 my-5 rounded-pill">
      <div class="row justify-content-center m-5">
        <div class="col">
          <h1 class="text-light text-center m-5 fuente-titulo-quienesSomos">Somos PM</h1>
          <p class="text-light text-center">Un microemprendimiento desarrollado por alumnos de 2° año de programacion de UTN-INSPT</p>
        </div>
      </div>
    </div>
  <c:import url="/footer.jsp" />
</body>
</html>