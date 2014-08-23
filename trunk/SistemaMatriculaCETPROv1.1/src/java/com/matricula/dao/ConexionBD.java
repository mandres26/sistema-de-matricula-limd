/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matricula.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FELIPE
 */
public class ConexionBD {
    private java.sql.Connection conexion;

    public java.sql.Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/matriculatp2","matriculatp2","123456");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

    public void setConexion(java.sql.Connection conexion) {
        this.conexion = conexion;
    }
 
    public ConexionBD Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BaseDeDatos = "jdbc:mysql://db4free.net:3306/matriculatp2?user=matriculatp2&password=123456";
            setConexion(DriverManager.getConnection(BaseDeDatos));
            if(getConexion() != null){
                System.out.println("Conexion Exitosa!");
            }else{
                System.out.println("Conexion Fallida!");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}

