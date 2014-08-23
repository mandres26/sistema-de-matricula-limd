/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;


import com.matricula.dao.ResolucionDirectoralDao;
import com.matricula.dao.impl.ResolucionDirectoralDaoImpl;
import com.matricula.dto.EspecialidadDTO;
import com.matricula.dto.ModuloDTO;
import com.matricula.model.ResolucionDirectoral;
import com.matricula.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author james
 */
@ManagedBean(name="mantenerRDBean")
@ViewScoped
public class MantenerRDBean implements Serializable  {
    private int anioInicio;  
    private int anioFin;
    private int idResolucion;
    private boolean registro;
    private String txtModulo;
    private int txtHorasModulo;
    private ModuloDTO modSeleccionado;
    private List<SelectItem> listaAnios;
    
    
    private int idEspecialidad;
    private String txtEspecialidad;
    private String txtCicloEsp;
    private List<ModuloDTO> modulos;
    private List<EspecialidadDTO> especialidades = null;
    private EspecialidadDTO espSeleccionada;
    
    private ResolucionDirectoral resolucionDirectoralSeleccionado;
    private List<ResolucionDirectoral> auxRD;
    
    /** Creates a new instance of RegistrarRDBean */
    public MantenerRDBean() {
        registro = true;
        listaAnios=new ArrayList<SelectItem>();
        listaAnio();
    }

    private List<SelectItem> listaAnio() {
		listaAnios.clear();
		listaAnios.add(new SelectItem(-1, "Seleccione Año"));
		for (int i = 2005; i <= 2025; i++) {
			listaAnios.add(new SelectItem(i, Integer.toString(i)));
		}
		return listaAnios;
	}
    
    public boolean isRegistro() {
        return registro;
    }

    public void setRegistro(boolean registro) {
        this.registro = registro;
    }
    
    public void registrarRD(){
        if(idResolucion == 0 || anioInicio == -1 || anioFin == -1){
            Util.mostrarMensajeINFO("Faltan datos en RD", "Completar");
        }else{
            for(EspecialidadDTO i: especialidades){
                if(i.getModulos() == null){
                    Util.mostrarMensajeERROR("Datos Incompletos", 
                            "Hay una especialidad sin módulos");
                }else{
                    grabarRD();
                }
            }
        }
        
    }
    
    public void CargarRD(){
        ResolucionDirectoralDao resolucionDao = new ResolucionDirectoralDaoImpl();
        if(resolucionDao.existeIDenRD(idResolucion)){
            System.out.println("asdfñkajsdfñkljasflñkjawslñkfjasñldkfjwalñkejflkañsjdflñkjawelñkfjawsñlfj");
            System.out.println("MSJ ID EXISTENTE");
            ResolucionDirectoralDao rd=new ResolucionDirectoralDaoImpl();
            auxRD= rd.getRD(idResolucion);    
            for(ResolucionDirectoral o: auxRD){
                resolucionDirectoralSeleccionado=o;
            }
            Util.mostrarMensajeINFO("Resolución Cargada","Éxito en la operación");
        }else{
            System.out.println("MSJ ID NO EXISTENTE");
            Util.mostrarMensajeERROR("ID No Existente", "Cambie la id de la Resolución");
            
            
        }
    }
    
    private void grabarRD(){
       ResolucionDirectoralDao resolucionDao = new ResolucionDirectoralDaoImpl();
        if(resolucionDao.existeIDenRD(idResolucion)){
            System.out.println("MSJ ID EXISTENTE");
            Util.mostrarMensajeERROR("ID existente", "Cambie la id de la Resolución");
        }else{
            java.util.Date fecha = new Date();
            resolucionDao.insertarRD(idResolucion, 
                    anioInicio, anioFin, fecha, especialidades);
            //System.out.println("RD grabada");
            Util.mostrarMensajeINFO("Resolución Guardada","Éxito en la operación");
        }
    }
    
    private void cargarRD(){
        ResolucionDirectoralDao resolucionDao = new ResolucionDirectoralDaoImpl();
        if(resolucionDao.existeIDenRD(idResolucion)){
            System.out.println("MSJ ID EXISTENTE");
            //Util.mostrarMensajeERROR("ID existente", "Cambie la id de la Resolución");
            //ResolucionDirectoral rd = resolucionDao.getRD(idResolucion);
           // anioInicio=rd.getAnioInicio();
            //anioFin=rd.getAnioTermino();
            ResolucionDirectoralDao rd=new ResolucionDirectoralDaoImpl();
            auxRD= rd.getRD(idResolucion);    
            for(ResolucionDirectoral o: auxRD){
                resolucionDirectoralSeleccionado=o;
            }
            Util.mostrarMensajeINFO("Resolución Cargada","Éxito en la operación");
        }else{
            System.out.println("MSJ ID NO EXISTENTE");
            Util.mostrarMensajeERROR("ID No Existente", "Cambie la id de la Resolución");
            
            
        }
    }

    public ModuloDTO getModSeleccionado() {
        return modSeleccionado;
    }

    public void setModSeleccionado(ModuloDTO modSeleccionado) {
        this.modSeleccionado = modSeleccionado;
    }
    
    public int getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public int getIdResolucion() {
        return idResolucion;
    }

    public void setIdResolucion(int idResolucion) {
        this.idResolucion = idResolucion;
    }

    public int getTxtHorasModulo() {
        return txtHorasModulo;
    }

    public void setTxtHorasModulo(int txtHorasModulo) {
        this.txtHorasModulo = txtHorasModulo;
    }

