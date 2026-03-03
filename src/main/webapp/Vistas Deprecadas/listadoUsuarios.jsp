<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Catálogo"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  
  <form action="${pageContext.request.contextPath}/listadousuarios" method="get" class="p-5 m-3">

    <span class="fuente-botones-index">Listado de usuarios</span>
    <div class="table-responsive">
        <table class="table table-dark table-hover">
            <thead>
              <tr>
                <th scope="col">Nombre y apellido</th>
                <th scope="col">Fecha de nacimiento</th>
                <th scope="col">Email</th>
                <th scope="col">Domicilio</th>
                <th scope="col">Telefono</th>
              </tr>
            </thead>
            <tbody class="table-group-divider">
                <c:forEach items="${listadoPerfil}" var="perfil" >
                <tr>
                    <td>${perfil.nombre} ${perfil.apellido}</td>
                    <td>${perfil.fechaNac}</td>
                    <td>${perfil.email}</td>
                    <td>${perfil.domicilio}</td>
                    <td>${perfil.telefono}</td>
                </tr>
                </c:forEach>

            </tbody> 
            </table>
        </form>
    </div>

  <c:import url="/footer.jsp"/>
</body>
</html>