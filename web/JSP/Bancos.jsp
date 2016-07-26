<%-- 
    Document   : Bancos
    Created on : Jul 25, 2016, 8:20:00 PM
    Author     : abendezu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bancos</title>
    </head>
    <body>
        
        <jsp:include page="../HTML/nuevoBanco.html"></jsp:include>

        <div style="width: 1200px; margin-left: auto; margin-right: auto;">
            <table cellpadding="10">
                <tr>
                    <th>Codigo Banco</th>
                    <th>Nombre Banco</th>
                    <th>Codigo Pais</th>
                    <th>Estado</th>
                </tr>
                <c:forEach items="${allBancos}" var="b">
                    <tr>
                        <td>${b.codigoBanco}</td>
                        <td>${b.nombreBanco}</td>
                        <td>${b.codigoPais}</td>
                        <td>${b.estado}</td>
                        <td>
                            <a href="edit?id=${b.codigoBanco}">Edit</a>
                            <a href="delete?id=${b.codigoBanco}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        

    </body>
</html>
