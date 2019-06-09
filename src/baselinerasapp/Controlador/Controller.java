/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Controlador;

import baselinerasapp.Model.Company;
import baselinerasapp.Model.Employee;
import baselinerasapp.Model.Oil;
import baselinerasapp.Model.OilStation;
import baselinerasapp.Model.Restaurant;
import baselinerasapp.Model.SQLOperations;
import baselinerasapp.Model.Tank;
import baselinerasapp.view.LoggingFrame;
import baselinerasapp.view.BaselinerasAPP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import baselinerasapp.Model.Users;
import baselinerasapp.Model.Carwash;
import baselinerasapp.Model.Workshop;
import baselinerasapp.view.BaselinerasPanef;
import baselinerasapp.view.OilSelectionFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import baselinerasapp.view.JOilLabel;
import baselinerasapp.view.OilstationFrame;
import baselinerasapp.view.StaffPanel;
import baselinerasapp.view.TankPanel;
import baselinerasapp.view.ServicesPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author edoar
 */
public class Controller implements ActionListener, KeyListener, MouseListener {

    ///Atributos///
    private static Controller controller;
    private final SQLOperations sqlo = SQLOperations.getSQLOperations();
    private final BaselinerasAPP app = BaselinerasAPP.getApp();
    private Users usuarioActual = null;
    private ArrayList<JOilLabel> oilLabels;
    //Objetos del panel de administracion
    private Company company;
    private OilStation station;
    private ArrayList <Employee> employeers = new ArrayList<>();
    private Employee staff;
    private ArrayList<Tank> tanks = new ArrayList<>();
    private ArrayList<Oil> Oils = new ArrayList<>();
    private Restaurant restauran;
    private Carwash carwash;
    private Workshop workshop;
    //Paneles OilStationFrame
    private BaselinerasPanef panelGasolinera = new BaselinerasPanef();
    private StaffPanel panelEmpleados = new StaffPanel();
    private TankPanel panelTanques = new TankPanel();
    private ServicesPanel panelServicios = new ServicesPanel();
    
    
    
    
    ///Constructores///
    private Controller() {

    }

    ///Metodos///
    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    private String generarSQLLogin() {
        //Variables//
        String sql = "SELECT NOMBRE_USUARIO, CONTRASENIA, TIPO, REFERENCIA FROM USUARIOS WHERE NOMBRE_USUARIO LIKE '";
        String contrasenia = "";
        char[] caracteresCon = LoggingFrame.getLoginFrame().getPassb().getPassword();

        //Codigo//
        //Conversion de contraseña a String
        for (int i = 0; i < caracteresCon.length; i++) {
            contrasenia += caracteresCon[i];
        }

        //Concatenacion de sql
        sql += LoggingFrame.getLoginFrame().getCajaTexto().getText();
        sql += "' AND CONTRASENIA LIKE '";
        sql += contrasenia;
        sql += "'";

        return sql;
    }

    private void IniciarSesion() {
        //Variables
        String sql;
        Object[] fila;

        //Codigo
        sql = generarSQLLogin();
        sqlo.executeSelect(sql);

        try {
            fila = sqlo.getRow();
            usuarioActual = new Users(String.valueOf(fila[0]), String.valueOf(fila[1]), String.valueOf(fila[2]), Integer.parseInt(String.valueOf(fila[3])));
        } catch (NullPointerException ex) {
            usuarioActual = null;
        }

        if (usuarioActual == null) {
            System.out.println("No existe el usuario o esta mal escrito");
        } else {
            LoggingFrame.getLoginFrame().dispose();
            if (usuarioActual.getTipo().equals("empresa")) {//Este usuario vera las gasolineras del id de su empresa
                //Cuando el usuario se conecte cargara el selector de gasolineras de manera automatica
                CargarOilSelecctionFrame();
            }

        }
    }

    //Cargar OilSelectionFrame y su lista
    private void CargarOilSelecctionFrame() {
        this.app.getDp().add(OilSelectionFrame.getOsf());
        OilSelectionFrame.getOsf().moveToFront();
        
        CargarJOilLabel();
    }

    private void CargarJOilLabel() {
        //Variables//
        oilLabels = new ArrayList<>();
        String sql;
        Object[] filas;
        boolean cargaLabels = false;
        
                
        //Codigo//
        sql = "SELECT NOMBREGASOLINERA, IDGASOLINERA FROM GASOLINERA WHERE ID_EMPRESA LIKE '" + this.usuarioActual.getReferencia() + "'";
        this.sqlo.executeSelect(sql);
        
        while(!cargaLabels){
            filas = this.sqlo.getRow();
            if (filas == null) {
                cargaLabels = true;
            }else{
                //Cargamos cada fila en el label y lo añadimos al array
                oilLabels.add(new JOilLabel(String.valueOf(filas[0]), Integer.parseInt(String.valueOf(filas[1]))));
            }
        }
        //Cargamos el array al frame
        OilSelectionFrame.getOsf().setOilLabels(oilLabels);
    }
    
