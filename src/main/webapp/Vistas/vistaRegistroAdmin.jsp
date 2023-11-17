<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  
  <form action="${pageContext.request.contextPath}/catalogo" method="post" class="p-5 m-3">

    <p class="fuente-botones-index">Productos vendidos                      
    
    <div class="table-responsive">
        <table class="table table-dark table-hover">
            <thead>
              <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Marca</th>
                <th scope="col">Descripción</th>
                <th scope="col">Precio</th>
                <th scope="col">Usuario Comprador</th>
              </tr>
            </thead>
        
            <tbody class="table-group-divider">
                <c:forEach items="${productos}" var="producto">
                    <tr>
                        <th scope="row">${producto.nombre}</th>
                        <td>${producto.marca}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.precio}</td>
                        <td>${usuario.nombre}</td> 
                      </tr>
                </c:forEach>
            </tbody> 
        </table>
        </form>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>