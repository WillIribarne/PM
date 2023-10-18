<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Tu negocio de moda"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp" />
  
 
 
  
    <div class="container bg-negro rounded-5">
        
        <form action="" method="post" class="p-5 m-3">
            <div class="mb-3">
              <label for="exampleInputUser1" class="form-label text-light">Usuario</label>
              <input type="user" class="form-control" id="usuario" name="usuario">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label text-light">Contraseña</label>
              <input type="password" class="form-control" id="clave" name="clave">
            </div>
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label text-light" for="exampleCheck1">Recordarme</label>
            </div>
            
             <!-- notifica que los datos de inicio son incorrectos!-->
            <c:if test="${hayError}">
            <div class="container text-light">
                <h3>${mensajeError}</h3>
            </div>
            </c:if>
        
        <button type="submit" class="btn btn-primary">Iniciar sesión</button>
            
        
          </form>
    </div>
  <c:import url="/footer.jsp" />
</body>
</html>