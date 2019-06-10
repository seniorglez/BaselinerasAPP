package baselinerasapp.view;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ddomi
 */
public class TankPanel extends JPanel {
//si quisieramos exigir restricciones deberiamos usar un TableModel, molaria mas otro frame y cambiar editable a null
    //ejemplo de tabla para ver como queda https://docs.oracle.com/javase/tutorial/uiswing/components/table.html  la llenas como veas señor controlador

    private String[] columnNames = {"Nombre Combustible", "Capacidad", "Cantidad Actual", "Precio por litro"};
    private Object[][] data = {
        {"Kathy", "Smith",
            "Snowboarding", new Integer(5), new Boolean(false)},
        {"John", "Doe",
            "Rowing", new Integer(3), new Boolean(true)},
        {"Sue", "Black",
            "Knitting", new Integer(2), new Boolean(false)},
        {"Jane", "White",
            "Speed reading", new Integer(20), new Boolean(true)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)},
        {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)}
    };
    private JTable staffTable;
    private JScrollPane scrollPane;
    private JPanel headerPanel;
    private JLabel labelHeader;

    public TankPanel() {
        this.setLayout(new BorderLayout());
        buildTable();
        BuildHeader();
    }
    
    private void initComponents(){
        this.setVisible(false);
        this.removeAll();
        this.setLayout(new BorderLayout());
        buildTable();
        BuildHeader();
        //No esta imprementado
        //BuildFoot();
        
        this.repaint();
        this.setVisible(true);
    }

    private void buildTable() {//se podria meter en un scrollpane
        DefaultTableModel modelo = new DefaultTableModel();

        for (int i = 0; i < columnNames.length; i++) {//añadimos las columnas

            modelo.addColumn(columnNames[i]);

        }

        for (int i = 0; i < data.length; i++) {
            modelo.addRow(data[i]);

        }

        staffTable = new JTable(modelo);
        
        this.add(staffTable.getTableHeader(), BorderLayout.NORTH);//esto no se si puede dar probelmas con el scroll

        staffTable.setFillsViewportHeight(true);//this ensures the table is never smaller than the viewport
        scrollPane = new JScrollPane(staffTable);
        this.add(scrollPane, BorderLayout.CENTER);

    }

    private void BuildHeader() {
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.add(Box.createHorizontalGlue());//no se coloca porque no le sale del papo, lo respeto. Igual tiene que ver con que lo coloque en line start y no en north.Preguntare a Macarena
        labelHeader = new JLabel("OIL");
        headerPanel.add(labelHeader);
        headerPanel.add(Box.createHorizontalGlue());
        this.add(headerPanel, BorderLayout.PAGE_START);
    }
    
    public void setData(Object[][] data) {
        this.data = data;
        initComponents();
    }
    
}
