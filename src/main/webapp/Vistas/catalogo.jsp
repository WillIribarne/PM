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
    
    <td style="text-align: right;">
    <button name="valorButton" value=0 type="submit" class="btn btn-success" href="comprar">Ver el carrito</button>
    </td>                     
   <%--  <c:if test="${true}">--%>
     <!--  <button type="button" class="btn btn-warning fw-bold" href="">Agregar Nuevo Producto</button>-->
   <%--  </c:if>--%>
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
                        <td>
                          <c:choose>
                            <c:when test="${usuario.tipo = 'Admin'}">
                              <button name="valorButton" value=${producto.id_producto} type="submit" class="btn btn-success" href="comprar">Editar producto</button>
                            </c:when>
                            <c:otherwise>
                              <button name="valorButton" value=${producto.id_producto} type="submit" class="btn btn-success" href="comprar">Añadir al carrito</button>
                            </c:otherwise>
                          </c:choose>
                        </td> 
                      </tr>
                </c:forEach>
            </tbody> 
        </table>
        </form>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>