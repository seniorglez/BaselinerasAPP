/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author EdoardoELH
 */
public class Delete {
    ///Atributos///
    private static Delete delete;
    private java.sql.Connection con;
    private int numCol;

    ///Constructores///
    private Delete() {

    }

    ///Metodos///
    public static Delete getConnection() {
        if (delete == null) {
            delete = new Delete();
        }
        return delete;
    }

    public int executeDelete(String sql) {
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
