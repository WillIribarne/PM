<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  
  <form action="${pageContext.request.contextPath}/catalogoAdmin" method="post" class="p-5 m-3">

    <p class="fuente-botones-index">Catálogo:  

    <span class="fuente-botones-index">Editar productos</span>
    
    
   <td style="text-align: right;">
        <a class="btn btn-warning fw-bold" href="producto" role="button">Agregar Nuevo Producto</a>
    </td> 
   </p>
    
    <div class="table-responsive">
        <table class="table table-dark table-hover">
            <thead>
              <tr>
                <th scope="col">ID del producto</th>
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
                        <th scope="row">${producto.id_producto}</th>
                        <td>${producto.nombre}</td>
                        <td>${producto.marca}</td>
                        <td>${producto.descripcion}</td>
                        <td>$ ${producto.precio}</td>
                        <td>${producto.stock}</td>
                        <td>
                       <button name="IDproduct" value=${producto.id_producto} type="submit" class="btn btn-success" href="catalogoAdmin">Editar producto</button>
                       </td>
                    </tr>
                </c:forEach>
            </tbody> 
            
        </table>
        
        <span class="fuente-botones-index">Ingrese el ID del producto que desea editar</span>
        
        </form>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>