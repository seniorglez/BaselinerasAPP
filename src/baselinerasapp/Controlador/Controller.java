/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Controlador;

import baselinerasapp.Model.Select;
import baselinerasapp.view.LoggingFrame;
import baselinerasapp.view.BaselinerasAPP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import baselinerasapp.Model.UsersDB;
import baselinerasapp.view.JOilLabel;
import baselinerasapp.view.OilSelectionFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author edoar
 */
public class Controller implements ActionListener, KeyListener {

    ///Atributos///
    private static Controller controller;
    private final Select select = Select.getSelect();
    private final BaselinerasAPP app = BaselinerasAPP.getApp();
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
            LoggingFrame.getLoginFrame().dispose();
            if (usuarioActual.getTipo().equals("empresa")) {//Este usuario vera las gasolineras del id de su empresa
                //Cuando el usuario se conecte cargara el selector de gasolineras de manera automatica
                CargarOilSelecctionFrame();
            }

        }
    }

    //Cargar OilSelectionFrame y su lista
    private void CargarOilSelecctionFrame() {
        this.app.getDp().add(OilSelectionFrame.getOsf());
        OilSelectionFrame.getOsf().moveToFront();
        
        CargarJOilLabel();
    }

    private void CargarJOilLabel() {
        //Variables//
        ArrayList<JOilLabel> oilLabels = new ArrayList<>();
        String sql;
        Object[] filas;
        boolean cargaLabels = false;
        
                
        //Codigo//
        sql = "SELECT NOMBREGASOLINERA, IDGASOLINERA FROM GASOLINERA WHERE ID_EMPRESA LIKE '" + this.usuarioActual.getReferencia() + "'";
        this.select.executeSelect(sql);
        
        while(!cargaLabels){
            filas = this.select.getRow();
            if (filas == null) {
                cargaLabels = true;
            }else{
                //Cargamos cada fila en el label y lo añadimos al array
                oilLabels.add(new JOilLabel(String.valueOf(filas[0]), Integer.parseInt(String.valueOf(filas[1]))));
            }
        }
        //Cargamos el array al frame
        OilSelectionFrame.getOsf().setOilLabels(oilLabels);
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
