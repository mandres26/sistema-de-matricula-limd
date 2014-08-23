/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.CapacidadDao;
import com.matricula.dto.CapacidadDTO;
import com.matricula.model.CapacidadTerminal;
import com.matricula.model.Modulo;
import com.matricula.util.Constante;
import com.matricula.util.HibernateUtil;
import com.matricula.util.Util;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PEDRO
 */
public class CapacidadDaoImpl implements CapacidadDao{
    
    @Override
     public void insertarCapacidad( int codCapacidad,CapacidadDTO cap, Modulo mod) {
         
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        CapacidadTerminal capacidadterminal = new CapacidadTerminal();
        System.out.println("CAPACIDAD!!!!!!!!!! "+codCapacidad+" - "+
                cap.getNombreCt()+" - "+cap.getNotaCt()+" - "+mod.getIdModulo());
     
        capacidadterminal.setIdCodigo(codCapacidad);
        capacidadterminal.setNombreCt(cap.getNombreCt());
        capacidadterminal.setModulo(mod);
        session.save(capacidadterminal);
        session.getTransaction().commit();
  
    }   
    
    
        public int ultimaId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select max(idCodigo) from  CapacidadTerminal").list();
        t.commit();
        System.out.println("-->"+lista.get(0));
        int ultimo;
        if(lista.get(0) == null){
            ultimo = Constante.CODIGO_CAPACIDAD;
        }else{
            ultimo = (Integer)lista.get(0);
        } 
        return ultimo;
    }
        
        
    static void saveCapacidad(CapacidadTerminal capacidad) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(capacidad);
        t.commit();       
    }    
    
}
