/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;

import com.matricula.dao.CapacidadDao;
import com.matricula.dao.CurriculaAnualDao;
import com.matricula.dao.DiaDao;
import com.matricula.dao.DocenteDao;
import com.matricula.dao.GrupoDao;
import com.matricula.dao.GrupoDiaDao;
import com.matricula.dao.ModuloDao;
import com.matricula.dao.ProgramacionCurricularDao;
import com.matricula.dao.TurnoDao;
import com.matricula.dao.impl.CapacidadDaoImpl;
import com.matricula.dao.impl.CurriculaAnualDaoImpl;
import com.matricula.dao.impl.DiaDaoImpl;
import com.matricula.dao.impl.DocenteDaoImpl;
import com.matricula.dao.impl.GrupoDaoImpl;
import com.matricula.dao.impl.GrupoDiaDoaImpl;
import com.matricula.dao.impl.ModuloDaoImpl;
import com.matricula.dao.impl.ProgramacionCurricularDaoImpl;
import com.matricula.dao.impl.TurnoDaoImpl;
import com.matricula.dto.CapacidadDTO;
import com.matricula.dto.GrupoDTO;
import com.matricula.dto.ModuloDTO;
import com.matricula.dto.ProgCurricularDTO;
import com.matricula.dto.TurnoDTO;
import com.matricula.model.CapacidadTerminal;
import com.matricula.model.Especialidad;
import com.matricula.model.GrupoDiaId;
import com.matricula.model.Modulo;
import com.matricula.model.Profesor;
import com.matricula.model.ResolucionDirectoral;
import com.matricula.model.Turno;
import com.matricula.util.Constante;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author PEDRO
 */
@ManagedBean
@SessionScoped
public class RegistrarPCBean implements Serializable {

    private boolean aceptar;
    int startId;
    int endId;
    ProgramacionCurricularDao helper;
    DataModel datamodelcurricular;
    DataModel datamodelespecialidad;
    DataModel datamodelmodulo;
    List<CapacidadDTO> listaCapacidad = new ArrayList();
    Especialidad selectEspecialidad;
    Modulo selectModulo;
    //*********para el turno**********
    //  Turno objturno=new Turno(0,detalleTurno,horai,horaf,null);
    String detalleTurno;//mañana,tarde o noche
    GrupoDTO grupo1;
    //selecciona dias-----------
    private List<String> selectedias;
    TurnoDTO turno1;
    Turno turnoelegido;
    Date fecharegistropc;
    ProgCurricularDTO proc;
    int id_especialidad_seleccionada;
    int id_programacionCurricular;
    String id_curriculaAnual;
    int id_modulo_seleccionado;
    int id_grupo;

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_modulo_seleccionado() {
        return id_modulo_seleccionado;
    }

    public void setId_modulo_seleccionado(int id_modulo_seleccionado) {
        this.id_modulo_seleccionado = id_modulo_seleccionado;
    }

    public String getId_curriculaAnual() {
        return id_curriculaAnual;
    }

