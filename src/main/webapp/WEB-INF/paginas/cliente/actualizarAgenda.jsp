<div class="modal fade"  id="actualizareventoModal">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-danger bg-gradient text-white">
                <h5 class="modal-title">Editar evento</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=agregarEvento" method="POST">

                <div class="modal-body text-start">
                    <div class="mb-3" >
                        <label class="form-label"  for="descripcion">Descripcion:</label>
                        <input type="text" class="form-control" name="descripcion" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="fecha">Fecha:</label>
                        <input type="date" class="form-control" name="fecha" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="hora">Hora:</label>
                        <input type="time" class="form-control" name="hora" required>

                    </div>
                    
                </div>

                <div class="modal-footer">
                    <button class="btn btn-dark" type="submit">Agregar</button>
                </div>
            </form>

        </div>  
    </div>
</div>