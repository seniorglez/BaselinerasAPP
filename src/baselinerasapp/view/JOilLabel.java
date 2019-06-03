/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author ddomi
 */
public class JOilLabel extends JLabel{
    private int code;
    public JOilLabel(String s, int code){
        super(s);
        this.code=code;
       this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                System.out.println("La gasolinera de ventanas debe abrir con " + code);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
           
       });
    }

    public int getCode() {
        return code;
    }


    
    
}
