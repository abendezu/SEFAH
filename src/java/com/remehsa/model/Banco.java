/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.model;

import static java.lang.Integer.parseInt;

/**
 *
 * @author abendezu
 */
public class Banco {
    
    private int codigoBanco;
    private String nombreBanco;
    private int codigoPais;
    private String estado;
    private String acronimoPais;

    public Banco(int codigoBanco, String nombreBanco, int codigoPais, String estado) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
        this.codigoPais = codigoPais;
        this.estado = estado;
    }        
    
    public Banco(int codigoBanco, String nombreBanco, String acronimoPais, String estado) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
        this.acronimoPais = acronimoPais;
        this.estado = estado;
    }        

    public String getacronimoPais() {
        return acronimoPais;
    }

    public void setacronimoPais(String acronimoPais) {
        this.acronimoPais = acronimoPais;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais =  codigoPais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }            
}
