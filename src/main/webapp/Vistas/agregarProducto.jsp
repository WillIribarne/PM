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
            
            <div class="col-md-16">
                <p class="fuente-botones-index" style="color: white;">Catálogo:  
                <span class="fuente-botones-index" style="color: white;" >Agregar productos</span>
              </p>
                <form action="${pageContext.request.contextPath}/producto" method="post" class="p-5 m-3">
                <div class="mb-4">
                    <label for="nombreInput" class="form-label badge text-bg-light">Nombre:</label>
                    <input type="nombre" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="mb-4">
                    <label for="marcaInput" class="form-label badge text-bg-light">Marca:</label>
                    <input  type="marca" class="form-control" id="marca" name="marca" required>
                </div>
                <div class="mb-4">
                    <label for="descripcionInput" class="form-label badge text-bg-light">Descripcion:</label>
                    
                    <textarea id="descripcion" class="form-control" name="descripcion" rows="3" cols="35"></textarea>
                </div>
                <div class="mb-4">
                    <select class="form-select" name="categoria">
                        <option value="Zapatillas">Zapatillas</option>
                        <option value="Ojotas">Ojotas</option>
                        <option value="Zapatos">Zapatos</option>
                        <option value="Pantalon">Pantalones</option>
                        <option value="Pollera">Polleras</option>
                        <option value="Remera">Remeras</option>
                        <option value="Campera">Camperas</option>
                        <option value="Buzo">Buzos</option>
                        <option value="Guantes">Guantes</option>
                        <option value="Gorro">Gorros</option>
                    </select>
                </div>
                <div class="mb-4">
                    <label for="precioInput" class="form-label badge text-bg-light">Precio:</label>
                    <input type="number" class="form-control" id="precio" name="precio" required min="1">
                </div>
                
               <div class="mb-4">
                <label for="stockInput" class="form-label badge text-bg-light">Stock:</label>
                <input type="number" class="form-control" id="stock" name="stock"required min="1" >
                 </div>
                
                <div class="col-md-6">
                <button type="submit" class="btn btn-success btn-lg fuente-botones-index m-5">Agregar Producto</button>
                </div>
                </div>
                
                </form>
            
            
        </div>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>