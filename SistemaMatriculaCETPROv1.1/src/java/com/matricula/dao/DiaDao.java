/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.model.Dia;

/**
 *
 * @author PEDRO
 */
public interface DiaDao {
    public Dia getDia(int idt);
    public void insertarDia(Integer iddia,String nombred);
}
