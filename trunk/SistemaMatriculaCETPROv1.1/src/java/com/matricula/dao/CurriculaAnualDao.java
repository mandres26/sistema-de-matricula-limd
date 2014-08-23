/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.model.CurriculaAnual;
import com.matricula.model.Especialidad;
import com.matricula.model.ProgCurricular;

/**
 *
 * @author PEDRO
 */
public interface CurriculaAnualDao {
    public CurriculaAnual getCurriculaAnual(String idca);
    public String ultimaCanual();
    public void insertarCurriculaAnual(String idca, ProgCurricular pro, Especialidad esp);
}
