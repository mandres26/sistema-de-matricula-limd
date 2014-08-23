/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dto;

import java.util.Date;

/**
 *
 * @author PEDRO
 */
public class ProgCurricularDTO {
    
     private int idProgCurricular;
     private Date fecRegistro;
     private String detalle; 

    public ProgCurricularDTO(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

     
     
    public int getIdProgCurricular() {
        return idProgCurricular;
    }

    public void setIdProgCurricular(int idProgCurricular) {
        this.idProgCurricular = idProgCurricular;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
     
     
     
}
