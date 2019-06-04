/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class OilstationFrame extends JInternalFrame {

    private JPanel northPane, westPane, centerPane;
    private JLabel oilStationlabel, employeesLabel, tankLabel, workShopLabel, carwashLabel, googleMapLabel, logo;
    private Dimension dim = new Dimension(10, 10);

    public OilstationFrame() {
        initComponents();
        this.setVisible(true);
        this.moveToFront();
    }

    private void initComponents() {
        this.getContentPane().setLayout(new BorderLayout());
        buildNorthPane();
        buildWestPane();
        buildCenterPane();
    }

    private void buildNorthPane() {
        northPane = new JPanel();
        northPane.setLayout(new BoxLayout(northPane, BoxLayout.X_AXIS));
        northPane.setBackground(new Color(155, 50, 117));//Ojo al manojo, color de la imagen
        logo = new JLabel();
        ImageIcon ii = new ImageIcon("src/resources/logos.jpg");
        logo.setIcon(ii);
        northPane.add(logo);
        this.getContentPane().add(northPane, BorderLayout.NORTH);

    }

    private void buildWestPane() {
        westPane = new JPanel();
        westPane.setLayout(new BoxLayout(westPane, BoxLayout.Y_AXIS));
        westPane.setBackground(new Color(133, 72, 173));

        //menu
        oilStationlabel = new JLabel("OilStation");

        employeesLabel = new JLabel("Staff");
        tankLabel = new JLabel("Tanks");
        workShopLabel = new JLabel("Workshop");
        carwashLabel = new JLabel("Carwash");
        googleMapLabel = new JLabel("Location");

        oilStationlabel.setForeground(Color.white);
        employeesLabel.setForeground(Color.white);
        tankLabel.setForeground(Color.white);
        workShopLabel.setForeground(Color.white);
        carwashLabel.setForeground(Color.white);
        googleMapLabel.setForeground(Color.white);

        westPane.add(Box.createRigidArea(dim));
        westPane.add(Box.createVerticalGlue());
        westPane.add(oilStationlabel);
        westPane.add(Box.createVerticalGlue());
        westPane.add(employeesLabel);
        westPane.add(Box.createVerticalGlue());
        westPane.add(tankLabel);
        westPane.add(Box.createVerticalGlue());
        westPane.add(workShopLabel);
        westPane.add(Box.createVerticalGlue());
        westPane.add(carwashLabel);
        westPane.add(Box.createVerticalGlue());
        westPane.add(googleMapLabel);
        westPane.add(Box.createVerticalGlue());

        this.getContentPane().add(westPane, BorderLayout.WEST);
    }

    private void buildCenterPane() {
        centerPane = new JPanel();
        centerPane.setBackground(new Color(68, 28, 68));
        this.getContentPane().add(centerPane, BorderLayout.CENTER);
    }
}
