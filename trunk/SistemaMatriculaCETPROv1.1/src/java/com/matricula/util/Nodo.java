/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matricula.util;

/**
 *
 * @author Juan Diego
 */
public class Nodo {
    public String dato1;
    public String dato2;
    public String dato3;

    public Nodo(String dato1, String dato2, String dato3) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    public String getDato3() {
        return dato3;
    }

    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }
            
}
