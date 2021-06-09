
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <body class="text-center"> 
        <!--Contenedor del formulario-->
        <div class="w-25 container p-1 position-absolute top-50 start-50 translate-middle">
           
            </br>
            <img class="mb4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/NASA_logo.svg/1200px-NASA_logo.svg.png" alt="" width="175" height="150">
            <!--Formulario-->
            <form name="form"  class="was-validated" action="/UesWebProyecto/ServletControlador" method="POST">
                

                <h2 class="fw-bold text-center">Iniciar Sesión</h2>

                <div class="form-floating">
                    
                    <input type="text" class="form-control" id="userId" placeholder="Usuario" name="userId" required>
               <label for="userId" class="form-label">Usuario:</label>
                </div></br></br>
                <div class="form-floating ">
                   
                    <input type="password" class="form-control" id="password" placeholder="Contrasenia"  name="password" required>
                 <label for="password" class="form-label">Contrasenia:</label>
                </div>
                </br></br>
                <input class="w-100 btn btn-lg btn-primary" type="submit" value='Ingresar' name="accion"></br></br>
                <input  class="w-100 btn btn-lg btn-primary" type="reset" value='Registrarse'>
            </form>

        </div>


        <script src="WEB-INF/javascript/login.js" type="text/javascript"></script>    
        <!-- Separate Popper and Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>

    </body>
</html>
