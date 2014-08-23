/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matricula.dao.impl;

import com.matricula.dao.UsuarioDao;
import com.matricula.model.Usuario;
import com.matricula.util.HibernateUtil;
import com.matricula.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FELIPE
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Util.setCurrentSession(session);
        //String sql = "select p from Persona p where personaCodigoSistema=:user and personaPasswordSistema=:pass";
        String sql = "select u from Usuario u "
                + " where u.nombreUsuario=:user "
                + " and u.contraseniaUsuario=:pass";
        Query query = session.createQuery(sql);
        query.setString("user", usuario.getNombreUsuario());
        query.setString("pass", usuario.getContraseniaUsuario());
        return (Usuario) query.uniqueResult();
    }
    
}
