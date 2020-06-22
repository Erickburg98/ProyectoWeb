package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Alumno;
import java.io.Serializable;

public class AlumnoDTO implements Serializable {

    private Alumno entidad;

    public AlumnoDTO() {
        this.entidad = new Alumno();
    }

    public AlumnoDTO(Alumno entidad) {
        this.entidad = entidad;
    }

    public Alumno getEntidad() {
        return entidad;
    }

    public void setEntidad(Alumno entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idAlumnos").append(getEntidad().getIdAlumnos()).append("\n");
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
