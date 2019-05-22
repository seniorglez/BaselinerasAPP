/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author diego
 */
public class BaselinerasAPP extends JFrame {

    //private JDesktopPane desktopPane;
    /**
     * @param args the command line arguments
     */
    //VARIABLES
    private JPanel p;
    private JInternalFrame internal;
    private JDesktopPane dp;
    private JLabel fondo;

    public static void main(String[] args) {
        new BaselinerasAPP();
    }

    /**
     * Crea un DesktopPane lo añade al panel interno y a su vez muestra un mensaje en 
     * forma de bienvenida gracias a un JInternalFrame
     */
    public BaselinerasAPP() {
        makeDesktopPane();
        makeFrame();
        escaleBackground();
        autoEscale();
        makeWelcome();
        
        
        

    }

    private void makeDesktopPane() {
        // hacemos el panel
        dp = new JDesktopPane();
        dp.setLayout(new BorderLayout());//esto afecta tambien a la internal, lol
        this.getContentPane().add(dp);
        //PreparoElFondo
        fondo = new JLabel();
       
        
        
        dp.add(fondo);
        
    }

    private void makeFrame() {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }

    private void makeWelcome() {
        // Se construye el panel que ira dentro del JInternalFrame
        p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("Bienvenido a la herramienta\n de gestión\n de gasolineras"));

        // Se construye el JInternalFrame
        internal = new JInternalFrame("Hola");
        internal.add(p);
        //el pack nos permite darle un tamaplo optimo
        internal.pack();
        // Closable no sañade un boton de cerrar
        internal.setResizable(true);
        internal.setClosable(true);
        //visualizamos
        internal.setVisible(true);
        
        //añado el saludo
        dp.add(internal);
    }

    private void escaleBackground() {
        fondo.setSize(new Dimension(this.getWidth(), this.getHeight()));
        ImageIcon icono = new ImageIcon("src/resources/oil.jpg");
        Image imagenEscalada = icono.getImage().getScaledInstance(this.fondo.getWidth(), this.fondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        fondo.setIcon(iconoEscalado);
    }

    private void autoEscale() {
        this.addComponentListener(new ComponentListener(){
            @Override
            public void componentResized(ComponentEvent e) {
                escaleBackground();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                
            }

            @Override
            public void componentShown(ComponentEvent e) {
          
            }

            @Override
            public void componentHidden(ComponentEvent e) {
           
            }
            
        });
    }

}
