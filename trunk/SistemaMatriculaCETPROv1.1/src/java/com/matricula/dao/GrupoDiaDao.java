/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.model.Dia;
import com.matricula.model.Grupo;
import com.matricula.model.GrupoDiaId;

/**
 *
 * @author PEDRO
 */
public interface GrupoDiaDao {
   // public void insertarGrupoDiaId(Integer idDia,Integer idGrupo);
    public void insertarGrupoDia(GrupoDiaId gdid,Grupo gru,Dia dia, String desc);
    public GrupoDiaId getGrupodiaId(int idgrupo);
}
