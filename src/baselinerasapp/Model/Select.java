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
public class Select {

    ///Atributos///
    private static Select select;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private java.sql.Connection con;
    private Object[] fila;
    private int numCol;
    private Statement st;

    ///Constructores///
    private Select() {

    }

    ///Metodos///
    public static Select getSelect() {
        if (select == null) {
            select = new Select();
        }
        return select;
    }

    public void executeSelect(String sql) {
        con = Connection.getConnection().getC();
        try{
//            if (!st.isClosed()) {
//                st.close();
//            }
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rsmd = rs.getMetaData();
            numCol = rsmd.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Object[] getRow() {
        try {
            if (st.isClosed()) {
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

    public int getNumCol() {
        return numCol;
    }
    
}
