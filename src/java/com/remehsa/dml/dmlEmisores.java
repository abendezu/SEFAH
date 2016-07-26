/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.dml;

import com.remehsa.db.dbConn;
import com.remehsa.model.Emisor;
import com.remehsa.queries.sqlEmisores;
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
public class dmlEmisores {

    public void newEmisor(Emisor e){
        try{
            
            PreparedStatement ps;
            sqlEmisores sqlemisores = new sqlEmisores();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlemisores.insertintoEmisores());
            ps.setString(1, e.getNombreEmisor());
            ps.setString(2, e.getEstado());
            ps.executeUpdate();    
            
            ps.close();
            con.close();            
            
        }catch (SQLException | NamingException ex){
            Logger.getLogger(dmlBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Emisor> getallEmisores(){
        
        List<Emisor> le = new LinkedList<>();
        
        try {
            PreparedStatement ps;
            sqlEmisores sqlemisores = new sqlEmisores();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlemisores.getallEmisores());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Emisor e = new Emisor(parseInt(rs.getString(1)),rs.getString(2),rs.getString(3));
                le.add(e);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(dmlBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return le;
    }
    
    public static List<Emisor> getfilteredBancos(String nombreEmisor){
        
        List<Emisor> le = new LinkedList<>();
        
        try {
            PreparedStatement ps;
            sqlEmisores sqlemisores = new sqlEmisores();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlemisores.getEmisoresbyFilter());
            ps.setString(1, nombreEmisor);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Emisor e = new Emisor(parseInt(rs.getString(1)),rs.getString(2),rs.getString(3));
                le.add(e);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(dmlBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return le;
    }      
}
