<%-- 
    Document   : index
    Created on : 25 may. 2021, 21:35:44
    Author     : qwerty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}/ServletControlador}">
 
<!DOCTYPE html>
<html>
    <head>
        <link href="WEB-INF/css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Agenda Iniciar Sesion</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        
    </head>
    <body>
        
        <div class="breadcrumb p-3 mb-2 position-absolute top-50 start-50 translate-middle border border-3 border-secondary rounded-3">
            <!--<img src="https://eel.ues.edu.sv/img/site/minerva-sf.png" class="img-thumbnail "  alt="UES-LOGO">-->
            </br>
            <!--Formulario-->
            <form>
                <h2 class="fw-bold text-center">Iniciar Sesión</h2>
                <div class="mb-3">
                    <label for="userId" class="form-label">Usuario:</label>
                    <input type="text" class="form-control" id="userId" placeholder="Usuario">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Contrasenia:</label>
                    <input type="password" class="form-control" id="password" placeholder="Contrasenia">
                </div>
                <button type="button" class="btn btn-secondary " type="submit" id="enviar">Iniciar Sesion</button>
                <button type="button" class="btn btn-secondary " id="registrarse">Registrarse</button>
            </form>

        </div>

        
        <script src="WEB-INF/javascript/login.js" type="text/javascript"></script>    
        <!-- Separate Popper and Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

    </body>
</html>
