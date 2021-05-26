<%-- 
    Document   : index
    Created on : 25 may. 2021, 21:35:44
    Author     : qwerty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="WEB-INF/css/styles.css" rel="stylesheet" type="text/css"/>

        <title>Agenda Iniciar Sesion</title>
    </head>
    <body>
        <div class="contenido">
            <form method="POST" class="form">
                <h1 class="titulo">Iniciar sesion</h1>
                <br>
                <label id="titulo">Usuario</label><br>
                <input type="text" class="userId" id="userId">
                <br><br>
                <label id="titulo">Contrasenia</label><br>
                <input type="password" class="contraseniaId" id="contraseniaId  ">
                <br><br>
                <input type="button" onclick="enviar()" id="enviar" value="enviar">
            </form>
        </div>
        <script src="WEB-INF/javascript/login.js" type="text/javascript"></script>
    </body>
</html>
