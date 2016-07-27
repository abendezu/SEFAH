/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.dml;

import com.remehsa.db.dbConn;
import com.remehsa.model.Banco;
import com.remehsa.queries.sqlBancos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author abendezu
 */
public class dmlBancos {
    
    public void newBanco(Banco b){
        try{
            
            PreparedStatement ps;
            sqlBancos sqlbancos = new sqlBancos();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlbancos.insertintoBancos());
            ps.setString(1, b.getNombreBanco());
            ps.setInt(2, b.getCodigoPais());
            ps.setString(3, b.getEstado());
            ps.executeUpdate();    
            
            ps.close();
            con.close();            
            
        }catch (SQLException | NamingException ex){
            System.out.println("Error "+ ex.getMessage() + ex.toString() );
        }
    }
    
    public static List<Banco> getallBancos(){
        
        List<Banco> lb = new LinkedList<>();
        
        try {
            PreparedStatement ps;
            sqlBancos sqlbancos = new sqlBancos();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlbancos.getallBancos());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Banco b = new Banco(parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4));
                lb.add(b);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(dmlBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return lb;
    }
    
    public static List<Banco> getfilteredBancos(String codigoBanco, String nombreBanco){
        
        List<Banco> lb = new LinkedList<>();
        
        try {
            PreparedStatement ps;
            sqlBancos sqlbancos = new sqlBancos();
            Connection con = dbConn.getConnected();
            
            ps = con.prepareStatement(sqlbancos.getBancosbyFilter());
            ps.setString(1, codigoBanco);
            ps.setString(2, nombreBanco);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Banco b = new Banco(parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4));
                lb.add(b);
            }
            
            rs.close();
            ps.close();
            con.close();
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(dmlBancos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return lb;
    }
    
}
