/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Controlador;

import baselinerasapp.Model.Select;
import baselinerasapp.view.LoggingFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import baselinerasapp.Model.UsersDB;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;

/**
 *
 * @author edoar
 */
public class Controller implements ActionListener, KeyListener {

    ///Atributos///
    private static Controller controller;
    private Select select = Select.getSelect();
    private UsersDB usuarioActual = null;

    ///Constructores///
    private Controller() {

    }

    ///Metodos///
    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    private String generarSQLLogin() {
        //Variables//
        String sql = "SELECT NOMBRE_USUARIO, CONTRASENIA, TIPO, REFERENCIA FROM USUARIOS WHERE NOMBRE_USUARIO LIKE '";
        String contrasenia = "";
        char[] caracteresCon = LoggingFrame.getLoginFrame().getPassb().getPassword();

        //Codigo//
        //Conversion de contraseña a String
        for (int i = 0; i < caracteresCon.length; i++) {
            contrasenia += caracteresCon[i];
        }

        //Concatenacion de sql
        sql += LoggingFrame.getLoginFrame().getCajaTexto().getText();
        sql += "' AND CONTRASENIA LIKE '";
        sql += contrasenia;
        sql += "'";

        return sql;
    }

    private void IniciarSesion() {
        //Variables
        String sql;
        Object[] fila;

        //Codigo
        sql = generarSQLLogin();
        select.executeSelect(sql);

        try {
            fila = select.getRow();
            usuarioActual = new UsersDB(String.valueOf(fila[0]), String.valueOf(fila[1]), String.valueOf(fila[2]), Integer.parseInt(String.valueOf(fila[3])));
        } catch (NullPointerException ex) {
            usuarioActual = null;
        }

        if (usuarioActual == null) {
            System.out.println("No existe el usuario o esta mal escrito");
        } else {

            if (usuarioActual.getTipo().equals("empresa")) {//Este usuario vera las gasolineras del id de su empresa
                System.out.println("Cargado el usuario " + usuarioActual.getNombre_usuario());
            }

        }
    }

    //Metodo ActionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Codigo
        if ((ae.getActionCommand() == "buttonConnectLoggin")) {//Se pulsa el boton de iniciar sesion
            IniciarSesion();
        }

    }

    //Metodos KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getSource().equals(LoggingFrame.getLoginFrame().getPassb())) {
            IniciarSesion();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
