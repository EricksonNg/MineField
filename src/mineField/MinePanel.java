/**
 * Filename: MinePanel.java
 * Description: Panel for the Minefield Application
 * Author: Erickson Ng
 * Last Modified: 3/10/25
 */

package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MinePanel extends AppPanel {

    public MinePanel(AppFactory factory) {
        super(factory);
        createButtons(this);
    }

    protected void createButtons(ActionListener listener) {
        System.out.println(1);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 3));

        JButton north = new JButton("N");
        JButton northWest = new JButton("NW");
        JButton northEast = new JButton("NE");
        JButton west = new JButton("W");
        JButton east = new JButton("E");
        JButton southWest = new JButton("SW");
        JButton south = new JButton("S");
        JButton southEast = new JButton("SE");

        p.add(north);
        p.add(northWest);
        p.add(northEast);
        p.add(west);
        p.add(east);
        p.add(southWest);
        p.add(south);
        p.add(southEast);

        north.addActionListener(listener);
        northWest.addActionListener(listener);
        northEast.addActionListener(listener);
        west.addActionListener(listener);
        east.addActionListener(listener);
        southWest.addActionListener(listener);
        south.addActionListener(listener);
        southEast.addActionListener(listener);

        controlPanel.add(p);
    }
}