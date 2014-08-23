/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.bean;

import com.matricula.dao.UsuarioDao;
import com.matricula.dao.impl.UsuarioDaoImpl;
import com.matricula.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.primefaces.context.RequestContext;

/**
 *
 * @author FELIPE
 */
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean implements java.io.Serializable{
    private Usuario usuario;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public Usuario getUsuario() {
        if (usuario==null) {
            usuario=new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;
        boolean loggedIn = false;
        
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        System.out.println("NOMBRE: "+usuario.getNombreUsuario()+usuario.getContraseniaUsuario());
        usuario = usuarioDao.buscarUsuario(usuario);
        
        
        if(usuario!=null) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario.getNombreUsuario());  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en el logueo", "Datos Incorrectos");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
    
    public void logout() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        try {
          ((HttpSession) ctx.getSession(false)).invalidate();
          ctx.invalidateSession();
          ctx.redirect(ctxPath + "/view/login.jsf");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }

    public void logout2(){ 
        FacesContext fc = FacesContext.getCurrentInstance();  
        Session session = (Session) fc.getExternalContext().getSession(false);  
        session.close();  
    }
     /*Para comprobar si el usuario debe verlo o no*/
    public boolean comprobarUsuarioRegistrarAlumno(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return true;}
    else{
        return false;}        
    }
    
    public boolean comprobarUsuarioRegistrarDocente(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   
    }
    public boolean comprobarUsuarioRegistrarRd(){
        if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   
    }
    public boolean comprobarUsuarioRegistrarPc(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   }          
    public boolean comprobarUsuarioRegistrarMatricula(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return true;}
    else{
        return false;}   }
    public boolean comprobarUsuarioBuscarAlumno1(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return true;}
    else{
        return false;}   }
    public boolean comprobarUsuarioMantenerDocente(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return false;}   }
    public boolean comprobarUsuarioMantenerRd(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   }
    public boolean comprobarUsuarioMantenerPc(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   }
            
    public boolean comprobarUsuarioBuscarAlumno(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return true;}
    else{
        return false;}   }
    public boolean comprobarUsuarioConsultarModulos(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return true;}
    else{
        return true;}   }
    public boolean comprobarUsuarioConsultarPc(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   }
    public boolean comprobarConsultarRd(){
    if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}   } 
     public boolean comprobarUsuarioModificarAlumno(){
      if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return true;}
    else{
        return false;} 
     }
     public boolean comprobarUsuarioManternerEspecialidades(){
      if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}          
     }
     public boolean comprobarUsuarioResolucionDirectoral(){
      if(usuario.getNombreUsuario().equals("admin")){
    return true;    }
    else if(usuario.getNombreUsuario().equals("secretaría")){
         return false;}
    else{
        return true;}     
     }
}
