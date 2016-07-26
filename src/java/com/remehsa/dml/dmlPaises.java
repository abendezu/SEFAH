/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.dml;

import com.remehsa.db.dbConn;
import com.remehsa.model.Banco;
import com.remehsa.model.Pais;
import com.remehsa.queries.sqlBancos;
import com.remehsa.queries.sqlPaises;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author USER
 */
public class dmlPaises {
    
    public void newPais(Pais p){
        PreparedStatement ps;
        sqlPaises sqlpaises = new sqlPaises();
            
        try (Connection con = dbConn.getConnected()){

            ps = con.prepareStatement(sqlpaises.insertintoPaises());
            ps.setString(1, p.getNombrePais() );
            ps.setString(2, p.getAcronimoPais());
            ps.setString(3, p.getEstado());
            ps.executeUpdate();    

            ps.close();
            con.close();            

        } catch (Exception ex){
            Logger.getLogger(dmlBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Pais> getallPaises(){
        
        List<Pais> lp = new LinkedList<>();
        
        try {
            PreparedStatement ps;
            sqlPaises sqlpaises = new sqlPaises();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlpaises.getallPaises());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pais p = new Pais(parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4));
                lp.add(p);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(dmlPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return lp;
    }

    public static List<Pais> getfilteredPaises(String nombrePais, String acronimoPais){
        
        List<Pais> lp = new LinkedList<>();
        PreparedStatement ps;
        sqlPaises sqlpaises = new sqlPaises();
        
        try (Connection con = dbConn.getConnected()) {
            
            ps = con.prepareStatement(sqlpaises.getallPaises());
            ps.setString(1, nombrePais);
            ps.setString(2, acronimoPais);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Pais p = new Pais(parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4));
                lp.add(p);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(dmlPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return lp;
    }
    
}
