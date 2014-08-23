/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;


import com.matricula.dao.EspecialidadDao;
import com.matricula.dao.ModuloDao;
import com.matricula.dao.ResolucionDirectoralDao;
import com.matricula.dao.impl.EspecialidadDaoImpl;
import com.matricula.dao.impl.ModuloDaoImpl;
import com.matricula.dao.impl.ResolucionDirectoralDaoImpl;
import com.matricula.dto.EspecialidadDTO;
import com.matricula.dto.ModuloDTO;
import com.matricula.dto.ResolucionDirectoralDTO;
import com.matricula.model.Especialidad;
import com.matricula.model.Modulo;
import com.matricula.model.ResolucionDirectoral;
import com.matricula.util.Nodo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;  
/**
 *
 * @author Juan Diego
 */
@ManagedBean(name="consultarRDBean")
@ViewScoped
public class ConsultarRDBean implements Serializable {

    private List<ResolucionDirectoral> resoluciones;
    public ResolucionDirectoral selectedRD;
    public List<EspecialidadDTO> especialidades;
    
    private TreeNode root;  
      
    
    /** Creates a new instance of ConsultarRDBean */
    public ConsultarRDBean() { 
        listarRDs();
        
    }
    
    private void listarRDs(){
        System.out.println("listando resoluciones:");
        ResolucionDirectoralDao rd = new ResolucionDirectoralDaoImpl();
        resoluciones = rd.listarRDs();
    }
    
    private List<EspecialidadDTO> changeEspecialidadToDTO(List<Especialidad> lista){
        List<EspecialidadDTO> temp = new ArrayList<EspecialidadDTO>();
        for(Especialidad i: lista){
            temp.add(new EspecialidadDTO(i.getIdEspecialidad(), i.getNombreEspecialidad(), i.getCicloEspecialidad()));
        }
        return temp;
    }
    
    private List<ModuloDTO> changeModuloToDTO(List<Modulo> lista){
        List<ModuloDTO> temp = new ArrayList<ModuloDTO>();
        for(Modulo i: lista){
            temp.add(new ModuloDTO(i.getIdModulo(), i.getNombreModulo(), Integer.parseInt(i.getHorasModulo())));
        }
        return temp;
    }
    
    public void listarEspecialidades(){
        EspecialidadDao esp = new EspecialidadDaoImpl();
        System.out.println("listarEspecialidadesEnRD "+selectedRD.getIdRd());
        List<Especialidad> lista = esp.listarEspecialidades(selectedRD.getIdRd());
        especialidades = changeEspecialidadToDTO(lista);
        
        for(EspecialidadDTO i: especialidades){
            List<Modulo> mod = listarModulosEnEspecialidad(i.getIdEspecialidad());
            i.setModulos(changeModuloToDTO(mod));
        }
        //llenarArbol();
    }
    
    public List<Modulo> listarModulosEnEspecialidad(int idEspecialidad){
        ModuloDao mod = new ModuloDaoImpl();
        List<Modulo> lista = mod.listarModulos(idEspecialidad);
        return lista;
        /*for(Modulo i: lista){
            System.out.println("................. "+i.getIdModulo()+" <-> "+i.getNombreModulo());
        } */       
    }
    
    private void llenarArbol(){
        root = new DefaultTreeNode("root", null);  
        TreeNode esp;
        TreeNode in;
        for(EspecialidadDTO i: especialidades){
            esp = new DefaultTreeNode(new Nodo(i.getNombreEspecialidad(), i.getCicloEspecialidad(), null), root);
            for(ModuloDTO a: i.getModulos()){
                in = new DefaultTreeNode(new Nodo("-",a.getNombreModulo(),a.getHorasModulo()+""), esp);
            }
        }        
    }
    
    public TreeNode getRoot() {  
        return root;  
    }  
    
    public List<EspecialidadDTO> getEspecialidades(){
        return especialidades;
    }

    public ResolucionDirectoral getSelectedRD() {
        return selectedRD;
    }

    public void setSelectedRD(ResolucionDirectoral selectedRD) {
        this.selectedRD = selectedRD;
    }
    
    public List<ResolucionDirectoral> getResoluciones(){
        return resoluciones;
    }
    
}
