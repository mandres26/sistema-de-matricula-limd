/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.dto.TurnoDTO;
import com.matricula.model.Turno;

/**
 *
 * @author PEDRO
 */
public interface TurnoDao {
    
    public void insertarTurno(Integer idgru,TurnoDTO turno);
    public Turno getTurno(int idt);
     public int ultimaTurno();
}
