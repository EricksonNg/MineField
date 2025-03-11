/**
 * Filename: AppPanel
 * Description: MVC Controller
 * Author: Erickson Ng
 * Last Modified Date: 3/10/25
 */

package mvc;

import tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements ActionListener {

    protected Model model;
    protected View view;
    protected JPanel controlPanel; // my control panel
    protected AppFactory factory;
    protected JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;

    public AppPanel(AppFactory factory) {
        // Need to research how to add+set the model and view without needing to initialize the Mine model and MineView view in this parent class (everything is currently done in the MinePanel child class)

//        frame = new SafeFrame();
//        Container cp = frame.getContentPane();
//        cp.add(this);
//        frame.setJMenuBar(createMenuBar());
//        frame.setTitle(AppFactory.getTitle());
//        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        display();
    }

    public void display () {
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Save As", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"NW", "N", "NE", "W", "E", "SW", "S", "SE"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    protected JPanel createPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 2, 20, 20));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton north = new JButton("N");
        north.addActionListener(this);
        p.add(north);
        JButton northWest = new JButton("NW");
        northWest.addActionListener(this);
        p.add(northWest);
        JButton northEast = new JButton("NE");
        northEast.addActionListener(this);
        p.add(northEast);
        JButton west = new JButton("W");
        west.addActionListener(this);
        p.add(west);
        JButton east = new JButton("E");
        east.addActionListener(this);
        p.add(east);
        JButton southWest = new JButton("SW");
        southWest.addActionListener(this);
        p.add(southWest);
        JButton south = new JButton("S");
        south.addActionListener(this);
        p.add(south);
        JButton southEast = new JButton("SE");
        southEast.addActionListener(this);
        p.add(southEast);
        return p;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Save": {
                    break;
                }

                case "Save As": {
                    break;
                }

                case "Open": {
                    break;
                }

                case "New": {
                    break;
                }

                case "Quit": {
                    System.exit(0);
                    break;
                }

                case "NW": {
                    break;
                }

                case "N": {
                    break;
                }

                case "NE": {
                    break;
                }

                case "W": {
                    break;
                }

                case "E": {
                    break;
                }

                case "SW": {
                    break;
                }

                case "S": {
                    break;
                }

                case "SE": {
                    break;
                }

                case "About": {
                    Utilities.inform("Team 1, 2025. All rights reserved.");
                    break;
                }

                case "Help": {
                    String[] cmmds = new String[]{
                    };
                    Utilities.inform(cmmds);
                    break;

                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

}