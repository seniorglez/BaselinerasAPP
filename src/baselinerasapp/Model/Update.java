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
public class Update {
    ///Atributos///
    private static Update update;
    private java.sql.Connection con;
    private int numCol;

    ///Constructores///
    private Update() {

    }

    ///Metodos///
    public static Update getConnection() {
        if (update == null) {
            update = new Update();
        }
        return update;
    }

    public int executeUpdate(String sql) {
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
