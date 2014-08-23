/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.TurnoDao;
import com.matricula.dto.TurnoDTO;
import com.matricula.model.Turno;
import com.matricula.util.Constante;
import com.matricula.util.HibernateUtil;
import com.matricula.util.Util;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PEDRO
 */
public class TurnoDaoImpl implements TurnoDao{
    
    @Override
      public void insertarTurno(Integer idgru,TurnoDTO turno) {
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        Turno t =new Turno();
        t.setIdTurno(idgru);
        t.setHoraInicio(turno.getHoraInicio());
        t.setHoraTermino(turno.getHoraTermino());
        t.setDetalleTurno(turno.getDetalleTurno());
        
        session.save(t);
        session.getTransaction().commit();
        
     /*   EspecialidadDao esp = new EspecialidadDaoImpl();
            for(EspecialidadDTO e: especialidades){
                esp.insertarEspecialidad(esp.ultimaId()+1, e, rd);                
            }*/
    }
      
    
       public Turno getTurno(int idt) {
           Turno tu =null;
  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 //       org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Turno where idTurno= "+idt);
        tu = (Turno) q.uniqueResult();

    return tu;
    } 
    
    @Override
    public int ultimaTurno() {
        Session session = Util.getCurrentSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select max(idTurno) from  Turno").list();
        t.commit();
       // Turno tur = (Turno)lista.get(0);
        
           int ultimo;
        if(lista.get(0) == null){
            ultimo = Constante.CODIGO_TURNO;
        }else{
            ultimo = (Integer)lista.get(0);
        } 
        return ultimo;
    }
    
}