    private void CargarOilStationFrame(int code) {
        CargarObjetosPanel(code);
        //Quitamos el panel de seleccion
        OilSelectionFrame.getOsf().dispose();
        //quitamos el panel predeterminado
        BaselinerasAPP.getApp().getInternal().dispose();
        
        //Cargamos el contenido de los paneles del internal frame principal
        cargarContenidoPaneles();
        
        //Cargamos el panel principal
        this.app.getDp().add(OilstationFrame.getoilstationframe());
        OilstationFrame.getoilstationframe().setVisible(true);
        OilstationFrame.getoilstationframe().moveToFront();
        
        
        JPanel centerPane = OilstationFrame.getoilstationframe().getCenterPane();
        OilstationFrame.getoilstationframe().resetCenter();
        centerPane.setVisible(false);
        centerPane.add(this.panelGasolinera, BorderLayout.CENTER);
        centerPane.setVisible(true);
        
        
        
    }
    
    private void cargarContenidoPaneles() {
        //Contenido panel Gasolinera
        //POR ESCRIBIR//
        
        //Contenido panel Empleados
        Object[][] data = new Object[this.employeers.size()][4];
        for (int i = 0; i < this.employeers.size(); i++) {
            data[i][0] = this.employeers.get(i).getId();
            data[i][1] = this.employeers.get(i).getDni();
            data[i][2] = this.employeers.get(i).getName();
            data[i][3] = this.employeers.get(i).getSurname();
        }
        this.panelEmpleados.setData(data);
        
        //Contenido panel Tanques
        data = new Object[this.tanks.size()][4];
        for (int i = 0; i < this.tanks.size(); i++) {
            data[i][0] = this.tanks.get(i).getId().getName();
            data[i][1] = this.tanks.get(i).getCapacity();
            data[i][2] = this.tanks.get(i).getCurrentCapacity();
            data[i][3] = this.tanks.get(i).getPricePerLiter();
        }
        this.panelTanques.setData(data);
        
    }
    
