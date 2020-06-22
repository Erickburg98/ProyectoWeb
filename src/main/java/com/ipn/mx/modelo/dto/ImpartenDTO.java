/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Imparten;
import java.io.Serializable;

/**
 *
 * @author burgos
 */
public class ImpartenDTO implements Serializable {

    private Imparten entidad;

    public ImpartenDTO() {
        this.entidad = new Imparten();
    }

    public ImpartenDTO(Imparten entidad) {
        this.entidad = entidad;
    }

    public Imparten getEntidad() {
        return entidad;
    }

    public void setEntidad(Imparten entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idImparten").append(getEntidad().getIdImparten()).append("\n");
        sb.append("idMaestros").append(getEntidad().getIdMaestro()).append("\n");
        sb.append("nombre").append(getEntidad().getNombre()).append("\n");
        sb.append("paterno").append(getEntidad().getPaterno()).append("\n");
        sb.append("nombreIdio").append(getEntidad().getNombreIdio()).append("\n");
        sb.append("nivel").append(getEntidad().getNivel()).append("\n");
        return sb.toString();
    }

}
