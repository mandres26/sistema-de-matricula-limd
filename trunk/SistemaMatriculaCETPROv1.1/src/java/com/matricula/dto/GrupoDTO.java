/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dto;

import java.util.Date;

/**
 *
 * @author PEDRO
 */
public class GrupoDTO {
    
    private int idGrupo;
    private Date fecInicio;
    private Date fecTermino;
    private int numMatriculados;
    private int cantMaximaAlumno;
    private String profesor;
    private String modulo;
    private String turno;

    public GrupoDTO(int idGrupo, Date fecInicio, Date fecTermino, int numMatriculados, int cantMaximaAlumno) {
        this.idGrupo = idGrupo;
        this.fecInicio = fecInicio;
        this.fecTermino = fecTermino;
        this.numMatriculados = numMatriculados;
        this.cantMaximaAlumno = cantMaximaAlumno;
    }

    public GrupoDTO(int idGrupo, Date fecInicio, Date fecTermino, int numMatriculados, int cantMaximaAlumno, String profesor, String modulo, String turno) {
        this.idGrupo = idGrupo;
        this.fecInicio = fecInicio;
        this.fecTermino = fecTermino;
        this.numMatriculados = numMatriculados;
        this.cantMaximaAlumno = cantMaximaAlumno;
        this.profesor = profesor;
        this.modulo = modulo;
        this.turno = turno;
    }

    public GrupoDTO(Date fecInicio, Date fecTermino, int numMatriculados) {
        this.fecInicio = fecInicio;
        this.fecTermino = fecTermino;
        this.numMatriculados = numMatriculados;
        this.cantMaximaAlumno = cantMaximaAlumno;
        this.profesor = profesor;
        this.modulo = modulo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

       
    
    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecTermino() {
        return fecTermino;
    }

    public void setFecTermino(Date fecTermino) {
        this.fecTermino = fecTermino;
    }

    public int getNumMatriculados() {
        return numMatriculados;
    }

    public void setNumMatriculados(int numMatriculados) {
        this.numMatriculados = numMatriculados;
    }

    public Integer getCantMaximaAlumno() {
        return cantMaximaAlumno;
    }

    public void setCantMaximaAlumno(int cantMaximaAlumno) {
        this.cantMaximaAlumno = cantMaximaAlumno;
    }

    /**
     * @return the profesor
     */
    public String getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    
}
