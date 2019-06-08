package baselinerasapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import baselinerasapp.Model.RestaurantDB;
import baselinerasapp.Model.WorkshopDB;
import baselinerasapp.Model.CarwashDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ddomi
 */
public class ServicesPanel extends JPanel {
//si quisieramos exigir restricciones deberiamos usar un TableModel, molaria mas otro frame y cambiar editable a null
    //ejemplo de tabla para ver como queda https://docs.oracle.com/javase/tutorial/uiswing/components/table.html  la llenas como veas señor controlador

    private JPanel headerPanel, centerPane;
    private JLabel labelHeader;
    private String[] comboStrings;
    private JComboBox combo;
    private GridBagConstraints c;
    private JLabel name,nif,tables,capacity;
    private RestaurantDB rest;
    private WorkshopDB work;
    private CarwashDB carw;

    public ServicesPanel() {
        this.setLayout(new BorderLayout());
        pruebita();//soy un metodo de prueba, si no te das cuentas tu solo es que eres gilip... Y borralo, no lo depreques
        c = new GridBagConstraints();
        BuildCombo();
        BuildHeader();
        BuildDefault();
        BuildRestaurant();
        BuildCarwash();
        BuildWorkshop();
    }

    private void BuildHeader() {
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.add(Box.createHorizontalGlue());//no se coloca porque no le sale del papo, lo respeto. Igual tiene que ver con que lo coloque en line start y no en north.Preguntare a Macarena
        labelHeader = new JLabel("Services");
        headerPanel.add(labelHeader);
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(combo);
        this.add(headerPanel, BorderLayout.PAGE_START);
        
    }

    private void BuildDefault() {
        centerPane = new JPanel(new GridBagLayout());
        centerPane.setBackground(new Color(68, 28, 68));
        this.add(centerPane, BorderLayout.CENTER);

    }

    private void BuildCombo() {
        int i = 1;//esto debe depender de si hay servicios o no(controlador)

        comboStrings = new String[i];
        comboStrings[0] = "";
        combo = new JComboBox(comboStrings);

        combo.setSelectedIndex(0);
        combo.addActionListener(null);//tiene que llamar a los metodos de escritura cuando cambie 
        

    }

    private void BuildRestaurant() {
        centerPane.setVisible(false);
        centerPane.removeAll();
        centerPane.setVisible(true);
        
        //position1
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
       name= new JLabel("Name: " + this.rest.getName()); 
       centerPane.add(name,c);
       
      //position2
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -1;
       nif= new JLabel("NIF: " + this.rest.getNif());
       centerPane.add(nif,c);
       
       //position3
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
       tables= new JLabel("Tables: " + this.rest.getTables()); 
       centerPane.add(tables,c);
       
       
       //position4
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = -1;
        capacity= new JLabel("Max Capacity: " + this.rest.getCapacity()); 
        centerPane.add(capacity,c);
       
        
       
      
       
               

    }

    private void BuildCarwash() {
centerPane.setVisible(false);
        centerPane.removeAll();
        centerPane.setVisible(true);
        
        //position1
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
       name= new JLabel("Name: " + this.carw.getName()); 
       centerPane.add(name,c);
       
      //position2
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -1;
       nif= new JLabel("NIF: " + this.carw.getNif());
       centerPane.add(nif,c);
       
       //position3
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
       tables= new JLabel("Tunnels: " + this.carw.getTunnels()); 
       centerPane.add(tables,c);
       
       
       //position4
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = -1;
        capacity= new JLabel("Hosepipes: " + this.carw.getHosepipes()); 
        centerPane.add(capacity,c);
       
    }

    private void BuildWorkshop() {
centerPane.setVisible(false);
        centerPane.removeAll();
        centerPane.setVisible(true);
        
        //position1
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
       name= new JLabel("Name: " + this.work.getName()); 
       centerPane.add(name,c);
       
      //position2
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -1;
       nif= new JLabel("NIF: " + this.work.getNif());
       centerPane.add(nif,c);
       
       //position3
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
       capacity= new JLabel("Capacity: " + this.work.getCapacity()); 
       centerPane.add(capacity,c);
       
       
       
    }

    private void pruebita() {
        rest=new RestaurantDB(WIDTH, null, "nombre", "ajda0oijd", 3, 10);
        carw=new CarwashDB(1, 123132, 3,3, "NOMBRE", null);
        work=new WorkshopDB(1, null, 1, 1);
    }
}
