/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.queries;

/**
 *
 * @author USER
 */
public class sqlEmisores {

    public String insertintoEmisores () {
        String sql = "insert into emisores(nombreEmisor,estado) values (?,?)";
        return sql;
    }
    
    public String deletefromEmisores(){
        String sql = "update emisores set estado = 'I' where codigoEmisor = ? ";
        return sql;
    }
    
    public String updateEmisores(){
        String sql = "update emisores set nombreEmisor = ? where codigoEmisor = ?";
        return sql;
    }
    
    public String getallEmisores(){
        String sql = "select * from emisores";
        return sql;
    }
    
    public String getEmisoresbyFilter(){
        String sql = "select * from emisores where nombreEmisor like ?";
        return sql;
    }        
}
