/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.CurriculaAnualDao;
import com.matricula.model.CurriculaAnual;
import com.matricula.model.Especialidad;
import com.matricula.model.ProgCurricular;
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
public class CurriculaAnualDaoImpl implements CurriculaAnualDao{
    
     public CurriculaAnual getCurriculaAnual(String idca) {
        CurriculaAnual ca=null;
  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 //       org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from CurriculaAnual where idCurriculaAnual= "+idca);
        ca = (CurriculaAnual) q.uniqueResult();

    return ca;
    
    }  
      public void insertarCurriculaAnual(String idca, ProgCurricular pro, Especialidad esp){
        
          //****************para la curricula anual------------
        Session session1 = Util.getCurrentSession();
        session1.beginTransaction();
        CurriculaAnual cua=new CurriculaAnual();
        cua.setIdCurriculaAnual(idca);  //puede haber problemas por q es varchar
        cua.setEspecialidad(esp);
        cua.setProgCurricular(pro);
       //* System.out.println("probando---"+esp.getNombreEspecialidad());
        session1.save(cua);
        session1.getTransaction().commit();
         }
        
      
      public String ultimaCanual() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select max(idCurriculaAnual) from  CurriculaAnual").list();
        t.commit();
        System.out.println("-->"+lista.get(0));
        int ultimo;
        String ult="";
        if(lista.get(0) == null){
            ultimo = Constante.CODIGO_CURRICULANUAL;
            ult=ultimo+"";
        }else{
            ult = (String)lista.get(0);
        } 
        return ult;
    }
    
}
