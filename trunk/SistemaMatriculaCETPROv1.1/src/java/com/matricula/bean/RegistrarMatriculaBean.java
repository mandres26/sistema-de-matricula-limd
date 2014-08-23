/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;

import com.matricula.dao.GrupoDao;
import com.matricula.dao.impl.GrupoDaoImpl;
import com.matricula.model.Alumno;
import com.matricula.model.Grupo;
import com.matricula.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



/**
 *
 * @author Juan Diego
 */
@ManagedBean(name="registrarMatriculaBean")
@ViewScoped
public class RegistrarMatriculaBean implements Serializable {
    
    private Alumno interesado;
    private String nombre, apellidop, apellidom;
    private int edad, dni;
    private List<Grupo> grupos;
    private List<Grupo> gruposMatricular;
    private Grupo grupoSeleccionado;

    /** Creates a new instance of RegistrarMatriculaBean */
    public RegistrarMatriculaBean() {
        //cargarGrupos();
        interesado=null;
        //Util.setAlumnoSeleccionado(null);
        gruposMatricular = null;
    }
    
    public void update(){
        if(Util.getAlumnoSeleccionado() != null){
            interesado = Util.getAlumnoSeleccionado();
            setNombre(interesado.getNombres());
            setApellidom(interesado.getApeMaterno());
            setApellidop(interesado.getApePaterno());
            setDni(interesado.getDni());
            setEdad(interesado.getEdad());
        }else{
            setNombre("--");
        }
    }

    public Grupo getGrupoSeleccionado() {
        return grupoSeleccionado;
    }

    public void setGrupoSeleccionado(Grupo grupoSeleccionado) {
        this.grupoSeleccionado = grupoSeleccionado;
    }

    public Alumno getInteresado() {
        return interesado;
    }

    public void setInteresado(Alumno interesado) {
        this.interesado = interesado;
    }  
    
    public void cargarGrupos(){
        GrupoDao grupo = new GrupoDaoImpl();
        grupos = grupo.obtenerGrupos();
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){  
        update();
        return nombre;
    }

    public void addGruposMatricular(){
        System.out.println("Grupo seleccionado abc "+grupoSeleccionado.getIdGrupo());
        if(gruposMatricular == null){
            gruposMatricular = new ArrayList<Grupo>();
            gruposMatricular.add(grupoSeleccionado);
        }else{
            if(!gruposMatricular.contains(grupoSeleccionado)){
            gruposMatricular.add(grupoSeleccionado);
            }else{
                Util.mostrarMensajeWARM("Grupo repetido", "Ya está agregado");
            }
        }
        
           /* GrupoDTO group = new GrupoDTO(grupoSeleccionado.getIdGrupo(), 
                grupoSeleccionado.getFecInicio(), grupoSeleccionado.getFecTermino(), 
                grupoSeleccionado.getNumMatriculados(), grupoSeleccionado.getCantMaximaAlumno(),
                grupoSeleccionado.getModulo().getNombreModulo(), 
                grupoSeleccionado.getProfesor().getApePaterno() +" "+grupoSeleccionado.getProfesor().getApeMaterno(),
                grupoSeleccionado.getTurno().getDetalleTurno());
            gruposMatricular.add(group);
        
            System.out.println("---------------------");
        for(GrupoDTO g : gruposMatricular){
            System.out.println("->"+g.getModulo());
        }*/
        
    }
    
    public void registrarMatricula(){
        GrupoDao g = new GrupoDaoImpl();
        for(Grupo grupo : gruposMatricular){
            System.out.println("-->"+interesado.getIdAlumno()+"-"+grupo.getIdGrupo());
            g.crearMatrícula(interesado, grupo);
        }        
        Util.mostrarMensajeINFO("Matrícula Registrada", "Alumno "+interesado.getNombres());
    }
    
    public List<Grupo> getGruposMatricular(){
        return gruposMatricular;
    }
    
    /**
     * @return the grupo
     */
    public List<Grupo> getGrupos() {
        cargarGrupos();
        return grupos;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    /**
     * @return the apellidop
     */
    public String getApellidop() {
        return apellidop;
    }

    /**
     * @param apellidop the apellidop to set
     */
    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    /**
     * @return the apellidom
     */
    public String getApellidom() {
        return apellidom;
    }

    /**
     * @param apellidom the apellidom to set
     */
    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }
}
