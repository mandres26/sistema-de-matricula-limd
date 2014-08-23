/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.ProgramacionCurricularDao;
import com.matricula.dto.ProgCurricularDTO;
import com.matricula.model.CurriculaAnual;
import com.matricula.model.Especialidad;
import com.matricula.model.Modulo;
import com.matricula.model.ProgCurricular;
import com.matricula.model.ResolucionDirectoral;
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
public class ProgramacionCurricularDaoImpl implements ProgramacionCurricularDao {
    
     Session session = null;
     ResolucionDirectoral rd = null;


    public ResolucionDirectoral getRd() {
        return rd;
    }

    public void setRd(ResolucionDirectoral rd) {
        this.rd = rd;
    }
    
   /*   public List getFilmTitles(int startID, int endID) {
    List<ResolucionDirectoral> filmList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from ResolucionDirectoral as ResolucionDirectoral where ResolucionDirectoral.id between '"+startID+"' and '"+endID+"'");
        filmList = (List<ResolucionDirectoral>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return filmList;
}*/
    
    
  public List getListaResolucion(int idRe) {
    List<ResolucionDirectoral> resolucionList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from ResolucionDirectoral as ResolucionDirectoral where ResolucionDirectoral.id = "+idRe);
        resolucionList = (List<ResolucionDirectoral>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resolucionList;
}  
  
    @Override
    public void Resolucionhiber(int idRe) {
  
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from ResolucionDirectoral as ResolucionDirectoral where ResolucionDirectoral.id = "+idRe);
        rd = (ResolucionDirectoral) q.uniqueResult();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    }  
  
      public Especialidad getEspecialidad2(int idRe) {
           Especialidad es=null;
  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 //       org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Especialidad where idEspecialidad= "+idRe);
        es = (Especialidad) q.uniqueResult();

    return es;
    } 
   
      public ProgCurricular getProgCurricular(int idpc) {
           ProgCurricular pc=null;
  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
 //       org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from ProgCurricular where idProgCurricular= "+idpc);
        pc = (ProgCurricular) q.uniqueResult();

    return pc;
    
    } 
      

      
      
public List getEspecialidades(int Ides){   //funciona bien
   // List<Especialidad> especialidadList = null;
    
     Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List especialidadList = session.createQuery(" from Especialidad where RESOLUCION_DIRECTORAL_numResolucionD="+Ides).list();
        t.commit();
    return especialidadList;
    } 
    
    
      

public List getModulos(int Idmo){
    
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List moduloList = session.createQuery("from Modulo where ESPECIALIDAD_idEspecialidad="+Idmo).list();
        t.commit();
        
   
    return moduloList;
}


   
  /*  public void insertarProgramacionCurricular(Integer idpc, ProgCurricularDTO pro,
             Especialidad esp){
        
        Session session2 = Util.getCurrentSession();
        session2.beginTransaction();
        ProgCurricular pc=new ProgCurricular();
        
        pc.setIdProgCurricular(idpc);
        pc.setFecRegistro(pro.getFecRegistro());
        pc.setDetalle(pro.getDetalle());
        
        session2.save(pc);
        session2.getTransaction().commit();
        
     //****************para la curricula anual------------
        Session session1 = Util.getCurrentSession();
        session1.beginTransaction();
        CurriculaAnual cua=new CurriculaAnual();
        
        cua.setIdCurriculaAnual(Double.parseDouble(ultimaCanual())+1+"");  //puede haber problemas por q es varchar
        
        cua.setEspecialidad(esp);
        cua.setProgCurricular(pc);
       //* System.out.println("probando---"+esp.getNombreEspecialidad());
           
        session1.save(cua);
        session1.getTransaction().commit();
        
        
        
        //for para guardar  los grupos-------------
        
        
    }*/
    
    
       public void insertarProgramacionCurricular2(Integer idpc, ProgCurricularDTO pro){
        Session session2 = Util.getCurrentSession();
        session2.beginTransaction();
        ProgCurricular pc=new ProgCurricular();
        pc.setIdProgCurricular(idpc);
        pc.setFecRegistro(pro.getFecRegistro());
        pc.setDetalle(pro.getDetalle());
        session2.save(pc);
        session2.getTransaction().commit();
       }
    
    
    
        public int ultimaPcurricular() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select max(idProgCurricular) from  ProgCurricular").list();
        t.commit();
        System.out.println("-->"+lista.get(0));
        int ultimo;
        if(lista.get(0) == null){
            ultimo = Constante.CODIGO_PCURRICULAR;
        }else{
            ultimo = (Integer)lista.get(0);
        } 
        return ultimo;
    }

        
 



    /*
    public void mensaje(){
    System.out.println("boton funcionando");
    }   */
}
