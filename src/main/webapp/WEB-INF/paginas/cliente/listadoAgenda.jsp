<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<section id="eventos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4 class="text-center">Bitacora de Eventos Agendados</h4>

                    </div>
                    <table class="table table-dark ">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Hora</th>
                                <th scope="col">Editar</th>
                                <th scope="col">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                           
                            <c:forEach var="clientes" items="${clientes}" varStatus="status">
                                
                                <tr> 
                                    <th scope="row">${status.count}</th>
                                    <td>${clientes.descripcion}</td>
                                    <td>${clientes.fecha}</td>
                                    <td>${clientes.hora}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarAgenda&idAgenda=${clientes.idAgenda}" 
                                           class="btn btn-secondary">Editar *.*
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarAgenda&idAgenda=${clientes.idAgenda}" 
                                           class="btn btn-secondary">Eliminar :x
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach> 
                                
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-light text-white mb-3">
                    <div class="card-body">

                        <img class="mb4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/NASA_logo.svg/1200px-NASA_logo.svg.png" alt="" width="175" height="150">
                        <c:forEach var="logins" items="${logins}">


                            <ul class="list-group list-group-flush">
                                <li class="list-group-item bg-dark text-white">Usuario Informacion</li>
                                <li class="list-group-item">Usuario: ${logins.user}</li>
                                <li class="list-group-item">Contrasenia:<br>${logins.password}</li>
                                <li class="list-group-item">Nombre: ${logins.firstN}</li>
                                <li class="list-group-item">Apellido: ${logins.lastN}</li>
                                <li class="list-group-item">Telefono: <br>${logins.phone}</li>
                                <li class="list-group-item">Direccion:<br>${logins.address}</li>

                            </ul><br>
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletControlador?accion=editarUsuario&userId=${logins.userId}">Editar Usuario</a><br><br>
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarUsuario&userId=${logins.userId}">Eliminar Usuario</a>
                        </c:forEach>


                    </div>
                </div> 

            </div>
        </div>

    </div>
</section>
