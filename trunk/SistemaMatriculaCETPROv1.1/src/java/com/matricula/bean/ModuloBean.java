/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;

import com.matricula.dao.ModuloDao;
import com.matricula.dao.impl.ModuloDaoImpl;
import com.matricula.model.Modulo;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author James
 */
@ManagedBean(name="moduloBean")
@SessionScoped
public class ModuloBean {
     public List<Modulo> modulos; 
     public Modulo modulo;
     public Modulo moduloSeleccionado;
     public List<Modulo> modulosFiltrados;
     
     public void cargarModulos(){
        ModuloDao md=new ModuloDaoImpl();
        modulos=md.listarModulos();    
         for(Modulo o: modulos){
             System.out.println("---------------------------------------------------------------++++++++++++++++++++++............................");
            System.out.println(o.getNombreModulo());
         }
     }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Modulo getModuloSeleccionado() {
        return moduloSeleccionado;
    }

    public void setModuloSeleccionado(Modulo moduloSeleccionado) {
        this.moduloSeleccionado = moduloSeleccionado;
    }



    public ModuloBean() {
    }

    public List<Modulo> getModulosFiltrados() {
        return modulosFiltrados;
    }

    public void setModulosFiltrados(List<Modulo> modulosFiltrados) {
        this.modulosFiltrados = modulosFiltrados;
    }

    public ModuloBean(List<Modulo> modulos, Modulo modulo, Modulo moduloSeleccionado, List<Modulo> modulosFiltrados) {
        this.modulos = modulos;
        this.modulo = modulo;
        this.moduloSeleccionado = moduloSeleccionado;
        this.modulosFiltrados = modulosFiltrados;
    }


    
}
