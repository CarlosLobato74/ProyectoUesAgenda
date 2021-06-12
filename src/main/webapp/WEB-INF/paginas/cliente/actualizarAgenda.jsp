
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UesWebProyecto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarEvento&idAgenda=${cliente.idAgenda}"
              method="POST" class="was-validated">
            
            <!--Botones de edicion-->
             <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>
             
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Evento</h4>
                                </div>
                                <div class="card-body">

                                    <div class="mb-3" >
                                        <label class="form-label"  for="descripcion">Descripcion:</label>
                                        <input type="text" class="form-control" name="descripcion" required value="${cliente.descripcion}">

                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="fecha">Fecha:</label>
                                        <input type="date" class="form-control" name="fecha" required value="${cliente.fecha}">

                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label" for="hora">Hora:</label>
                                        <input type="time" class="form-control" name="hora" required value="${cliente.hora}">
                                        
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
            </section>
        </form>
       
        <!--PiedePagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piedepagina.jsp"/>


        <!-- Separate Popper and Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>


    </body>
</html>
