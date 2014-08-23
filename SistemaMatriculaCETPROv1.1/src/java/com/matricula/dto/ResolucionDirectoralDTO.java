/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juan Diego
 */
public class ResolucionDirectoralDTO implements Serializable {
    private Integer idRd;
    private Date anioInicio;
    private Date anioTermino;
    private Date fechaRegistro;
    private List<EspecialidadDTO> especialidades;

    public Date getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Date anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Date getAnioTermino() {
        return anioTermino;
    }

    public void setAnioTermino(Date anioTermino) {
        this.anioTermino = anioTermino;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdRd() {
        return idRd;
    }

    public void setIdRd(Integer idRd) {
        this.idRd = idRd;
    }

    public List<EspecialidadDTO> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadDTO> especialidades) {
        this.especialidades = especialidades;
    }
    
    
}
