<%--
  Created by IntelliJ IDEA.
  User: Luciano
  Date: 21/10/2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
    <title>Tienda Harnina</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1, user-scalable=no">
    <link type="text/css" rel="stylesheet" href="../css/catalogoEstilo.css">
    <link type="text/css" rel="stylesheet" href="../css/miscontenedores.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
  </head>
  <body>
  <header class="cabecera"><a class="subtitulo" href="catalogo.html">DAM: ACCESO A DATOS</a>
    <h5 class="titulo">Tienda Harnina</h5>
  </header>
  <div class="contenido01">
    <div class="medio dadoCatalogo">
      <div class="dado d1 informatica"></div>
    </div>
    <div class="medio dadoCatalogo">
      <div class="dado d3 harnina"></div>
    </div>
  </div>

  <c:if test="${not empty mensaje}">
    <div class="etiqueta s8">
        ${mensaje}
    </div>
  </c:if>

  <div class="contenedor01">

    <div class="contenido01">
      <div><a href="cliente/clientInsert.jsp">Añadir Cliente</a></div>
      <div><a href="cliente/clientSesion.jsp?operacion=New">Iniciar Sesión</a></div>
    </div>

  </div>

  </body>
</html>

<script src="../js/jscss/dado.js"></script>
<script src="../js/jsStore/store.js"></script>
