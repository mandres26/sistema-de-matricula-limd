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
public class TurnoDTO {
    
     private String detalleTurno;
     private Date horaInicio;
     private Date horaTermino;

    public TurnoDTO(String detalleTurno, Date horaInicio, Date horaTermino) {
        this.detalleTurno = detalleTurno;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }

     
     
    public String getDetalleTurno() {
        return detalleTurno;
    }

    public void setDetalleTurno(String detalleTurno) {
        this.detalleTurno = detalleTurno;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }
     
    
}
