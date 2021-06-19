<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agenda Iniciar Sesion</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    </head>
    <body class="text-center">        
        <div class="row">
            <div class="col-md-3 mb-3 position-absolute top-50 start-50 translate-middle">
                <div class="card-body">            

                    </br>
                    <img class="mb4 " src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/NASA_logo.svg/1200px-NASA_logo.svg.png" alt="" width="175" height="150">
                    <!--Formulario-->
                    <form name="form"  class="was-validated" action="/UesWebProyecto/ServletControlador" method="POST">

                        <h2 class="fw-bold text-center">Iniciar Sesión</h2>
                          
                        <div class="form-floating">
                            <input type="text" class="form-control" id="userId" placeholder="Usuario" name="userId" required>
                            <label for="userId" class="form-label">Usuario:</label>
                        </div></br>
                        <div class="form-floating ">
                            <input type="password" class="form-control" id="password" placeholder="Contrasenia"  name="password" required>
                            <label for="password" class="form-label">Contrasenia:</label>
                        </div>
                        </br></br>
                        <input class="w-100 btn btn-lg btn-primary" type="submit" value='Ingresar' name="accion"></br></br>

                    </form>
                    <section id="actions" >
                        <button class="btn btn-lg btn-primary w-100" 
                                  data-bs-toggle="modal" data-bs-target="#registrarseModal">
                            <i class="fas fa-plus"></i> Registrarse
                        </button>
                    </section>



                </div>
            </div>
        </div>
         
        <jsp:include page="WEB-INF/paginas/cliente/registrarse.jsp" /> 
        <!-- Separate Popper and Bootstrap JS -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </body>
</html>
