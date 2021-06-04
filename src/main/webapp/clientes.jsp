


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control agenda</title>
    </head>
    <body>
        <h1>AGENDA</h1>
        <ul>
          
            <c:forEach var="cliente" items="${clientes}">
                <li>${cliente.idUser} ${cliente.idAgenda} ${cliente.descripcion} ${cliente.fecha} ${cliente.hora}</li>
                    
            </c:forEach>
           
        </ul>
    </body>
</html>
