/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.DiaDao;
import com.matricula.model.Dia;
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
public class DiaDaoImpl implements DiaDao{
    
      public void insertarDia(Integer iddia,String nombred) {
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        Dia d =new Dia();
        d.setIdDia(iddia);
        d.setNombreDia(nombred);
        session.save(d);
        session.getTransaction().commit();

    }
      
      
     public Dia getDia(int idt) {
           Dia dia =null;
  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 //       org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Dia where idDia= "+idt);
        dia = (Dia) q.uniqueResult();

    return dia;
    } 
}
