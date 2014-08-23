/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao;

import com.matricula.model.Alumno;
import com.matricula.model.Profesor;
import java.util.List;

/**
 *
 * @author Rosy
 */
public interface DocenteDao {
    public void añadirProfesor(Profesor profesor);
    public void deleteProfesor(Profesor profesor);
    public void updateProfesor(Profesor profesor);
    public Object calcularMax();
    public List<Profesor> getAll();
   
       
}
