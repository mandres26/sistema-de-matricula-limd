/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;

import com.matricula.model.Profesor;
import java.io.Serializable;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import com.matricula.dao.DocenteDao;
import com.matricula.dao.impl.DocenteDaoImpl;
import com.matricula.model.Alumno;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author Rosy
 */
@ManagedBean(name="docenteBean")
@SessionScoped
public class DocenteBean implements Serializable{
    private int dia, mes, año;
    private int dias[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,20,21,22,23,24,25,26,27,28,29,30};
    private int meses[] = {1,2,3,4,5,6,7,8,9,10,11,12};
    private int años[] = {1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979};
  
    private int codigo =123446;
    private Profesor profesor;
    private List<Profesor> profesores;    
    private List<Profesor>  profesoresFiltrados;
    private Profesor profesorSeleccionado;
    
    public DocenteBean(){
    
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int[] getDias() {
        return dias;
    }

    public void setDias(int[] dias) {
        this.dias = dias;
    }

    public int[] getMeses() {
        return meses;
    }

    public void setMeses(int[] meses) {
        this.meses = meses;
    }

    public int[] getAños() {
        return años;
    }

    public void setAños(int[] años) {
        this.años = años;
    }

    public int getCodigo() {
        DocenteDao docenteDao = new DocenteDaoImpl();
        codigo = Integer.parseInt(docenteDao.calcularMax().toString())+1;
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Profesor getProfesor() {
        if (profesor==null) {
            profesor=new Profesor();}
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Profesor> getProfesoresFiltrados() {
        return profesoresFiltrados;
    }

    public void setProfesoresFiltrados(List<Profesor> profesoresFiltrados) {
        this.profesoresFiltrados = profesoresFiltrados;
    }

    public Profesor getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(Profesor profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }
    
     public void añadirProfesor(ActionEvent actionEvent){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean registrado = false;
        
        DocenteDao docenteDao = new DocenteDaoImpl();
        Date fecha = Date.valueOf(año+"-"+mes+"-"+dia);
        profesor.setIdProfesor(getCodigo());
        profesor.setFecNacimiento(fecha);
        Calendar cal=Calendar.getInstance(); 
        int fa = Integer.valueOf(cal.get(cal.YEAR));
        profesor.setEdad(fa-año);
        System.out.println("FECHA: "+año+"-"+mes+"-"+dia+"      ->"+profesor.getEdad()+"   :"+profesor.getIdProfesor());
        try {
            docenteDao.añadirProfesor(profesor); 
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado: ", profesor.getNombres());  
            registrado = true;
        } catch (Exception e) {
            System.out.println("Error al añadir Docente, en DocenteBean: "+e);
        }  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("regAlu", registrado);  
        profesor=new Profesor();
    }
     
        public void updateDocente(ActionEvent actionEvent){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean modificado = false;
        DocenteDao docenteDao = new DocenteDaoImpl();
        try {
            docenteDao.updateProfesor(profesor);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado: ", profesor.getNombres());  
            modificado = true;
        } catch (Exception e) {
            System.out.println("Error al modificar un docente, en DocenteBean: "+e);
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("regAlu", modificado);  
    }
     
     public void deleteDocente(ActionEvent actionEvent){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean eliminado = false;
        DocenteDao docenteDao = new DocenteDaoImpl();
        try {
            docenteDao.deleteProfesor(profesor);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado: ", profesor.getNombres());  
            eliminado = true;
        } catch (Exception e) {
            System.out.println("Error al eleminar un docente, en docenteBean: "+e);
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("regAlu", eliminado);  
    }
        
 
     
       public void cargarProfesores(){
       DocenteDao pro=new DocenteDaoImpl();
       profesores= pro.getAll();    
    }
     }

    
    
