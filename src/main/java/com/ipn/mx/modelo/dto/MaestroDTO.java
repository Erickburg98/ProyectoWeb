
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Maestro;
import java.io.Serializable;

public class MaestroDTO implements Serializable{
    private Maestro entidad;

    public MaestroDTO() {
        this.entidad = new Maestro();
    }

    public MaestroDTO(Maestro entidad) {
        this.entidad = entidad;
    }

    public Maestro getEntidad() {
        return entidad;
    }

    public void setEntidad(Maestro entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idMaestros").append(getEntidad().getIdMaestro()).append("\n");
        sb.append("foto").append(getEntidad().getFoto()).append("\n");  
        sb.append("nombre").append(getEntidad().getNombre()).append("\n");
        sb.append("paterno").append(getEntidad().getPaterno()).append("\n");
        sb.append("materno").append(getEntidad().getMaterno()).append("\n");
        sb.append("email").append(getEntidad().getEmail()).append("\n");
        sb.append("usuario").append(getEntidad().getNombreUsuario()).append("\n");
        sb.append("contrasena").append(getEntidad().getClaveUsuario()).append("\n");
        return sb.toString();
    }
    
     
    
    
    
}















