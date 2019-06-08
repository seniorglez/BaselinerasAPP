/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author EdoardoELH
 */
public class SQLOperations {

    ///Atributos///
    private static SQLOperations operations;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private java.sql.Connection con;
    private Object[] fila;
    private int numCol;
    private Statement st;

    ///Constructores///
    private SQLOperations() {

    }

    ///Metodos///
    public static SQLOperations getSQLOperations() {
        if (operations == null) {
            operations = new SQLOperations();
        }
        return operations;
    }

    public void executeSelect(String sql) {
        con = Connection.getConnection().getC();
        try{
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rsmd = rs.getMetaData();
            numCol = rsmd.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int doUpdate(String sql){
        con = Connection.getConnection().getC();
        try (Statement st = con.createStatement();) {
            numCol = st.executeUpdate(sql);
            return numCol;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public int doDelete(String sql) {
        con = Connection.getConnection().getC();
        try (Statement st = con.createStatement();) {
            numCol = st.executeUpdate(sql);
            return numCol;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public Object[] getRow() {
        try {
            if (st.isClosed()) {
                System.out.println("La peticion de fila ha devuelto null");
                return null;
            }
            if (rs.next()) {
                fila = new Object[numCol];
                for (int i = 0; i < numCol; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                return fila;
            }else{
                st.close();
            }
            
        } catch (SQLException ex) {
            System.err.println("Nota: Este error lo suele soltar por que la consulta no ha devuelto nada");
            ex.printStackTrace();
        }
        return null;
    }
    
    public int doInsert (String sql){
        con = Connection.getConnection().getC();
        try (Statement st = con.createStatement();) {
            numCol = st.executeUpdate(sql);
            return numCol;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int getNumCol() {
        return numCol;
    }
    
}
