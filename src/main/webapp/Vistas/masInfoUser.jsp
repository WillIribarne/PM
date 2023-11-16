<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  <p class="fuente-botones-index">Compras de ${perfilLogueado.nombre} ${perfilLogueado.apellido}</p>
  <div class="table-responsive">
<p class="badge text-bg-light">Numero de compra: ${registroCompras.id_compra}</p>
<p class="badge text-bg-light">Fecha: ${registroCompras.fecha}</p>
<p class="badge text-bg-light">Valor de la compra: ${registroCompras.monto}</p>

    <table class="table table-dark table-hover">
        <thead>
          <tr>
            <th scope="col">Productos</th>
            <!--<th scope="col">Cantidad</th> -->
          </tr>
        </thead>
        <tbody class="table-group-divider">
          <c:forEach items="${productosSeleccionados}" var="prod">  
            <tr>
              <th scope="row">${prod.nombre}</th>
             <!-- <td>${prod.cantidad}</td>-->
            </tr>
          </c:forEach>
        </tbody> 
    </table>
  </div>
<c:import url="/footer.jsp"/>
</body>
</html>