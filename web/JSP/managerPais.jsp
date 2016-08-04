<%-- 
    Document   : manageNewPais
    Created on : Jul 26, 2016, 10:15:34 PM
    Author     : abendezu
--%>

<%@page import="com.remehsa.dml.dmlPaises"%>
<%@page import="com.remehsa.model.Pais"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String nombrePais = request.getParameter("nombrePais");
            String acronimoPais = request.getParameter("acronimoPais");
            
            Pais p = new Pais(0,nombrePais,acronimoPais,"A");
            
            dmlPaises dmlpaises = new dmlPaises();
            dmlpaises.newPais(p);
            
            response.sendRedirect("/remehsa_we/Paises");
        %>

    </body>
</html>
