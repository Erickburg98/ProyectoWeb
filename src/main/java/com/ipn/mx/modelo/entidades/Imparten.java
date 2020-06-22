/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author burgos
 */
public class Imparten implements Serializable {

    private int idImparten;
    private int idMaestro;
    private String nombre;
    private String paterno;
    private String nombreIdio;
    private int nivel;

    public Imparten() {
    }

    public int getIdImparten() {
        return idImparten;
    }

    public void setIdImparten(int idImparten) {
        this.idImparten = idImparten;
    }

    public int getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getNombreIdio() {
        return nombreIdio;
    }

    public void setNombreIdio(String nombreIdio) {
        this.nombreIdio = nombreIdio;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

   

}
