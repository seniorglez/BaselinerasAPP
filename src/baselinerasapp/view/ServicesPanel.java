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
import baselinerasapp.Model.Restaurant;
import baselinerasapp.Model.Workshop;
import baselinerasapp.Model.Carwash;
import java.awt.Font;

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
    private JLabel name, nif, tables, capacity;
    private Restaurant rest;
    private Workshop work;
    private Carwash carw;
    private Font font = new Font("Verdana", Font.BOLD, 16);
    private Color color=Color.WHITE;
    
    public ServicesPanel() {
        this.setLayout(new BorderLayout());
        pruebita();//soy un metodo de prueba, si no te das cuentas tu solo es que eres gilip... Y borralo, no lo depreques
        c = new GridBagConstraints();
        BuildCombo();
        BuildHeader();
        BuildDefault();
        BuildRestaurant();
        
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
        name = new JLabel("Name: " + this.rest.getName());        
        name.setFont(font);
        name.setForeground(color);
        centerPane.add(name, c);
       
        //position2
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -1;
        nif = new JLabel("NIF: " + this.rest.getNif());
        nif.setFont(font);
        nif.setForeground(color);
        centerPane.add(nif, c);

        //position3
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -2;
        tables = new JLabel("Tables: " + this.rest.getTables());        
        tables.setFont(font);
        tables.setForeground(color);
        centerPane.add(tables, c);

        //position4
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -3;
        capacity = new JLabel("Max Capacity: " + this.rest.getCapacity());        
        capacity.setFont(font);
        capacity.setForeground(color);
        centerPane.add(capacity, c);
        
    }
    
    private void BuildCarwash() {
        centerPane.setVisible(false);
        centerPane.removeAll();
        centerPane.setVisible(true);

        //position1
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        name = new JLabel("Name: " + this.carw.getName());   
        name.setFont(font);
        name.setForeground(color);
        centerPane.add(name, c);

        //position2
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -1;
        nif = new JLabel("NIF: " + this.carw.getNif());
        nif.setFont(font);
        nif.setForeground(color);
        centerPane.add(nif, c);

        //position3
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        tables = new JLabel("Tunnels: " + this.carw.getTunnels());      
        tables.setFont(font);
        tables.setForeground(color);
        centerPane.add(tables, c);

        //position4
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = -1;
        capacity = new JLabel("Hosepipes: " + this.carw.getHosepipes());  
        capacity.setFont(font);
        capacity.setForeground(color);
        centerPane.add(capacity, c);
        
    }
    
    private void BuildWorkshop() {
        centerPane.setVisible(false);
        centerPane.removeAll();
        centerPane.setVisible(true);

        //position1
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        name = new JLabel("Name: " + this.work.getName());  
        name.setFont(font);
        name.setForeground(color);
        centerPane.add(name, c);

        //position2
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = -1;
        nif = new JLabel("NIF: " + this.work.getNif());
        nif.setFont(font);
        nif.setForeground(color);
        centerPane.add(nif, c);

        //position3
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        capacity = new JLabel("Capacity: " + this.work.getCapacity()); 
        capacity.setFont(font);
        capacity.setForeground(color);
        centerPane.add(capacity, c);
        
    }
    
    private void pruebita() {
        rest = new Restaurant(WIDTH, null, "nombre", "ajda0oijd", 3, 10);
        //carw=new Carwash(1, 123132, 3,3, "NOMBRE", null);
        //work=new Workshop(1, null, 1, 1);
    }
    
    public JComboBox getCombo() {
        return combo;
    }
    
    public void setRestaurant(Restaurant servicio) {
        this.rest = servicio;
        BuildRestaurant();
    }
    
    public void setCarWash(Carwash servicio) {
        this.carw = servicio;
        BuildCarwash();
    }
    
    public void setWorkshop(Workshop servicio) {
        this.work = servicio;
        BuildWorkshop();
    }
    
}
