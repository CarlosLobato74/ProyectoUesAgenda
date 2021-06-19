<section id="actions" class=" py-4 mb-4 bg-light aling-items-center">
    <div class="container">
        <div class="row ">
            <div class="col-md-3 p-1">
                <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#agregareventoModal">
                    Agregar nuevo evento</a>
            </div>
             <div class="col-md-3 p-1">
                <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#registroslogModal">
                    Ver logs del Usuario</a>
            </div>
            
            <div class="col-md-3 p-1">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=cerrarSesion" 
                   class="btn btn-secondary btn-block">Cerrar Sesion
                </a>
            </div>


        </div>
    </div>
</section>