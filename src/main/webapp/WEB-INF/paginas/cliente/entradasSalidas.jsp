<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="modal fade"  id="registroslogModal">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-danger bg-gradient text-white">
                <h5 class="modal-title">Logs de entradas y salidas del usuario</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-body text-start">
                
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Entro</th>
                            <th scope="col">Salio</th>
                            

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="logs" items="${logs}" varStatus="status">    
                            <tr> 
                                <th scope="row">${status.count}</th>
                                <td>${logs.entradas}</td>
                                <td>${logs.salidas}</td>

                            </tr>
                        </c:forEach> 

                    </tbody>
                </table>

            </div> 
            <div class="modal-footer">
                <h4>fin</h4>
            </div>
        </div>
    </div>
</div>