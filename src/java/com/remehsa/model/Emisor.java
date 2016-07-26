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
public class Emisor {
    
    private int codigoEmisor;
    private String nombreEmisor;
    private String estado;

    public Emisor(int codigoEmisor, String nombreEmisor, String estado) {
        this.codigoEmisor = codigoEmisor;
        this.nombreEmisor = nombreEmisor;
        this.estado = estado;
    }   
    
    public int getCodigoEmisor() {
        return codigoEmisor;
    }

    public void setCodigoEmisor(int codigoEmisor) {
        this.codigoEmisor = codigoEmisor;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
