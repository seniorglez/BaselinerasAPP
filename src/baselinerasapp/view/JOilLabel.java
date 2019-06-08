/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import javax.swing.JLabel;
import baselinerasapp.Controlador.Controller;

/**
 *
 * @author ddomi
 */
public class JOilLabel extends JLabel{
    ///Atributos///
    private int code;
    
    ///Constructores///
    public JOilLabel(String s, int code){
        super(s);
        this.code=code;
       this.addMouseListener(Controller.getController());
    }

    ///Metodos///
    public int getCode() {
        return code;
    }
    
}