    public void setId_curriculaAnual(String id_curriculaAnual) {
        this.id_curriculaAnual = id_curriculaAnual;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public int getId_programacionCurricular() {
        return id_programacionCurricular;
    }

    public void setId_programacionCurricular(int id_programacionCurricular) {
        this.id_programacionCurricular = id_programacionCurricular;
    }

    public int getId_especialidad_seleccionada() {
        return id_especialidad_seleccionada;
    }

    public void setId_especialidad_seleccionada(int id_especialidad_seleccionada) {
        this.id_especialidad_seleccionada = id_especialidad_seleccionada;
    }

    public Date getFecharegistropc() {
        return fecharegistropc;
    }

    public void setFecharegistropc(Date fecharegistropc) {
        this.fecharegistropc = fecharegistropc;
    }

    public Turno getTurnoelegido() {
        return turnoelegido;
    }

    public void setTurnoelegido(Turno turnoelegido) {
        this.turnoelegido = turnoelegido;
    }
    //*******************para buscar profesor*************************
    private List<Profesor> profesores;
    private List<Profesor> filtroprofesores;
    private Profesor docenteseleccionado;

    public Profesor getDocenteseleccionado() {
        return docenteseleccionado;
    }

    public void setDocenteseleccionado(Profesor docenteseleccionado) {
        this.docenteseleccionado = docenteseleccionado;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Profesor> getFiltroprofesores() {
        return filtroprofesores;
    }

    public void setFiltroprofesores(List<Profesor> filtroprofesores) {
        this.filtroprofesores = filtroprofesores;
    }

    public void cargarDocente() {
        DocenteDao al = new DocenteDaoImpl();
    //    profesores = al.cargarProfes;
        profesores = al.getAll();
    }
    //////////////////////////////////////////////////

    public List<String> getSelectedias() {
        return selectedias;
    }

    public void setSelectedias(List<String> selectedias) {
        this.selectedias = selectedias;
    }

    public String getDetalleTurno() {
        return detalleTurno;
    }

    public void setDetalleTurno(String detalleTurno) {
        this.detalleTurno = detalleTurno;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Date getFechat() {
        return fechat;
    }

    public void setFechat(Date fechat) {
        this.fechat = fechat;
    }

    public String getNuMatriculados() {
        return nuMatriculados;
    }

    public void setNuMatriculados(String nuMatriculados) {
        this.nuMatriculados = nuMatriculados;
    }

    public int getCantMaxMatriculados() {
        return cantMaxMatriculados;
    }

    public void setCantMaxMatriculados(int cantMaxMatriculados) {
        this.cantMaxMatriculados = cantMaxMatriculados;
    }
    //***********datos del grupo*************************
    Date fechai;
    Date fechat;
    String nuMatriculados;
    int cantMaxMatriculados;

    //***************************
    public ProgramacionCurricularDao getHelper() {
        return helper;
    }

    public void setHelper(ProgramacionCurricularDao helper) {
        this.helper = helper;
    }

    public List<CapacidadDTO> getListaCapacidad() {
        return listaCapacidad;
    }

    public void setListaCapacidad(List<CapacidadDTO> listaCapacidad) {
        this.listaCapacidad = listaCapacidad;
    }

    public CapacidadTerminal getCapterminal() {
        return capterminal;
    }

    public void setCapterminal(CapacidadTerminal capterminal) {
        this.capterminal = capterminal;
    }

    public CapacidadDTO getCap() {
        return cap;
    }

    public void setCap(CapacidadDTO cap) {
        this.cap = cap;
    }
    CapacidadTerminal capterminal;
    CapacidadDTO cap;
    int capacidad1;
    String txtnombreCapacidad;

    public int getCapacidad1() {
        return capacidad1;
    }

    public void setCapacidad1(int capacidad1) {
        this.capacidad1 = capacidad1;
    }

    public String getTxtnombreCapacidad() {
        return txtnombreCapacidad;
    }

    public void setTxtnombreCapacidad(String txtnombreCapacidad) {
        this.txtnombreCapacidad = txtnombreCapacidad;
    }

    public RegistrarPCBean() {
        aceptar = true;
    }

    public void iniciarProgramacionCurricular() {
        aceptar = false;
        proc = new ProgCurricularDTO(fecharegistropc);
        ProgramacionCurricularDao dao = new ProgramacionCurricularDaoImpl();
        dao.insertarProgramacionCurricular2(dao.ultimaPcurricular() + 1, proc); //creo y guardo la prog curricular
        id_programacionCurricular = dao.ultimaPcurricular();  //guardo la id de la programacion curricular actual
    }

    public void agarroespecialidad() {
        ProgramacionCurricularDao help = new ProgramacionCurricularDaoImpl();
        System.out.println("chapo la especialidad--------*****************--" + selectEspecialidad.getNombreEspecialidad());
        //guarda el id de la capacidad seleccionada
        id_especialidad_seleccionada = selectEspecialidad.getIdEspecialidad();

        //lista de modulos
        datamodelmodulo = new ListDataModel(help.getModulos(selectEspecialidad.getIdEspecialidad()));

        ProgramacionCurricularDao daopc = new ProgramacionCurricularDaoImpl();
        CurriculaAnualDao dao = new CurriculaAnualDaoImpl();
        //String d=
        double i = Double.parseDouble(dao.ultimaCanual()) + 1;
        dao.insertarCurriculaAnual(i + "", daopc.getProgCurricular(id_programacionCurricular), daopc.getEspecialidad2(id_especialidad_seleccionada));
        id_curriculaAnual = i + "";

        //03-1manejo del dia

        //manejo del dia 

    }

    public void actualizar() {
        cantMaxMatriculados = 0;
        fechai=null;
        fechat=null;
        selectedias=null;
        docenteseleccionado=null;
        detalleTurno=null;
        
       // cantMaxMatriculados=null;
    }

    public Modulo getSelectModulo() {
        System.out.println("---------------********************grgrgr");
        return selectModulo;
    }

    public void setSelectModulo(Modulo selectModulo) {
        this.selectModulo = selectModulo;
    }

    public void agarroModulo() {
        System.out.println("chapo al modulo-------*****************--" + selectModulo.getNombreModulo());
        id_modulo_seleccionado = selectModulo.getIdModulo();   //guardo el id del modulo
        // datamodelmodulo=new ListDataModel(help.getModulos(selectEspecialidad.getIdEspecialidad())); 
    }

    public String buscarResolucion() {
        ProgramacionCurricularDao help = new ProgramacionCurricularDaoImpl();
        System.out.println("--------------------------hola");
        datamodelespecialidad = new ListDataModel(help.getEspecialidades(startId));
        System.out.println("--------------------------cotera");
        return "registrarPC";
    }

    public void agregarcapacidad() {// al hacer click a agregar capacidada
        listaCapacidad.add(new CapacidadDTO(txtnombreCapacidad));
    }

    public void guardarCapacidades() {
        CapacidadDao dao1 = new CapacidadDaoImpl();
        for (CapacidadDTO c : listaCapacidad) {
            System.out.println("guardando capacidad");
            dao1.insertarCapacidad(dao1.ultimaId() + 1, c, selectModulo);

        }
    }

    public void seleccionadias() {
        //asigno a grupo1 sus parametros
        grupo1 = new GrupoDTO(fechai, fechat, cantMaxMatriculados);
        //asigno a la programacion curricular sus parametros
        for (int i = 0; i < selectedias.size(); i++) {
            System.out.println("dias---" + selectedias.get(i));
        }

        System.out.println("fecha de inicio------------" + grupo1.getCantMaximaAlumno() + grupo1.getFecInicio());
        System.out.println("decha de termino" + fechat);
        System.out.println("nombre del docenterno----;" + docenteseleccionado.getApePaterno());

        System.out.println("turno" + detalleTurno);


        //rellenado de los dias***************************************************************
        Date d = new Date();
        Date d2 = new Date();
        TurnoDao dao1 = new TurnoDaoImpl();
        // dao1.insertarTurno(dao1.ultimaTurno()+1, turno1);
        int idturno = 0;
        if (detalleTurno.equals("mañana")) {
            idturno = 1;
        }
        if (detalleTurno.equals("tarde")) {
            idturno = 2;

        }
        if (detalleTurno.equals("noche")) {
            idturno = 3;
        }

        ModuloDao daomod = new ModuloDaoImpl();

        GrupoDao dao2 = new GrupoDaoImpl();
        dao2.insertarGrupo3(dao2.ultimaGrupo() + 1, grupo1, docenteseleccionado, dao1.getTurno(idturno), daomod.getModulo(id_modulo_seleccionado));



        id_grupo = dao2.ultimaGrupo();
        GrupoDiaDao dao5 = new GrupoDiaDoaImpl();
        DiaDao dao6 = new DiaDaoImpl();
        System.out.println("id del gru´po" + id_grupo);
        GrupoDiaId gdid = new GrupoDiaId();
        //  GrupoDiaDao

        for (int i = 0; i < selectedias.size(); i++) {
            if (selectedias.get(i).equals("lunes")) {
                gdid.setDiaIdDia(1);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(1), "");
            } else if (selectedias.get(i).equals("martes")) {
                gdid.setDiaIdDia(2);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(2), "");
            } else if (selectedias.get(i).equals("miercoles")) {
                gdid.setDiaIdDia(3);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(3), "");
            } else if (selectedias.get(i).equals("jueves")) {
                gdid.setDiaIdDia(4);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(4), "");
            } else if (selectedias.get(i).equals("viernes")) {
                gdid.setDiaIdDia(5);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(5), "");
            } else if (selectedias.get(i).equals("sabado")) {
                gdid.setDiaIdDia(6);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(6), "");
            } else if (selectedias.get(i).equals("domingo")) {
                gdid.setDiaIdDia(7);
                gdid.setGrupoIdGrupo(id_grupo);
                dao5.insertarGrupoDia(gdid, dao2.getGrupo(id_grupo), dao6.getDia(7), "");
            }

            System.out.println("dias---" + selectedias.get(i));


        }



    }

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    public int getEndId() {
        return endId;
    }

    public void setEndId(int endId) {
        this.endId = endId;
    }

    public DataModel getDatamodelcurricular() {
        return datamodelcurricular;
    }

    public void setDatamodelcurricular(DataModel datamodelcurricular) {
        this.datamodelcurricular = datamodelcurricular;
    }

    public DataModel getDatamodelespecialidad() {
        return datamodelespecialidad;
    }

    public void setDatamodelespecialidad(DataModel datamodelespecialidad) {
        this.datamodelespecialidad = datamodelespecialidad;
    }

    public DataModel getDatamodelmodulo() {

        return datamodelmodulo;
    }

    public void setDatamodelmodulo(DataModel datamodelmodulo) {
        this.datamodelmodulo = datamodelmodulo;
    }

    public Especialidad getSelectEspecialidad() {
        return selectEspecialidad;
    }

    public void setSelectEspecialidad(Especialidad selectEspecialidad) {
        this.selectEspecialidad = selectEspecialidad;
    }
}
