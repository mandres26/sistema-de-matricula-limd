/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matricula.service;

/**
 *
 * @author FELIPE
 */
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.model.UploadedFile;  
  
public class FileUploadController {  
  
    private UploadedFile file;  
  
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() {  
        if(file != null) {  
            FacesMessage msg = new FacesMessage("Hecho", file.getFileName() + " esta subido.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }  
}
