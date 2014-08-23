/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dto;

import java.io.Serializable;

/**
 *
 * @author Juan Diego
 */
public class ModuloDTO implements Serializable {
    private int idModulo;
    private String nombreModulo;
    private int horasModulo;
    private EspecialidadDTO especialidad;

    public ModuloDTO(String nombreModulo, int horasModulo) {
        this.nombreModulo = nombreModulo;
        this.horasModulo = horasModulo;
    }
    
    public ModuloDTO(int idModulo, String nombreModulo, int horasModulo) {
        this.idModulo = idModulo;
        this.nombreModulo = nombreModulo;
        this.horasModulo = horasModulo;
    }

    public ModuloDTO(int idModulo, String nombreModulo, int horasModulo, EspecialidadDTO especialidad) {
        this.idModulo = idModulo;
        this.nombreModulo = nombreModulo;
        this.horasModulo = horasModulo;
        this.especialidad = especialidad;
    }

    
    
    public int getIdModulo() {
        return idModulo;
    }

    public void setCodModulo(int codModulo) {
        this.idModulo = codModulo;
    }

    public EspecialidadDTO getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
    }

    public int getHorasModulo() {
        return horasModulo;
    }

    public void setHorasModulo(int horasModulo) {
        this.horasModulo = horasModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }
    
    
}

