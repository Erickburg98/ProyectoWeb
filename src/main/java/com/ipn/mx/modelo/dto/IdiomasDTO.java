/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Idiomas;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class IdiomasDTO implements Serializable {

    private Idiomas entidad;

    public IdiomasDTO() {
        entidad = new Idiomas();
    }

    public IdiomasDTO(Idiomas entidad) {
        this.entidad = entidad;
    }

    public Idiomas getEntidad() {
        return entidad;
    }

    public void setEntidad(Idiomas entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idIdiomas").append(getEntidad().getIdIdiomas()).append("\n");
        sb.append("nombre").append(getEntidad().getNombre()).append("\n");
        sb.append("niveles").append(getEntidad().getNiveles()).append("\n");
        sb.append("cupos").append(getEntidad().getCupos()).append("\n");
        
        return sb.toString();
    }

    
}
