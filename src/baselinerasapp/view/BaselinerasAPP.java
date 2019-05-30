/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import baselinerasapp.view.LoggingFrame;
import com.sun.jdi.connect.spi.Connection;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author diego
 */
public class BaselinerasAPP extends JFrame implements ActionListener{

    //private JDesktopPane desktopPane;
    /**
     * @param args the command line arguments
     */
    //VARIABLES
    private JPanel p;
    private JInternalFrame internal;
    private JDesktopPane dp;
    private JLabel fondo;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private LoggingFrame log=null;
   //conexion
    private String user;
    private String pwd;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public void quitLogging(){
        this.log=null;
    }
    public static void main(String[] args) {
        new BaselinerasAPP();
    }

    /**
     * Crea un DesktopPane lo añade al panel interno y a su vez muestra un
     * mensaje en forma de bienvenida gracias a un JInternalFrame
     */
    public BaselinerasAPP() {
        makeDesktopPane();
        makeFrame();
        makeMenus();
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

    private void makeMenus() {
//Creamos la barra
        menuBar = new JMenuBar();

//Añadimos el menu
        menu = new JMenu("Conections");
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

//añadimos los items
        menuItem = new JMenuItem("Direct Conection");
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        
        //añadimos la barra
        this.setJMenuBar(menuBar);
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
        internal.moveToFront();
    }

    private void escaleBackground() {
        fondo.setSize(new Dimension(this.getWidth(), this.getHeight()));
        ImageIcon icono = new ImageIcon("src/resources/oil.jpg");
        Image imagenEscalada = icono.getImage().getScaledInstance(this.fondo.getWidth(), this.fondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        fondo.setIcon(iconoEscalado);
    }
    
    

    private void autoEscale() {
        this.addComponentListener(new ComponentListener() {
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
    
    public void connectToOrcl(){
        try(java.sql.Connection c=DriverManager.getConnection("jdbc:oracle:thin:@sveddie.hundirlaweb.es:1521:xe", "GESTOR_GASOLINERAS", "Passw0rd");){
            Statement st = c.createStatement();
            
            ResultSet rs=st.executeQuery("SELECT IDGASOLINERA FROM GASOLINERA");
            
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            rs.close();
            st.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaselinerasAPP.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(log==null){
           log=new LoggingFrame(this); //es necesario poder volver a poner log a null cuando cierras el principal
           
        }
        
    }

}
