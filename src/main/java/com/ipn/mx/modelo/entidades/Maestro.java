
package com.ipn.mx.modelo.entidades;

import java.io.InputStream;
import java.io.Serializable;

public class Maestro  implements Serializable{
    private int idMaestro;
    private String nombre;
    private String paterno;
    private String materno;
    private String email;
    private InputStream foto;
    private String nombreUsuario;
    private String claveUsuario;

    public Maestro() {
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

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
    
    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    
    
}












