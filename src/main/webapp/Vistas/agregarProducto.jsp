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
                <form action="${pageContext.request.contextPath}/wieeeeee" method="post" class="p-5 m-3">
                <div class="mb-4">
                    <label for="nombreInput" class="form-label badge text-bg-light">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="soi omero chino" required>
                </div>
                <div class="mb-4">
                    <label for="marcaInput" class="form-label badge text-bg-light">Marca:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="soi omero chino" required>
                </div>
                <div class="mb-4">
                    <label for="descripcionInput" class="form-label badge text-bg-light">Descripcion:</label>
                    <textarea id="descripcion" class="form-control" name="descripcion" rows="3" cols="35">soi omero chino</textarea>
                </div>
                <div class="mb-4">
                    <select class="form-select" aria-label="Categoría">
                        <option value="zapatillas">Zapatillas</option>
                        <option value="ojotas">Ojotas</option>
                        <option value="zapatos">Zapatos</option>
                        <option value="pantalones">Pantalones</option>
                        <option value="polleras">Polleras</option>
                        <option value="remeras">Remeras</option>
                        <option value="camperas">Camperas</option>
                        <option value="buzos">Buzos</option>
                        <option value="guantes">Guantes</option>
                        <option value="gorros">Gorros</option>
                    </select>
                </div>
                <div class="mb-4">
                    <label for="precioInput" class="form-label badge text-bg-light">Precio:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="soi omero chino" required>
                </div>
                <div class="mb-4">
                    <label for="stockInput" class="form-label badge text-bg-light">Stock:</label>
                    <input type="number" class="form-control" id="nombre" name="nombre" value="2" required>
                </div>
                </form>
            </div>
            <div class="col-md-6">
                <a class="btn btn-success btn-lg fuente-botones-index m-5" href="" role="button">Agregar Producto</a>
                <a class="btn btn-secondary btn-lg fuente-botones-index m-5" href="" role="button">Volver a Pagina Principal</a>
            </div>
        </div>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>