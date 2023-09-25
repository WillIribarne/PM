<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 25/9/2023
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PM - Tu negocio de moda</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar navbar-dark navbar-expand-lg bg-negro">
  <div class="container-fluid">
    <a class="navbar-brand fuente-navbar-brand" href="#">PM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link fuente-navbar-estandar mx-2" href="#">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link fuente-navbar-estandar mx-2" href="#">Quienes Somos</a>
        </li>
        <li class="nav-item dropdown mx-2">
          <a class="nav-link dropdown-toggle fuente-navbar-estandar" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Catálogo
          </a>
          <ul class="dropdown-menu bg-dark">
            <li><a class="dropdown-item fuente-navbar-estandar" href="#">Categorías</a></li>
            <li><a class="dropdown-item fuente-navbar-estandar" href="#">Etiquetas</a></li>
          </ul>
        <li class="nav-item">
          <a class="nav-link fuente-navbar-estandar me-5" href="#">Iniciar Sesión</a>
        </li>
        </li>
      </ul>
      <span class="d-flex fuente-navbar-estandar me-2">¿No tienes cuenta?</span>
      <a href="#">Registrate</a>
    </div>
  </div>
</nav>
<div class="container-fluid m-0 p-0 g-0 bg-verde">
  <div class="row align-items-start">
    <div class="col-md-6 p-0">
      <img src="imgs/PM-Index.jpeg" class="img-fluid" alt="">
    </div>
    <div class="col-md-6 p-0 bg-verde">
      <div class="text-center p-0">
        <div class="row">
          <div class="container">
            <button type="button" class="btn btn-secondary btn-lg m-l-5 m-md-4 m-sm-3 m-2 p-xl-5 p-md-4 p-sm-3 p-2 fuente-botones-index">Ver Catálogo</button>
          </div>
          <div class="container">
            <button type="button" class="btn btn-secondary btn-lg m-l-5 m-md-4 m-sm-3 m-2 p-xl-5 p-md-4 p-sm-3 p-2 fuente-botones-index">Sobre nosotros</button>
          </div>
          <div class="container">
            <button type="button" class="btn btn-secondary btn-lg m-l-5 m-md-4 m-sm-3 m-2 p-xl-5 p-md-4 p-sm-3 p-2 fuente-botones-index">Otro boton falopa</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