    public String getTxtModulo() {
        return txtModulo;
    }

    public void setTxtModulo(String txtModulo) {
        this.txtModulo = txtModulo;
    }
    
    public void addModulos(){
        if(!txtModulo.isEmpty() && txtHorasModulo != 0){
            nuevoModulo();
        }else{
            Util.mostrarMensajeINFO("Falta datos", "En el Editor de Módulos");
        }
    }
    
    private void nuevoModulo(){
        if (espSeleccionada != null){
            if (espSeleccionada.getModulos() == null){
                List<ModuloDTO> modTemporal = new ArrayList<ModuloDTO>();
                modTemporal.add(new ModuloDTO(txtModulo, txtHorasModulo));
                espSeleccionada.setModulos(modTemporal);
                limpiarDatosModulo();
            }else{
                if (!existeModulo(espSeleccionada.getModulos())){
                    espSeleccionada.agregarModulo(new ModuloDTO(txtModulo, txtHorasModulo));
                    limpiarDatosModulo();
                }                
                else{
                    Util.mostrarMensajeINFO("Ya existe ese módulo", "Cambie el nombre de la especialidad");
                }                
            }
        }
    }
    
    private boolean existeModulo(List<ModuloDTO> mod){
        for(ModuloDTO i: mod){
           if(i.getNombreModulo().equals(txtModulo)){
               return true;
           }
        }
        return false;
    }
    
    private void limpiarDatosModulo(){
        setTxtModulo("");
        setTxtHorasModulo(0);
    }
    
    private void limpiarDatosEspecialidad(){
        setTxtModulo("");
    }
    
    public void borrarEspecialidad(){
        System.out.println("borrando "+espSeleccionada.getNombreEspecialidad());
        especialidades.remove(espSeleccionada);
    }
    
    public void borrarModulo(){
        System.out.println("borrando "+modSeleccionado.getNombreModulo());
        espSeleccionada.getModulos().remove(modSeleccionado);
    }

    public List<SelectItem> getListaAnios() {        
        return listaAnios;
    }

    public void setListaAnios(List<SelectItem> listaAnios) {
        this.listaAnios = listaAnios;
    }
    
    
    
    
    //Agregados
    
    public void addEspecialidad(){
        if(!txtEspecialidad.isEmpty() && !txtCicloEsp.isEmpty()){
            nuevaEspecialidad();
        }else{
            Util.mostrarMensajeINFO("Falta datos", "Ingrese nombre de la Especialidad");
        }
        registro = especialidades.isEmpty();
    }
    
    private void nuevaEspecialidad(){ 
        txtCicloEsp = "Básico";
        if (especialidades == null){
            especialidades = new ArrayList<EspecialidadDTO>();
            especialidades.add(new EspecialidadDTO(txtEspecialidad, txtCicloEsp));
            limpiarDatosEspecialidad();
        }else{
            if (!existeEspecialidad(especialidades)){
                especialidades.add(new EspecialidadDTO(txtEspecialidad, txtCicloEsp));
                limpiarDatosEspecialidad();
            }                
            else{
                Util.mostrarMensajeINFO("Ya existe especialidad", "Cambie el nombre de la especialidad");
            }                
        }
    }
    
    private boolean existeEspecialidad(List<EspecialidadDTO> esp){
        for(EspecialidadDTO i: esp){
           if(i.getNombreEspecialidad().equals(txtEspecialidad)){
               return true;
           }
        }
        return false;
    }
    
    public EspecialidadDTO getEspSeleccionada() {
        return espSeleccionada;
    }

    public void setEspSeleccionada(EspecialidadDTO espSeleccionada) {
        this.espSeleccionada = espSeleccionada;
    }   

    public List<EspecialidadDTO> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadDTO> especialidades) {
        this.especialidades = especialidades;
    }

    public String getTxtCicloEsp() {
        return txtCicloEsp;
    }

    public void setTxtCicloEsp(String txtCicloEsp) {
        this.txtCicloEsp = txtCicloEsp;
    }

    public String getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public void setTxtEspecialidad(String txtEspecialidad) {
        this.txtEspecialidad = txtEspecialidad;
    }
    
    
    
    public void setModulos(List<ModuloDTO> modulos) {
        this.modulos = modulos;
    }
    
    public List<ModuloDTO> getModulos(){        
        return modulos;
    }

    /*
    public List<Especialidad> getEsp() {
        //obtenemos datos de especialidad
        EspecialidadDTO e1 = new EspecialidadDTO(12,"Computacion","Básico");
        EspecialidadDTO e2 = new EspecialidadDTO(12,"Computacion","Básico");
        List<Especialidad> le = null;
        e1.get
        le.add(e1);
        le.add(e2);
        return le;
    }*/

    public ResolucionDirectoral getResolucionDirectoralSeleccionado() {
        return resolucionDirectoralSeleccionado;
    }

    public void setResolucionDirectoralSeleccionado(ResolucionDirectoral resolucionDirectoralSeleccionado) {
        this.resolucionDirectoralSeleccionado = resolucionDirectoralSeleccionado;
    }

    public List<ResolucionDirectoral> getAuxRD() {
        return auxRD;
    }

    public void setAuxRD(List<ResolucionDirectoral> auxRD) {
        this.auxRD = auxRD;
    }
       
    
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }    
    
    public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  
          
        if(newValue != null && !newValue.equals(oldValue)) {  
            Util.mostrarMensajeINFO("Celda Editada", "Antiguo: " + oldValue + ", Nuevo:" + newValue);
        }  
    }
    
}
