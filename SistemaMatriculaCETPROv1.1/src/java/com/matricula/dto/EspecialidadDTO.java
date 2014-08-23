/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Juan Diego
 */
public class EspecialidadDTO implements Serializable {
    private Integer idEspecialidad;
    private String nombreEspecialidad;
    private String cicloEspecialidad;
    private ResolucionDirectoralDTO resolucionDir;
    private List<ModuloDTO> modulos;

    public EspecialidadDTO(String nombreEspecialidad, String cicloEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.cicloEspecialidad = cicloEspecialidad;
        this.modulos = null;
    }    
    
    public EspecialidadDTO(Integer idEspecialidad, String nombreEspecialidad, String cicloEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
        this.cicloEspecialidad = cicloEspecialidad;
        this.modulos = null;
    }

    public EspecialidadDTO(Integer idEspecialidad, String nombreEspecialidad, String cicloEspecialidad, ResolucionDirectoralDTO resolucionDir) {
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
        this.cicloEspecialidad = cicloEspecialidad;
        this.resolucionDir = resolucionDir;
        this.modulos = null;
    }    
    
    public String getCicloEspecialidad() {
        return cicloEspecialidad;
    }

    public void setCicloEspecialidad(String cicloEspecialidad) {
        this.cicloEspecialidad = cicloEspecialidad;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public ResolucionDirectoralDTO getResolucionDir() {
        return resolucionDir;
    }

    public void setResolucionDir(ResolucionDirectoralDTO resolucionDir) {
        this.resolucionDir = resolucionDir;
    }

    public List<ModuloDTO> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloDTO> modulos) {
        this.modulos = modulos;
    }
    
    public ModuloDTO getModuloPorIndice(int indice){
        return modulos.get(indice);
    }
    
    public void agregarModulo(ModuloDTO modulo){
        this.modulos.add(modulo);
    }
}
