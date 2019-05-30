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
import javax.swing.BorderFactory;
import javax.swing.Box;
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
    private JPanel panBox, panelSuperior, panelInferior, panelBoton;
    private JLabel etiqueta1, etiqueta2, etiqueta3;
    private JTextField cajaTexto;
    private JPasswordField passb;
    private BaselinerasAPP dad;
    private JButton summit;
    private int gap=20;
    private Dimension maxDimText=new Dimension(90,20);

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
        panBox.setSize(new Dimension(400,300));
        etiqueta1 = new JLabel("Introduce tus credenciales");
        construyePanelSuperior();
        construyePanelInferior();
        construyePanelBoton();
        panBox.add(etiqueta1);
        panBox.add(panelSuperior);
        panBox.add(panelInferior);
        panBox.add(panelBoton);
        panBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.getContentPane().setLayout(new BorderLayout(gap,gap));//para poner un marco
        this.getContentPane().add(new JLabel() ,BorderLayout.NORTH);
        this.getContentPane().add(new JLabel() ,BorderLayout.LINE_START);
        this.getContentPane().add(new JLabel() ,BorderLayout.LINE_END);
        this.getContentPane().add(new JLabel() ,BorderLayout.SOUTH);
        this.getContentPane().add(panBox, BorderLayout.CENTER);
        
        
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();

    }

    public void construyePanelSuperior() {
        panelSuperior = new JPanel();
        etiqueta2 = new JLabel(" Usuario");
        etiqueta2.getSize(new Dimension(100,20));
        cajaTexto = new JTextField(10);
        cajaTexto.setMaximumSize(maxDimText);
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
        panelSuperior.add(etiqueta2);
        panelSuperior.add(Box.createHorizontalGlue());
        panelSuperior.add(cajaTexto);

    }

    public void construyePanelInferior() {
        panelInferior = new JPanel();
        etiqueta3 = new JLabel(" Contraseña");
        etiqueta3.getSize(new Dimension(100,20));
        passb = new JPasswordField(10);
        passb.setMaximumSize(maxDimText);
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.add(etiqueta3);
        panelInferior.add(Box.createHorizontalGlue());
        panelInferior.add(passb);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dad.setUser(this.cajaTexto.getText());
        this.dad.setPwd(String.valueOf(this.passb.getPassword()));
        this.dad.connectToOrcl();
        this.dad.quitLogging();
        
        this.dispose();
    }

    private void construyePanelBoton() {
        panelBoton=new JPanel();
        panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.X_AXIS));
        summit=new JButton("conectar");
        summit.addActionListener(this);
        panelBoton.add(Box.createHorizontalGlue());
        panelBoton.add(summit);
        panelBoton.add(Box.createHorizontalGlue());
    }

}
