/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dto;

import com.matricula.model.Modulo;

/**
 *
 * @author PEDRO
 */
public class CapacidadDTO {
    
     private int idCodigo;
     private Modulo modulo;
     private String nombreCt;
     private String notaCt;

    public CapacidadDTO(String nombreCt) {
        this.nombreCt = nombreCt;
    }

    public CapacidadDTO(int idCodigo, Modulo modulo, String nombreCt) {
        this.idCodigo = idCodigo;
        this.modulo = modulo;
        this.nombreCt = nombreCt;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public String getNombreCt() {
        return nombreCt;
    }

    public void setNombreCt(String nombreCt) {
        this.nombreCt = nombreCt;
    }

    public String getNotaCt() {
        return notaCt;
    }

    public void setNotaCt(String notaCt) {
        this.notaCt = notaCt;
    }
     
     
}
