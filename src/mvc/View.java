package mvc;

import tools.Subscriber;
import javax.swing.*;
import java.awt.*;

public abstract class View extends JPanel implements Subscriber {
    protected final Model model;

    public View(Model model) {
        this.model = model;
    }

    public abstract void update();

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
    }
}
