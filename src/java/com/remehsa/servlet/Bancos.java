/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.servlet;

import com.remehsa.dml.dmlBancos;
import com.remehsa.dml.dmlPaises;
import com.remehsa.model.Banco;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abendezu
 */
@WebServlet(name = "Bancos", urlPatterns = {"/Bancos"})
public class Bancos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{    
        
            String nombreBanco = request.getParameter("nombreBanco");
            String codigoPais = request.getParameter("codigoPais");
            String accion = request.getParameter("buttonAction");
            if (accion == null) accion = "";
            String rows = request.getParameter("rows");
            if (rows == null) rows = "1";
            String maxrows = request.getParameter("maxrows");
            if (maxrows == null) maxrows = "10";

            System.out.println("Este es el valor que tienen esta variable "+ accion);
        
            if (accion.equalsIgnoreCase("Agregar")){
                                
                Banco b = new Banco(0,nombreBanco,(java.lang.Integer.parseInt(codigoPais)),"A");

                dmlBancos dmlbancos = new dmlBancos();
                dmlbancos.newBanco(b);

                request.setAttribute("allBancos", dmlBancos.getallBancos());
                request.setAttribute("allPaises", dmlPaises.getallPaises());        

                //response.sendRedirect("/remehsa_we/Bancos");

            } else if (accion.equalsIgnoreCase("Buscar")){
                
                System.out.println("Este es el valor de las variables codigoPais:"+codigoPais + " nombreBanco:"+ nombreBanco);
                
                request.setAttribute("allBancos", dmlBancos.getfilteredBancos(codigoPais, nombreBanco));
                request.setAttribute("allPaises", dmlPaises.getallPaises());        
                
            } else {

                request.setAttribute("allBancos", dmlBancos.getallBancos());
                request.setAttribute("allPaises", dmlPaises.getallPaises());        

            }

            request.setAttribute("buttonAntvalue", "visible");
            request.setAttribute("buttonSigvalue", "visible");                
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Bancos.jsp");
            rd.forward(request, response);
        
        
        } catch (Exception ex){
            System.out.println("Entro al error ex = " + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
