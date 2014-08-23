/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.GrupoDiaDao;
import com.matricula.model.Dia;
import com.matricula.model.Grupo;
import com.matricula.model.GrupoDia;
import com.matricula.model.GrupoDiaId;
import com.matricula.util.HibernateUtil;
import com.matricula.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PEDRO
 */
public class GrupoDiaDoaImpl implements GrupoDiaDao{
    
    
      public void insertarGrupoDiaId(Integer idDia,Integer idGrupo){
          
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        GrupoDiaId GRUPOdiaId = new GrupoDiaId();
        
        
        GRUPOdiaId.setDiaIdDia(idDia);
        GRUPOdiaId.setGrupoIdGrupo(idGrupo);
        
    
        session.save(GRUPOdiaId);
        session.getTransaction().commit();
    }
      
      
       public void insertarGrupoDia(GrupoDiaId gdid,Grupo gru,Dia dia, String desc){
          
        Session session = Util.getCurrentSession();
        session.beginTransaction();
        
        GrupoDia grupodia = new GrupoDia();
        
        
        grupodia.setId(gdid);
        grupodia.setGrupo(gru);
        grupodia.setDia(dia);
        grupodia.setDescripcionGrupoDia(desc);
           
        session.save(grupodia);
        session.getTransaction().commit();
    }
       
           public GrupoDiaId getGrupodiaId(int idgrupo) {
           GrupoDiaId tu =null;
  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 //       org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from GrupoDiaId where grupoIdGrupo= "+idgrupo);
        tu = (GrupoDiaId) q.uniqueResult();

    return tu;
    } 
}
