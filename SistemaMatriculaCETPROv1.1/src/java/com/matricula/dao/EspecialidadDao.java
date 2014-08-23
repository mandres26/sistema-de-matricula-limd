/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.model.ResolucionDirectoral;
import com.matricula.dto.EspecialidadDTO;
import com.matricula.model.Especialidad;
import java.util.List;

/**
 *
 * @author Juan Diego
 */
public interface EspecialidadDao {
    
    public void insertarEspecialidad(Integer idEspecialidad, 
            EspecialidadDTO esp, ResolucionDirectoral rd);
    public int ultimaId();
    public List<Especialidad> listarEspecialidades(Integer idRD);
}
