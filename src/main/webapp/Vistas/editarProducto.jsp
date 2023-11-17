<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Editar Producto"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
    <div class="container-xl rounded-5 bg-negro p-xl-5 p-2 m-xl-5 mx-0">
        <div class="row align-items-center">
            <div class="col-md-6">
                <p class="fuente-botones-index" style="color: white;">Catálogo:  
                <span class="fuente-botones-index" style="color: white;" >Editar producto </span>
             
                <form action="${pageContext.request.contextPath}/editarProducto" method="post" class="p-5 m-3">
                <div class="mb-4">
                    <label for="nombreInput" class="form-label badge text-bg-light" style="font-size: 18px;">Nombre: ${pedit.nombre} </label>
                </div>
                <div class="mb-4">
                    <label for="marcaInput" class="form-label badge text-bg-light"style="font-size: 18px;" >Marca: ${pedit.marca}</label>
                </div>
                <div class="mb-4">
                    <label for="descripcionInput" class="form-label badge text-bg-light"style="font-size: 18px;" >Descripcion: ${pedit.descripcion}</label>
                </div>
                <div class="mb-4">
                    <label for="precioInput" class="form-label badge text-bg-light"style="font-size: 18px;" >Precio (precio viejo:${pedit.precio}) :</label>
                    <input type="text" class="form-control" id="precio" name="precio" required min="1">
                </div>
                <div class="mb-4">
                    <label for="stockInput" class="form-label badge text-bg-light"style="font-size: 18px;" >Stock (stock viejo:${pedit.stock}):</label>
                    <input type="number" class="form-control" id="stock" name="stock" required min="1>
                </div>
                </form>
            </div>
           <div class="col-md-6">
                <button type="submit" class="btn btn-success btn-lg fuente-botones-index m-5">Guardar cambios</button>
           </div>
        </div>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>