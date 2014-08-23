/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.util;

import com.matricula.dto.ModuloDTO;
import com.matricula.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author Juan Diego
 */
public class Util {
    
    private static Session currentSession;
    private static Alumno alumnoSeleccionado;       

    public static Session getCurrentSession() {
        return currentSession;
    }

    public static void setCurrentSession(Session currentSession) {
        Util.currentSession = currentSession;
    }
        
    public static void mostrarMensajeINFO(String titulo, String texto){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, texto);          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public static void mostrarMensajeWARM(String titulo, String texto){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, texto);          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public static void mostrarMensajeERROR(String titulo, String texto){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, texto);          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    public static List<ModuloDTO> obtenerModulos(){
        List<ModuloDTO> list = new ArrayList<ModuloDTO>();
        list.add(new ModuloDTO(10, "Modulo 1", 10 + (int)(Math.random()*50)));
        list.add(new ModuloDTO(11, "Modulo 2", 10 + (int)(Math.random()*50)));
        list.add(new ModuloDTO(12, "Modulo 3", 10 + (int)(Math.random()*50)));        
        return list;
    }

    public static Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public static void setAlumnoSeleccionado(Alumno alSeleccionado) {
        alumnoSeleccionado = alSeleccionado;
        System.out.println("guardado...."+alumnoSeleccionado.getNombres());
    }
    
}
