/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.dao.impl;

import com.matricula.dao.ConexionBD;
import com.matricula.dao.DocenteDao;
import com.matricula.model.Alumno;
import com.matricula.model.Profesor;
import com.matricula.util.HibernateUtil;
import com.matricula.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rosy
 */
public class DocenteDaoImpl  implements DocenteDao{
     
     @Override
     public void añadirProfesor(Profesor profesor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();
    }
 
    @Override
    public void deleteProfesor(Profesor profesor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(profesor);
        session.getTransaction().commit();
       
    }

    @Override
    public void updateProfesor(Profesor profesor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        profesor = new Profesor();
        profesor.setDni(profesor.getDni());
        profesor.setApePaterno(profesor.getApePaterno());
        profesor.setApeMaterno(profesor.getApeMaterno());
        profesor.setNombres(profesor.getNombres());
        profesor.setDni(profesor.getDni());
        profesor.setSexo(profesor.getSexo());
        profesor.setFecNacimiento(profesor.getFecNacimiento());
        profesor.setGradEstudios(profesor.getGradEstudios());
        profesor.setDomicilio(profesor.getDomicilio());
        profesor.setEmail(profesor.getEmail());
        profesor.setNumFijo(profesor.getNumFijo());
        profesor.setNumMovil(profesor.getNumMovil());
        session.saveOrUpdate(profesor);
        session.getTransaction().commit();
       // docenteDao.delete(docente);
    }

    @Override
    public List<Profesor> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Profesor").list();
        t.commit();
        return lista;
    }

     public Object calcularMax() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql ="select max(idProfesor) from Profesor";
        Query query = session.createQuery(hql);
        return query.uniqueResult();
    }
    
}
