/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matricula.dao.impl;

import com.matricula.dao.ConexionBD;
import com.matricula.dao.AlumnoDao;
import com.matricula.model.Alumno;
import com.matricula.util.HibernateUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FELIPE
 */
public class AlumnoDaoImpl implements AlumnoDao{
    
    @Override
    public void añadirAlumno(Alumno alumno){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(alumno);
        session.getTransaction().commit();
    }

    @Override
    public Object calcularMax() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql ="select max(idAlumno) from Alumno";
        Query query = session.createQuery(hql);
        return query.uniqueResult();
    }

    public  List<Alumno> cargarAlumnos(){
     Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Alumno").list();
        t.commit();
        return lista;
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(alumno);
        session.getTransaction().commit();
    }
}
