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
public class sqlPaises {
    
    public String insertintoPaises () {
        String sql = "insert into paises(nombrePais,acronimoPais,estado) values (?,?,?)";
        return sql;
    }
    
    public String deletefromPaises(){
        String sql = "update paises set estado = 'I' where codigoPais = ? ";
        return sql;
    }
    
    public String updatePaises(){
        String sql = "update paises set nombrePais = ?, acronimoPais = ? where codigoPais = ?";
        return sql;
    }
    
    public String getallPaises(){
        String sql = "select * from paises";
        return sql;
    }

    public String getPaisesbyFilter(){
        String sql = "select * from paises where nombrePais like ? and acronimoPais like ? ";
        return sql;
    }
    
}
