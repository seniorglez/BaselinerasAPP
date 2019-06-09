/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author ddomi
 */
public class OilSelectionFrame extends JInternalFrame {
    ///Atributos///
    private static OilSelectionFrame osf;
    private JPanel panBox, panlabel;
    private JScrollPane jsp;
    private JTextField cajaTexto;
    private BaselinerasAPP dad;
    private int gap = 20;
    private Dimension maxDimText = new Dimension(500, 20);
    private Dimension maxDimSroll = new Dimension(500, 800);
    private ArrayList<JOilLabel> oilLabels = new ArrayList<JOilLabel>();

    ///Constructores///
    private OilSelectionFrame() {
        initComponents();
    }

    ///Metodos///
    public static OilSelectionFrame getOsf() {
        if (osf == null) {
            osf = new OilSelectionFrame();
        }
        return osf;
    }
    
    private void initComponents() {
        this.setSize(new Dimension(700, 600));
        this.setTitle("Seleción de Gasolinera");
        this.setVisible(true);

        panlabel = new JPanel();
        panBox = new JPanel();
        panBox.setLayout(new BoxLayout(panBox, BoxLayout.PAGE_AXIS));
        panBox.setSize(new Dimension(800, 600));
        panBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panBox.add(Box.createRigidArea(new Dimension(0, 75)));
        cajaTexto = new JTextField();
        cajaTexto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                System.out.print("Rescribiendo");
                printLabels();
            }

        });
        cajaTexto.setMaximumSize(maxDimText);
        panBox.add(cajaTexto);
        panBox.add(Box.createRigidArea(new Dimension(0, 25)));
        printLabels();
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

    private void printLabels() {
        panlabel.setVisible(false);
        panlabel.removeAll();
        panlabel.repaint();
        panlabel.setVisible(true);
        panlabel.setLayout(new BoxLayout(panlabel, BoxLayout.Y_AXIS));//esta linea hay que comprobarla, no se si el remove all se cepilla el layout 
        String text = this.cajaTexto.getText();
     
        if (text.equals("")) {
            for (int x = 0; x < this.oilLabels.size(); x++) {
                panlabel.add(oilLabels.get(x));
            }

        } else {
            System.out.print("ejecutando else");
            for (int x = 0; x < this.oilLabels.size(); x++) {

                if (oilLabels.get(x).getText().substring(0, text.length()).equalsIgnoreCase(text)) {//prueba

                    panlabel.add(oilLabels.get(x));
                   
                }
            }
        }

    }

    @Deprecated
    private void chargeOilStations() {

        //cargas los nombres de las gasolineras y los id, lo relleno para que veas como funciona
        for (int i = 0; i < 100; i++) {

            this.oilLabels.add(new JOilLabel("nombre" + i, i));
        }
        
    }

    public ArrayList<JOilLabel> getOilLabels() {
        return oilLabels;
    }

    public void setOilLabels(ArrayList<JOilLabel> oilLabels) {
        this.oilLabels = oilLabels;
        
        //Establecemos los labels a la lista tras cargarlos
        for (int x = 0; x < this.oilLabels.size(); x++) {
                panlabel.add(oilLabels.get(x));
            }
    }

}
