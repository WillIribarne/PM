<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  
  <form action="${pageContext.request.contextPath}/catalogo" method="post" class="p-5 m-3">

    <p class="fuente-botones-index">Catálogo 
    <c:choose>
        <c:when test="${false}">
            <span class="fuente-botones-index">- ${categoria}</span>
        </c:when>
        <c:otherwise>
            <span class="fuente-botones-index">- Todos los Productos</span>
        </c:otherwise>
    </c:choose>
    <c:if test="${true}">
      <button type="button" class="btn btn-warning fw-bold" href="">Agregar Nuevo Producto</button>
    </c:if>
    </p>
    
    <div class="table-responsive">
        <table class="table table-dark table-hover">
            <thead>
              <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Marca</th>
                <th scope="col">Descripción</th>
                <th scope="col">Precio</th>
                <th scope="col">Stock</th>
                <th scope="col"> </th>
              </tr>
            </thead>
        
            <tbody class="table-group-divider">
                <c:forEach items="${productos}" var="producto">
                    <tr>
                        <th scope="row">${producto.nombre}</th>
                        <td>${producto.marca}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.stock}</td>
                        
       
                    <%--  <c:choose>--%>
                        <%--    <c:when test="${tipoUser}">   --%>
                        <!--     <td><button type="button" class="btn btn-warning" href="">Editar</button></td>-->
                       <%--    </c:when>  --%>
                          <%--    <c:otherwise>--%>
                                <td><button type="submit" class="btn btn-success" href="">Agregar al carrito</button></td>
                          <%--    </c:otherwise>--%>
                         <%--   <c:otherwise> --%>
                              <!--  <td><button type="button" class="btn btn-danger" href="">No stock</button></td>-->
                        <%--    </c:otherwise> --%>
                    <%--  </c:choose>--%>
                      </tr>
                </c:forEach>
            </tbody> 
        </table>
        </form>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>