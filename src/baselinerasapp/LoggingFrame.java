/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class LoggingFrame extends JFrame implements ActionListener{

    //variable
    private JPanel panBox, panelSuperior, panelInferior;
    private JLabel etiqueta1, etiqueta2, etiqueta3;
    private JTextField cajaTexto;
    private JPasswordField passb;
    private BaselinerasAPP dad;
    private JButton summit;

    public LoggingFrame(BaselinerasAPP p) {
        dad=p;//guardamos la referencia a la ventana padre
        initComponents();
    }

    private void initComponents() {
        this.setSize(new Dimension(800, 600));
        this.setTitle("Logging");
        this.setVisible(true);

        panBox = new JPanel();
        panBox.setLayout(new BoxLayout(panBox, BoxLayout.Y_AXIS));
        etiqueta1 = new JLabel("LOGGING");
        construyePanelSuperior();
        construyePanelInferior();
        panBox.add(etiqueta1);
        panBox.add(panelSuperior);
        
        panBox.add(panelInferior);
        summit=new JButton("GO");
        summit.addActionListener(this);
        panBox.add(summit);
        this.getContentPane().add(panBox);
        this.setSize(new Dimension(300, 125));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void construyePanelSuperior() {
        panelSuperior = new JPanel();
        etiqueta2 = new JLabel("Usuario");
        etiqueta2.getSize(new Dimension(100,20));
        cajaTexto = new JTextField(10);
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
        panelSuperior.add(etiqueta2);
        panelSuperior.add(cajaTexto);
    }

    public void construyePanelInferior() {
        panelInferior = new JPanel();
        etiqueta3 = new JLabel("contraseña");
        etiqueta3.getSize(new Dimension(100,20));
        passb = new JPasswordField(10);
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.add(etiqueta3);
        panelInferior.add(passb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
