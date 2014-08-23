/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.dto.ModuloDTO;
import com.matricula.model.Especialidad;
import com.matricula.model.Modulo;
import java.util.List;

/**
 *
 * @author Juan Diego
 */
public interface ModuloDao {
    
    public void insertarModulo(Integer idMod, ModuloDTO mod, Especialidad esp);
    public int ultimaId();
    public List<Modulo> listarModulos(Integer idEspecialidad);
    public List<Modulo> listarModulos();
    public Modulo getModulo(int idca);
}
