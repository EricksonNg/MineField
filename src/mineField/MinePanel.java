/**
 * Filename: MinePanel.java
 * Description: Panel for the Minefield Application
 * Author: Erickson Ng
 * Last Modified: 3/10/25
 */

package mineField;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.SafeFrame;

import javax.swing.*;
import java.awt.*;

public class MinePanel extends AppPanel {

    public MinePanel(AppFactory factory) {
        super(factory);

        model = new Mine();
        view = new MineView(model);
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.PINK);
        JPanel p = createPanel();
        controlPanel.add(p);
        this.setLayout((new GridLayout(1, 2)));
        this.add(controlPanel);
        this.add(view);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(AppFactory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        display();
    }
}