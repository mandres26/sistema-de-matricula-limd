/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;
import com.matricula.dao.EspecialidadDao;
import com.matricula.dao.ModuloDao;
import com.matricula.dto.EspecialidadDTO;
import com.matricula.dto.ModuloDTO;
import com.matricula.model.Especialidad;
import com.matricula.model.ResolucionDirectoral;
import com.matricula.util.Constante;
import com.matricula.util.Util;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Diego
 */
public class EspecialidadDaoImpl implements EspecialidadDao {
    
    
    @Override
    public void insertarEspecialidad(Integer idEspecialidad, 
            EspecialidadDTO esp, ResolucionDirectoral rd) {
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        Especialidad especialidad = new Especialidad();
        System.out.println("Especialidad!!!!!!!!!!! "+idEspecialidad+" - "+
                esp.getNombreEspecialidad()+" - "+esp.getCicloEspecialidad()+" - "+rd.getIdRd());
        especialidad.setIdEspecialidad(idEspecialidad);
        especialidad.setNombreEspecialidad(esp.getNombreEspecialidad());
        especialidad.setCicloEspecialidad(esp.getCicloEspecialidad());
        especialidad.setResolucionDirectoral(rd);
        session.save(especialidad);
        session.getTransaction().commit();
        ModuloDao mod = new ModuloDaoImpl();
            for(ModuloDTO m: esp.getModulos()){
                mod.insertarModulo(mod.ultimaId()+1, m, especialidad);
            }
    }

    @Override
    public int ultimaId() {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select max(idEspecialidad) from  Especialidad").list();
        t.commit();
        System.out.println("-->"+lista.get(0));
        int ultimo;
        if(lista.get(0) == null){
            ultimo = Constante.CODIGO_ESPECIALIDAD;
        }else{
            ultimo = (Integer)lista.get(0);
        } 
        return ultimo;
    }

    @Override
    public List<Especialidad> listarEspecialidades(Integer idRD) {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        String sql = "from Especialidad "
                + " where RESOLUCION_DIRECTORAL_numResolucionD=:id ";
        Query query = session.createQuery(sql);
        query.setParameter("id", idRD);
        List lista =query.list();        
        t.commit();
        return lista;
    }
}
