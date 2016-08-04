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
            String accion = request.getParameter("buttonAction");
            
            System.out.println("El valor del boton es " + accion);
            
            if(accion.equalsIgnoreCase("Agregar")) {

                Banco b = new Banco(0,nombreBanco,(java.lang.Integer.parseInt(codigoPais)),"A");
            
                dmlBancos dmlbancos = new dmlBancos();
                dmlbancos.newBanco(b);
            
                response.sendRedirect("/remehsa_we/Bancos");
                
            } else if (accion.equalsIgnoreCase("Buscar")){
                System.out.println("33 "+nombreBanco);
                System.out.println("44 "+codigoPais);
                System.out.println("55 "+accion);
                %>  
                <form  method="post">
                    <input type="hidden" name="codigoPais" value="<%=codigoPais%>" style="width: 200px">
                    <input type="hidden" name="nombreBanco" value="<%=nombreBanco%>" style="width: 200px">
                </form>                               
                <%
                
                RequestDispatcher rd = request.getRequestDispatcher("../Bancos");
                rd.forward(request, response);
                    
                //response.sendRedirect("/remehsa_we/searchBancos");
            }
                
            
        %>

    </body>
</html>
