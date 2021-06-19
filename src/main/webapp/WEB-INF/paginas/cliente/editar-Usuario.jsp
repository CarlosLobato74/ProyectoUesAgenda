
<div class="modal fade"  id="registrarseModal">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-danger bg-gradient text-white">
                <h5 class="modal-title">Actualizar Usuario</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=editarUsuario" method="POST">

                <div class="modal-body text-start">
                    <div class="mb-3" >
                        <label class="form-label"  for="usuario">Usuario:</label>
                        <input type="text" class="form-control" name="usuario" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="apellido">Apellido:</label>
                        <input type="text" class="form-control" name="apellido" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="contrasenia">Contrasenia:</label>
                        <input type="text" class="form-control" name="contrasenia" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="telefono">Telefono:</label>
                        <input type="number" min="10000000" max="99999999" class="form-control" name="telefono" required>

                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="direccion">Direccion:</label>
                        <input type="text" class="form-control" name="direccion" required>

                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-secondary" type="submit">Registrar</button>
                </div>
            </form>

        </div>  
    </div>
</div>