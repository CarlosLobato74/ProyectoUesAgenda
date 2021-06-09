

<div class="modal fade" id="registrarseModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">Registrarse</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=registrarse" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" name="usuario" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="apellido">apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>
                    <div class="form-group">
                        <label for="contrasenia">contrasenia</label>
                        <input type="text" class="form-control" name="contrasenia" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono">telefono</label>
                        <input type="text" class="form-control" name="telefono" required>
                    </div>
                    <div class="form-group">
                        <label for="direccion">direccion</label>
                        <input type="text" class="form-control" name="direccion" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="submit">Registrarse</button>
                </div>
            </form>
               
        </div>  
    </div>
</div>

