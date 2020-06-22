/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class Idiomas implements Serializable{
    private int idIdiomas;
    private String nombre;
    private int niveles;
    private int cupos;

    public Idiomas() {
    }

    public int getIdIdiomas() {
        return idIdiomas;
    }

    public void setIdIdiomas(int idIdiomas) {
        this.idIdiomas = idIdiomas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }


    
    
    
}