    private void CargarObjetosPanel(int code) {
        //Variables//
        boolean cargaterminada = false;
        int numOil;
        String sql;
        Object[] fila;
        
        //Codigo//
        //Compañia
        sql = "SELECT ID_EMPRESA, UBICACION, NOMBREEMPRESA, NIFEMPRESA FROM EMPRESA WHERE ID_EMPRESA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        fila = this.sqlo.getRow();
        this.company = new Company(code, String.valueOf(fila[1]), String.valueOf(fila[2]), String.valueOf(fila[3]));
        
        //Gasolinera
        sql = "SELECT IDGASOLINERA, ID_EMPRESA, NOMENCLATURA, IDEMPLEADO, NOMBREGASOLINERA, KILOMETRO FROM GASOLINERA WHERE IDGASOLINERA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        fila = this.sqlo.getRow();
        this.station = new OilStation(Integer.parseInt(String.valueOf(fila[0])), company, staff, String.valueOf(fila[3]), String.valueOf(fila[4]), Integer.parseInt(String.valueOf(fila[5])));
        
        //Encargado
        sql = "SELECT IDEMPLEADO, IDGASOLINERA, DNI, NOMBREEMPLEADO, APELLIDOSEMPLEADO FROM PERSONAL WHERE IDEMPLEADO LIKE (SELECT IDEMPLEADO FROM GASOLINERA WHERE IDGASOLINERA LIKE '" + code + "')";
        this.sqlo.executeSelect(sql);
        fila = this.sqlo.getRow();
        this.staff = new Employee(Integer.parseInt(String.valueOf(fila[0])), station, String.valueOf(fila[1]), String.valueOf(fila[2]), String.valueOf(fila[3]));
        
        //Empleados
        sql = "SELECT IDEMPLEADO, IDGASOLINERA, DNI, NOMBREEMPLEADO, APELLIDOSEMPLEADO FROM PERSONAL WHERE IDGASOLINERA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        
        while(!cargaterminada){
            fila = this.sqlo.getRow();
            if (fila == null) {
                cargaterminada = true;
            }else{
                //Cargamos cada fila en el objeto y lo añadimos al array
                this.employeers.add(new Employee(Integer.parseInt(String.valueOf(fila[0])), station, String.valueOf(fila[2]), String.valueOf(fila[3]), String.valueOf(fila[4])));
            }
        }
        
        //Combustibles
        sql = "SELECT IDCOMBUSTIBLE, NOMBRECOMBUSTIBLE, TIPO, LUGARDEPROCEDENCIA FROM COMBUSTIBLE";
        this.sqlo.executeSelect(sql);
        cargaterminada = false;
        
        while(!cargaterminada){
            fila = this.sqlo.getRow();
            if (fila == null) {
                cargaterminada = true;
            }else{
                //Cargamos cada fila en el objeto y lo añadimos al array
                this.Oils.add(new Oil(Integer.valueOf(String.valueOf(fila[0])), String.valueOf(fila[1]), String.valueOf(fila[2]), String.valueOf(fila[3])));
            }
        }
        
        //Tanques
        sql = "SELECT IDGASOLINERA, IDCOMBUSTIBLE, CAPACIDAD, CANTIDADACTUAL, PRECIOLITRO FROM TANQUE WHERE IDGASOLINERA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        cargaterminada = false;
        
        while(!cargaterminada){
            fila = this.sqlo.getRow();
            if (fila == null) {
                cargaterminada = true;
            }else{
                //Recuperamos el id del tipo de gasolina
                numOil = Integer.valueOf(String.valueOf(fila[0]));
                //Cargamos cada fila en el objeto y lo añadimos al array
                this.tanks.add(new Tank(station, (Oil)this.Oils.get(numOil), Integer.valueOf(String.valueOf(fila[2])), Integer.valueOf(String.valueOf(fila[3])), Double.valueOf(String.valueOf(fila[4]))));
            }
        }
        
        //Restaurante
        sql = "SELECT IDSERVICIO, IDGASOLINERA, NOMBRESERVICIO, NIFSERVICIO, MESAS, AFOROMAXIMO FROM RESTAURANTE WHERE IDGASOLINERA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        fila = this.sqlo.getRow();
        if (fila != null) {
            this.restauran = new Restaurant(Integer.valueOf(String.valueOf(fila[0])), station, String.valueOf(fila[2]), String.valueOf(fila[3]), Integer.valueOf(String.valueOf(fila[4])), Integer.valueOf(String.valueOf(fila[5])));
        }
        
        
        //Lavado de coches
        sql = "SELECT IDSERVICIO, IDGASOLINERA, NOMBRESERVICIO, NIFSERVICIO, CANTIDADTUNELES, CANTIDADMANGUERAS FROM AUTOLAVADO WHERE IDGASOLINERA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        fila = this.sqlo.getRow();
        if (fila != null) {
            this.carwash = new Carwash(Integer.valueOf(String.valueOf(fila[0])), station, String.valueOf(fila[2]), String.valueOf(fila[3]), Integer.valueOf(String.valueOf(fila[4])), Integer.valueOf(String.valueOf(fila[5])));
        }
        
        
        
        //Taller
        sql = "SELECT IDSERVICIO, IDGASOLINERA, NOMBRESERVICIO, NIFSERVICIO, CAPACIDADVEHICULOS FROM TALLER WHERE IDGASOLINERA LIKE '" + code + "'";
        this.sqlo.executeSelect(sql);
        fila = this.sqlo.getRow();
        if (fila != null) {
            this.workshop = new Workshop(Integer.valueOf(String.valueOf(fila[0])), station, String.valueOf(fila[2]), String.valueOf(fila[3]), Integer.valueOf(String.valueOf(fila[4])));
        }
        
        
    }   
    
    //Metodos Eventos
    
    //Metodo ActionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Codigo
        if ((ae.getActionCommand() == "buttonConnectLoggin")) {//Se pulsa el boton de iniciar sesion
            IniciarSesion();
        }

    }

    //Metodos KeyListener
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getSource().equals(LoggingFrame.getLoginFrame().getPassb())) {
            IniciarSesion();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    //Metodos MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < this.oilLabels.size(); i++) {
            if (e.getSource().equals(oilLabels.get(i))) {
            //System.out.println("La gasolinera de ventanas debe abrir con " + this.oilLabels.get(i).getCode());//el code es el id de la gasolinera
            CargarOilStationFrame(this.oilLabels.get(i).getCode());
        }
        }
        
        //Evento de mouse del OilStationFrame
        JLabel l = (JLabel) e.getComponent();
        JPanel centerPane = OilstationFrame.getoilstationframe().getCenterPane();
        switch (l.getText()) {
            case "OilStation":
                OilstationFrame.getoilstationframe().resetCenter();
                centerPane.setVisible(false);
                centerPane.add(this.panelGasolinera, BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Staff":
                OilstationFrame.getoilstationframe().resetCenter();
                centerPane.setVisible(false);
                centerPane.add(this.panelEmpleados, BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Tanks":
                OilstationFrame.getoilstationframe().resetCenter();
                centerPane.setVisible(false);
                centerPane.add(this.panelTanques, BorderLayout.CENTER);
                centerPane.setVisible(true);

                break;
           case "Services":
                OilstationFrame.getoilstationframe().resetCenter();
                centerPane.setVisible(false);
                centerPane.add(this.panelServicios, BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Location":
               break;
            default:
                System.err.println("somethink go wrong");

        }
        
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
