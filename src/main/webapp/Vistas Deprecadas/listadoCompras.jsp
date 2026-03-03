<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  
  <form action="${pageContext.request.contextPath}/listadousuarios" method="get" class="p-5 m-3">

    <span class="fuente-botones-index">Listado de compras</span>
    <div class="table-responsive">
        <table class="table table-dark table-hover">
            <thead>
              <tr>
                <th scope="col">ID compra</th>
                <th scope="col">Fecha</th>
                <th scope="col">Monto</th>
              </tr>
            </thead>
            <tbody class="table-group-divider">
                <c:forEach items="${listadoComprasTotal}" var="listado" >
                <tr>
                    <td>${listado.id_compra} </td>
                    <td>${listado.fecha}</td>
                    <td>$ ${listado.monto}</td>
                </tr>
                </c:forEach>

            </tbody> 
            </table>
        </form>
    </div>

  <c:import url="/footer.jsp"/>
</body>
</html>