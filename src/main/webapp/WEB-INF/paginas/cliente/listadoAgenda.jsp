<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="w-100  p-1" >
        <table class="table table-dark ">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">idUser</th>
                     <th scope="col">Descripcion</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="clientes" items="${clientes}">
                <tr> 
                    <th scope="row">${clientes.idAgenda}</th>
                    <td>${clientes.idUser}</td>
                     <td>${clientes.descripcion}</td>
                    <td>${clientes.fecha}</td>
                    <td>${clientes.hora}</td>
                    <td><button type="button" class="btn btn-secondary">Editar</button></td>
                    <td><button type="button" class="btn btn-secondary">Eliminar</button></td>
                </tr>
                  </c:forEach> 
            </tbody>
        </table>
    </div>