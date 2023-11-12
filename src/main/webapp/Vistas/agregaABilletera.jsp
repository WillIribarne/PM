<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Billetera"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
  <form action="${pageContext.request.contextPath}/billetera" method="post" class="p-5 m-3">
   <p class="fs-1 d-flex justify-content-center">Cuanto dinero desea agregar?</p>
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-sm-3 d-flex justify-content-center">
                <td><button name="boton" value="100" type="submit" class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="">$100</button></td>         
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <td><button  name="boton" value="500" type="submit" class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="">$500</button></td>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <td><button  name="boton" value="1000" type="submit" class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="">$1000</button></td>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-sm-3 d-flex justify-content-center">
                <td><button  name="boton" value="5000" type="submit" class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="">$5000</button></td>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <td><button  name="boton" value="10000" type="submit" class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="">$10000</button></td>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
               
            <td><button name="boton" value="20000" type="submit" class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="">A$20000</button></td>
                      
            </div>
        </div>
    </div>
   </form>
  <c:import url="/footer.jsp"/>
</body>
</html>