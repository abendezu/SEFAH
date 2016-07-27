<%-- 
    Document   : Paises
    Created on : Jul 25, 2016, 8:20:00 PM
    Author     : abendezu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paises</title>
    </head>
    <body>
        
        <jsp:include page="../HTML/formPais.html"></jsp:include>

        <div style="width: 1200px; margin-left: auto; margin-right: auto;">
            <table cellpadding="10">
                <tr>
                    <th>Codigo&nbsp;Pais</th>
                    <th>Pais</th>
                    <th>Acronimo</th>                    
                    <th>Estado</th>
                </tr>
                <c:forEach items="${allPaises}" var="p">
                    <tr>
                        <td>${p.codigoPais}</td>
                        <td>${p.nombrePais}</td>
                        <td>${p.acronimoPais}</td>                        
                        <td>${p.estado}</td>
                        <td>
                            <a href="edit?id=${p.codigoPais}">Edit</a>
                            <a href="delete?id=${p.codigoPais}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        

    </body>
</html>
