


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UesWebProyecto</title>
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <ul>
            <c:forEach var="clientes" items="${clientes}">
                <li>${clientes.idUser} - ${clientes.idAgenda} ${clientes.descripcion} <a>date: </a>${clientes.fecha} <a>time: </a>${clientes.hora}</li>          
            </c:forEach>
           
        </ul>
    </body>
</html>
