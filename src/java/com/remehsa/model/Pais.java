/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remehsa.model;

/**
 *
 * @author USER
 */
public class Pais {
    
    private int codigoPais;
    private String nombrePais;
    private String acronimoPais;
    private String estado;

    public Pais(int codigoPais, String nombrePais, String acronimoPais, String estado) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.acronimoPais = acronimoPais;
        this.estado = estado;
    }    
    
    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getAcronimoPais() {
        return acronimoPais;
    }

    public void setAcronimoPais(String acronimoPais) {
        this.acronimoPais = acronimoPais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
