/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.dto.ProgCurricularDTO;
import com.matricula.model.CurriculaAnual;
import com.matricula.model.Especialidad;
import com.matricula.model.ProgCurricular;
import java.util.List;

/**
 *
 * @author PEDRO
 */
public interface ProgramacionCurricularDao {
   
    public List getListaResolucion(int idRe);
    public void Resolucionhiber(int idRe);
    public List getEspecialidades(int Ides);
    public List getModulos(int Idmo);
    public void insertarProgramacionCurricular2(Integer idpc, ProgCurricularDTO pro);
    public int ultimaPcurricular();
    public Especialidad getEspecialidad2(int idRe);
    public ProgCurricular getProgCurricular(int idpc);
      
}
