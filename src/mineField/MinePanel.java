/**
 * Filename: MinePanel.java
 * Description: Panel for the Minefield Application
 * Author: Erickson Ng
 * Last Modified: 3/10/25
 */

package mineField;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinePanel extends AppPanel {

    public MinePanel(AppFactory factory) {
        super(factory);
        createButtons(this);
        model.subscribe(this);
    }

    @Override
    public void update() {
        Field field = (Field) model;
        if (field.getGameState() != Field.GameState.RUNNING) {
            updatePlayAgain(true);
            System.out.println("updated panel");
        }
        else {
            updatePlayAgain(false);
        }
        controlPanel.revalidate();
        controlPanel.repaint();
    }

    private JButton empty = new JButton("Play Again");
    protected void createButtons(ActionListener listener) {
        System.out.println(1);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 3));

        JButton northWest = new JButton("NW");
        JButton north = new JButton("N");
        JButton northEast = new JButton("NE");
        JButton west = new JButton("W");
        empty.setVisible(false);
        JButton east = new JButton("E");
        JButton southWest = new JButton("SW");
        JButton south = new JButton("S");
        JButton southEast = new JButton("SE");

        p.add(northWest);
        p.add(north);
        p.add(northEast);
        p.add(west);
        p.add(empty);
        p.add(east);
        p.add(southWest);
        p.add(south);
        p.add(southEast);

        northWest.addActionListener(listener);
        north.addActionListener(listener);
        northEast.addActionListener(listener);
        west.addActionListener(listener);
        east.addActionListener(listener);
        southWest.addActionListener(listener);
        south.addActionListener(listener);
        southEast.addActionListener(listener);
        empty.addActionListener(listener);

        controlPanel.add(p);
    }
    public void updatePlayAgain(boolean visible) {
        empty.setVisible(visible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        if ("Play Again".equals(cmmd)) { // intercept this case first
            Model newModel = factory.makeModel();
            updatePlayAgain(false);
            replaceModel(newModel);
        } else {
            super.actionPerformed(e); // all other parent cases handled
        }
    }
    public void replaceModel(Model newModel) {
        // Unsubscribe and update the model
        model.unsubscribe(this);
        this.model = newModel;
        newModel.subscribe(this);
        view.setModel(newModel);
        newModel.notifySubscribers();

        // Rebuild the control panel so that new action listeners are created
        controlPanel.removeAll();
        createButtons(this);
        controlPanel.revalidate();
        controlPanel.repaint();
    }
}