package baselinerasapp.view;

import baselinerasapp.Model.SQLOperations;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
public class StaffPanel extends JPanel {
//si quisieramos exigir restricciones deberiamos usar un TableModel, molaria mas otro frame y cambiar editable a null
    //ejemplo de tabla para ver como queda https://docs.oracle.com/javase/tutorial/uiswing/components/table.html  la llenas como veas señor controlador

    private String[] columnNames = {"ID_Empleado", "DNI", "Nombre Empleado", "Apellidos Empleado"};
    private Object[][] data;
    private JTable staffTable;
    private JScrollPane scrollPane;
    private JPanel headerPanel, footerPanel;
    private JLabel labelHeader;
    private JButton add, delete;

    public StaffPanel() {
        //initComponents();

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

    private void buildTable() {//https://stackoverflow.com/questions/17652624/i-get-ljava-lang-object-instead-of-data-on-my-jtable
        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {//asi consigo que las cell no sean Editables por defecto https://stackoverflow.com/questions/1990817/how-to-make-a-jtable-non-editable
                return false;
            }
        };

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
        this.setVisible(false);
        this.updateUI();
        this.setVisible(true);

    }

    private void BuildHeader() {
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.add(Box.createHorizontalGlue());//no se coloca porque no le sale del papo, lo respeto. Igual tiene que ver con que lo coloque en line start y no en north.Preguntare a Macarena
        labelHeader = new JLabel("STAFF");
        headerPanel.add(labelHeader);
        headerPanel.add(Box.createHorizontalGlue());
        this.add(headerPanel, BorderLayout.PAGE_START);
    }


    private void BuildFoot() {
        footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.X_AXIS));
        add = new JButton("add");
        delete = new JButton("delete");
        //Aligment
        add.setAlignmentX(Component.CENTER_ALIGNMENT);//no le da la gana, lo respeto
        delete.setAlignmentX(Component.CENTER_ALIGNMENT);
        //listeners
        footerPanel.add(add);
        footerPanel.add(delete);

        this.add(footerPanel, BorderLayout.SOUTH);
    }

    //listener al controlador
    public void deleteSelected() {
        int[] toDelete = this.staffTable.getSelectedRows();//devuelve los indices
        SQLOperations sqlo = SQLOperations.getSQLOperations();
        for (int i = 0; i < toDelete.length; i++) {
            sqlo.executeSelect("DELETE FROM PERSONAL WHERE PERSONAL.idempleado = " + data[toDelete[i]][1]);//el 1 es la posicion del array donde va el id
        }

    }


    public void setData(Object[][] data) {
        this.data = data;
        initComponents();
    }
    
    
}
