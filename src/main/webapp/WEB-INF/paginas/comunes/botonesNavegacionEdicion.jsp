<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-2 p-1">
                <a href="clientes.jsp" class="btn btn-dark btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar
                </a>
            </div>
            <div class="col-md-3 p-1">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Cambios
                </button>
            </div>
            <div class="col-md-3 p-1">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarEvento&idAgenda=${cliente.idAgenda}" 
                   class="btn  btn-danger btn-block">
                    <i class="fas fa-trash"></i>Eliminar :x
                </a>    
            </div>
        </div>
    </div>
</section>