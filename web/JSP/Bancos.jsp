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
        

        <h1>Bancos</h1>
        <div style="width: 900px; margin-left: auto; margin-right: auto">
            <form action="JSP/managerNewBanco.jsp" method="post">
                Nombre de Banco:<br>
                <input type="text" name="nombreBanco" style="width: 200px">
                País: 

                <select name="codigoPais">
                        <option value="0"><-Seleccione-></option>                
                        <c:forEach items="${allPaises}" var="p">
                        <option value="${p.codigoPais}">${p.nombrePais}</option>
                        </c:forEach>
                </select><br>
                
                
                <input type="submit" value="Submit">
            </form>           
        </div>
        
        
        <div style="width: 1200px; margin-left: auto; margin-right: auto;">
            <table cellpadding="10">
                <tr>
                    <th>Codigo Banco</th>
                    <th>Nombre Banco</th>
                    <th>Pais</th>
                    <th>Estado</th>
                </tr>
                <c:forEach items="${allBancos}" var="b">
                    <tr>
                        <td>${b.codigoBanco}</td>
                        <td>${b.nombreBanco}</td>
                        <td>${b.acronimoPais}</td>
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
