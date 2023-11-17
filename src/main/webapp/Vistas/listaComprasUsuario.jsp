<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  <p class="fuente-botones-index">Compras realizadas por: ${perfilLogueado.nombre}  ${perfilLogueado.apellido}</p>
  <div class="table-responsive">

    <table class="table table-dark table-hover">
        <thead>
          <tr>
            <th scope="col">Numero de compra</th>
            <th scope="col">Fecha</th>
            <th scope="col">Valor de la compra</th>
          </tr>
        </thead>
        <tbody class="table-group-divider">
          <c:forEach items="${registroCompras}" var="reg">  
            <tr>
              <th scope="row">${reg.id_compra}</th>
              <td>${reg.fecha}</td>
              <td>$ ${reg.monto}</td>
            </tr>
          </c:forEach>
        </tbody> 
    </table>
  </div>
<c:import url="/footer.jsp"/>
</body>
</html>