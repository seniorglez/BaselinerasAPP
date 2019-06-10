/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import baselinerasapp.Model.OilStation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ddomi
 */
public class BaselinerasPane extends JPanel {

    private JButton button1, button2, button3;
    private JLabel html = new JLabel();
    private OilStation o;

    public BaselinerasPane(JLabel html) {
        this.html = html;
        initComponents();
    }

    private void initComponents() {
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //html = new JLabel();
        //buildHtml();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;//ancho
        constraints.gridheight = 2;

        constraints.fill = GridBagConstraints.BOTH;//se estia en  otdos los sentidos
        constraints.weighty = 1.0;
        this.add(html, constraints);

        //reset
        constraints.weighty = 0.0;
        constraints.anchor = GridBagConstraints.CENTER;

//        button1 = new JButton("Boton 1");
//        constraints.gridx = 0;
//        constraints.gridy = 2;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
//        this.add(button1, constraints);
//
//        button3 = new JButton("Boton 3");
//        constraints.gridx = 2;
//        constraints.gridy = 2;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
//        this.add(button3, constraints);
//
//        button2 = new JButton("Boton 2");
//        constraints.gridx = 1;
//        constraints.gridy = 2;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
//        constraints.weightx = 1.0;
//        constraints.fill = GridBagConstraints.HORIZONTAL;// debe estirarse sólo en horizontal
//        this.add(button2, constraints);
    }


    public void setText (JLabel html){
        this.html = html;
        this.setVisible(false);
        this.removeAll();
        initComponents();
        this.repaint();
        this.setVisible(true);
        
    }
}
