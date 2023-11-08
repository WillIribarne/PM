<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="es">
  <c:import url="/header.jsp">
    <c:param name="tituloPagina" value="PM - Billetera"/>
  </c:import>
<body>
  <c:import url="/navbar.jsp"/>
   <p class="fs-1 d-flex justify-content-center">Cuanto dinero desea agregar?</p>
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-sm-3 d-flex justify-content-center">
                <a class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="" role="button">$100</a>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <a class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="" role="button">$500</a>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <a class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="" role="button">$1000</a>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-sm-3 d-flex justify-content-center">
                <a class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="" role="button">$5000</a>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <a class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="" role="button">$10000</a>
            </div>
            <div class="col-sm-3 d-flex justify-content-center">
                <a class="btn btn-success btn-lg fuente-botones-index m-xl-5 p-xl-4 my-3" href="" role="button">$20000</a>
            </div>
        </div>
    </div>
  <c:import url="/footer.jsp"/>
</body>
</html>