/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.queries;

/**
 *
 * @author abendezu
 */
public class sqlBancos {
    
    public String insertintoBancos () {
        String sql = "insert into bancos(nombreBanco,codigoPais,estado) values (?,?,?)";
        return sql;
    }
    
    public String deletefromBancos(){
        String sql = "update bancos set estado = 'I' where codigoBanco = ? ";
        return sql;
    }
    
    public String updateBancos(){
        String sql = "update bancos set codigoPais = ?, nombreBanco = ? where codigoBanco = ?";
        return sql;
    }
    
    public String getallBancos(){
        String sql = "select codigoBanco,nombreBanco,acronimoPais,bancos.estado from bancos,paises where bancos.codigoPais = paises.codigoPais";
        return sql;
    }
    
    public String getBancosbyFilter(){
        String sql = "select * from bancos where codigoPais = ? and nombreBanco like ?";
        return sql;
    }
    
}
