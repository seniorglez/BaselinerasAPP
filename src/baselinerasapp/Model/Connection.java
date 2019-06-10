/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edoar
 */
public class Connection {
    ///Atributos///
    private String url = "jdbc:oracle:thin:@sveddie.hundirlaweb.es:1521:xe";
    private String user = "GESTOR_GASOLINERAS";
    private String password = "Passw0rd";
    java.sql.Connection c;
    private static Connection myConnection;
    
    ///Constructores///
    private Connection(){
        try {
            c=DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException ex) {
            System.out.println("Error en la conexion con la base de datos");
        }
    }
    ///Metodos///
    public static Connection getConnection(){
        if (myConnection == null){
            myConnection = new Connection();
        }
        return myConnection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Connection getC() {
        return c;
    }

    public void setC(java.sql.Connection c) {
        this.c = c;
    }
    
    
      
}
