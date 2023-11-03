<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <c:import url="/header.jsp">
        <c:param name="tituloPagina" value="PM - Tu negocio de moda"/>
    </c:import>
<body>
<c:import url="/navbar.jsp" />
    <div class="container bg-negro">
        <form action="${pageContext.request.contextPath}/registro" method="post" class="p-5 m-3">

            <div class="mb-3">
                <label for="userInput" class="form-label text-light">Usuario *</label>
                <input type="user" class="form-control" id="usuario" name="usuario">
                <div id="userHelp" class="form-text text-light">Esto se usará para el inicio de sesión</div>
            </div>
            <div class="mb-3">
                <label for="claveInput" class="form-label text-light">Contraseña *</label>
                <input type="password" class="form-control" id="clave" name="clave">
            </div>
            <div class="mb-3">
                <label for="dateInput" class="form-label text-light">Fecha de nacimiento *</label>
                <input type="date" class="form-control" id="dateInput" name="date">
            </div>
            <div class="mb-3">
                <label for="emailInput" class="form-label text-light">Direccion de mail *</label>
                <input type="email" class="form-control" id="emailInput" name="email" placeholder="mimail@mail.com">
            </div>
            <div class="mb-3">
                <label for="exampleInputUser1" class="form-label text-light">Domicilio</label>
                <input type="user" class="form-control" id="domicilio" name="domicilio">
            </div>
            <div class="mb-3">
                <label for="telInput" class="form-label text-light">Numero de Teléfono</label>
                <input type="tel" class="form-control" id="telInput" name="telefono" placeholder="123-456-7890">
            </div>
            <div class="mb-3">
                <label for="photoInput" class="form-label text-light">Elige una foto de perfil</label>
                <input type="file" class="form-control" id="photoInput" name="foto">
            </div>
            <div id="userHelp" class="form-text text-light my-2">* Campo obligatorio</div>
            <button type="submit" class="btn btn-primary">Registrarse</button>
        </form>
    </div>
<c:import url="/footer.jsp" />
</body>
</html>
