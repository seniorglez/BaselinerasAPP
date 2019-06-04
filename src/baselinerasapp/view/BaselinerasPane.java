/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ddomi
 */
public class BaselinerasPane extends JPanel {

    private JTable table;
    private JPanel tablePane;

    public BaselinerasPane() {
        initComponents();
    }

    private void initComponents() {
        buildTablePanel();

    }

    private void buildTablePanel() {
        DefaultTableModel modelo = new DefaultTableModel();
        table = new JTable(modelo);

        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("lo que sea");

        // Bucle para cada resultado en la consulta
        while (rs.next()) {//rs = objeto resul set
            
            Object[] row = new Object[3]; // Hay tres columnas en la tabla

            //rellenamos
            for (int i = 0; i < 3; i++) {
                row[i] = rs.getObject(i + 1); // En el result set el primer indice es 1
            }
            modelo.addRow(row);//añadimos la fila
        }
        tablePane = new JPanel();
        tablePane.add(table);
    }

}
