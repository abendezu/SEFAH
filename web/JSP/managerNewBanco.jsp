<%-- 
    Document   : manageNewBanco
    Created on : Jul 25, 2016, 7:07:30 PM
    Author     : abendezu
--%>

<%@page import="com.remehsa.dml.dmlBancos"%>
<%@page import="com.remehsa.model.Banco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String nombreBanco = request.getParameter("nombreBanco");
            String codigoPais = request.getParameter("codigoPais");
            
            Banco b = new Banco(0,nombreBanco,(java.lang.Integer.parseInt(codigoPais)),"A");
            
            dmlBancos dmlbancos = new dmlBancos();
            dmlbancos.newBanco(b);
            
            response.sendRedirect("/remehsa_we/Bancos");
        %>

    </body>
</html>
