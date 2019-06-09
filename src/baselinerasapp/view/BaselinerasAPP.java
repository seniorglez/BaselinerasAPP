/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
    private static BaselinerasAPP app;
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
        app = new BaselinerasAPP();
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
        menuItem = new JMenuItem("Login");
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        
        //añadimos la barra
        this.setJMenuBar(menuBar);
    }

    public void makeWelcome() {
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(log==null){
           log=new LoggingFrame(this); //es necesario poder volver a poner log a null cuando cierras el principal
           log.setLocationRelativeTo(null);
           
        }
        
    }

    public static BaselinerasAPP getApp() {
        return app;
    }

    public JDesktopPane getDp() {
        return dp;
    }

    public JInternalFrame getInternal() {
        return internal;
    }

    public JMenu getMenu() {
        return menu;
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(JMenuItem menuItem) {
        this.menuItem = menuItem;
        menu.add(menuItem);
    }

    public LoggingFrame getLog() {
        return log;
    }

    public void setLog(LoggingFrame log) {
        this.log = log;
    }  
    
}
