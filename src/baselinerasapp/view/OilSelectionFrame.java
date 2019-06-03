/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import baselinerasapp.Model.OilStationBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ddomi
 */
public class OilSelectionFrame extends JFrame {
    //variable

    private JPanel panBox, panlabel;
    private JScrollPane jsp;
    private JTextField cajaTexto;
    private BaselinerasAPP dad;
    private JButton summit;
    private int gap = 20;
    private Dimension maxDimText = new Dimension(500, 20);
    private Dimension maxDimSroll = new Dimension(500, 800);
    private  ArrayList<JOilLabel> oilLabels = new ArrayList<JOilLabel>();
    

    public OilSelectionFrame() {
        initComponents();
    }

    private void initComponents() {
        this.setSize(new Dimension(700, 600));
        this.setTitle("Seleción de Gasolinera");
        this.setVisible(true);
        
        chargeOilStations();
        
        
        panBox = new JPanel();
        panBox.setLayout(new BoxLayout(panBox, BoxLayout.PAGE_AXIS));
        panBox.setSize(new Dimension(800, 600));
        panBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panBox.add(Box.createRigidArea(new Dimension(0, 75)));
        cajaTexto = new JTextField();

        cajaTexto.setMaximumSize(maxDimText);
        panBox.add(cajaTexto);
        panBox.add(Box.createRigidArea(new Dimension(0, 25)));
        initSeachPane();
        initJScroll();
        panBox.add(Box.createRigidArea(new Dimension(0, 25)));
        //para poner un marco
        this.getContentPane().setLayout(new BorderLayout(gap, gap));
        this.getContentPane().add(new JLabel(), BorderLayout.NORTH);
        this.getContentPane().add(new JLabel(), BorderLayout.LINE_START);
        this.getContentPane().add(new JLabel(), BorderLayout.LINE_END);
        this.getContentPane().add(new JLabel(), BorderLayout.SOUTH);
        this.getContentPane().add(panBox, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

    }

    private void initJScroll() {

        jsp = new JScrollPane(panlabel);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setMaximumSize(maxDimSroll);

        panBox.add(jsp);

    }

    private void initSeachPane() {
        panlabel = new JPanel();

        panlabel.setLayout(new BoxLayout(panlabel, BoxLayout.Y_AXIS));
           for(int x=0;x<this.oilLabels.size();x++) {
      panlabel.add(oilLabels.get(x));
    }
       
        
     
        
    }

    private void chargeOilStations() {
        
        //cargas los nombres de las gasolineras y los id, lo relleno para que veas como funciona
        
        for (int i = 0; i < 100; i++) {
            
            this.oilLabels.add(new JOilLabel("nombre" + i, i));
        }
        
    }

}
