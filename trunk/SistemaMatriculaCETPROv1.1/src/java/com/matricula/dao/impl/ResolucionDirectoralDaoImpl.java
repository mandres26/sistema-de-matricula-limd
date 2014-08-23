/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.EspecialidadDao;
import com.matricula.dao.ResolucionDirectoralDao;
import com.matricula.model.ResolucionDirectoral;
import com.matricula.dto.EspecialidadDTO;
import com.matricula.util.Util;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Diego
 */
public class ResolucionDirectoralDaoImpl implements ResolucionDirectoralDao {

    @Override
    public boolean existeIDenRD(Integer number) {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        String sql = "from ResolucionDirectoral "
                + " where idRD=:id ";
        Query query = session.createQuery(sql);
        query.setParameter("id", number);
        List lista =query.list();        
        t.commit();
        return !lista.isEmpty();
    }
    
    @Override
    public List<ResolucionDirectoral> getRD(Integer number) {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        String sql = "from ResolucionDirectoral "
                + " where idRD=:id ";
        Query query = session.createQuery(sql);
        query.setParameter("id", number);
        List lista =query.list();        
        t.commit();
        return lista;
    }

    @Override
    public void insertarRD(Integer idRD, Integer anioInicio, 
        Integer anioTermino, Date fecRegistro, List<EspecialidadDTO> especialidades) {
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        ResolucionDirectoral rd = new ResolucionDirectoral();
        System.out.println("grabaaaaaaaaaaaaaaaaar "+idRD+" - "+anioInicio+" - "+anioTermino+" - "+fecRegistro);
        rd.setIdRd(idRD);
        rd.setAnioInicio(anioInicio);
        rd.setAnioTermino(anioTermino);
        rd.setFecRegistro(fecRegistro);
        session.save(rd);
        session.getTransaction().commit();
        EspecialidadDao esp = new EspecialidadDaoImpl();
            for(EspecialidadDTO e: especialidades){
                esp.insertarEspecialidad(esp.ultimaId()+1, e, rd);
            }
    } 

    @Override
    public List<ResolucionDirectoral> listarRDs() {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from ResolucionDirectoral").list();
        t.commit();
        return lista;
    }

    @Override
    public int ultimaID() {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select NVL(MAX( idRD ), 1) from  ResolucionDirectoral").list();
        t.commit();
        ResolucionDirectoral rd = (ResolucionDirectoral)lista.get(0);
        return rd.getIdRd();
    }

}
