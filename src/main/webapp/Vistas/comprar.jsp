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
                
       <p class="fuente-botones-index">Carrito</p>   
       <c:forEach items="${carrito}" var="producto">     
            <p class="text-light"><span class="fw-bolder">Nombre </span>${producto.nombre}</p>
            <p class="text-light"><span class="fw-bolder">Marca: </span>${producto.marca}</p>
            <p class="text-light"><span class="fw-bolder">Descripcion: </span>${producto.descripcion}</p>
            <p class="text-light"><span class="fw-bolder">Precio: </span>${producto.precio}</p>
            <p class="fuente-botones-index"> </p>
       </c:forEach>

                
            </div>
            <div class="col-sm-6">
                <h2>
                <p class="text-light"> <span class="fw-bolder">Saldo actual:</span> <span class="text-success">${perfilLogueado.billetera}</span></p>
                </h2>
                
       
        </div>
        <div class="row">
            <div class="col-sm-6 d-flex justify-content-center">
                
            </div>
            <div class="col-sm-6 d-flex justify-content-center">

        <c:choose>
            <c:when test="${mensajeError != null && mensajeError == 'No hay ningun producto en el carrito'}">
                <h3>${mensajeError}</h3>
                <a href="catalogo" class="btn btn-lg btn-warning me-lg-5 me-2">Seguir viendo el catálogo</a>
            </c:when>
             <c:otherwise>
                <button type="button" class="btn btn-lg btn-success me-lg-5 me-2" href="">Comprar</button>
                <a href="catalogo" class="btn btn-lg btn-warning me-lg-5 me-2">Seguir viendo el catálogo</a>
                <button type="button" class="btn btn-lg btn-danger me-lg-5 me-2" href="comprar">Vaciar carrito</button>
            </c:otherwise>  
        </c:choose>
            </div>
        </div>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>

