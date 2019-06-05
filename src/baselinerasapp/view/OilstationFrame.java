/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class OilstationFrame extends JInternalFrame implements MouseListener {

    private JPanel northPane, westPane, centerPane;
    private JLabel oilStationlabel, employeesLabel, tankLabel, workShopLabel, carwashLabel, googleMapLabel, logo;
    private Dimension dim = new Dimension(10, 10);
    private int gap = 20;

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
        oilStationlabel.addMouseListener(this);
        employeesLabel.setForeground(Color.white);
        employeesLabel.addMouseListener(this);
        tankLabel.setForeground(Color.white);
        tankLabel.addMouseListener(this);
        workShopLabel.setForeground(Color.white);
        workShopLabel.addMouseListener(this);
        carwashLabel.setForeground(Color.white);
        carwashLabel.addMouseListener(this);
        googleMapLabel.setForeground(Color.white);
        googleMapLabel.addMouseListener(this);

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
        centerPane.setLayout(new BorderLayout(gap, gap));//para poner un marco
        centerPane.add(new JLabel(), BorderLayout.NORTH);
        centerPane.add(new JLabel(), BorderLayout.LINE_START);
        centerPane.add(new JLabel(), BorderLayout.LINE_END);
        centerPane.add(new JLabel(), BorderLayout.SOUTH);

        this.getContentPane().add(centerPane, BorderLayout.CENTER);//añado el center al centro del panel
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.print("click");
        JLabel l = (JLabel) e.getComponent();
        switch (l.getText()) {
            case "OilStation":
                resetCenter();
                centerPane.setVisible(false);
                centerPane.add(new BaselinerasPanef(), BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Staff":
                resetCenter();
                centerPane.setVisible(false);
                centerPane.add(new StaffPanef1(), BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Tanks":
                resetCenter();
                centerPane.setVisible(false);
                centerPane.add(new TankPanef1(), BorderLayout.CENTER);
                centerPane.setVisible(true);

                break;
            case "Workshop":
                resetCenter();
                centerPane.setVisible(false);
                centerPane.add(new WorkshopPanef1(), BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Carwash":
                resetCenter();
                centerPane.setVisible(false);
                centerPane.add(new CarwashPanef1(), BorderLayout.CENTER);
                centerPane.setVisible(true);
                break;
            case "Location":
                break;
            default:
                System.err.print("somethink go wrong");

        }
    }

    private void resetCenter() {
        centerPane.removeAll();
        centerPane.repaint();
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
