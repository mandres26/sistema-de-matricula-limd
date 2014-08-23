/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;


import com.matricula.model.ResolucionDirectoral;
import com.matricula.dto.EspecialidadDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juan Diego
 */
public interface ResolucionDirectoralDao {
    
    public boolean existeIDenRD(Integer id);
    public List<ResolucionDirectoral> getRD(Integer id);
    public void insertarRD(Integer idRD, Integer anioInicio, 
            Integer anioTermino, Date fecRegistro, List<EspecialidadDTO> especialidades);    
    public List<ResolucionDirectoral> listarRDs();
    public int ultimaID();
}
