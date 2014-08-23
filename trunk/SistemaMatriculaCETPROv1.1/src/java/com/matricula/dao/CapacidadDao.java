/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.dto.CapacidadDTO;
import com.matricula.model.Modulo;

/**
 *
 * @author PEDRO
 */
public interface CapacidadDao {
    
    public void insertarCapacidad( int codCapacidad,CapacidadDTO cap, Modulo mod);
    public int ultimaId();
}
