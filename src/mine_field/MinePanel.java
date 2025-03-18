package mine_field;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinePanel extends AppPanel {
    private final JButton playAgainButton = new JButton("Play Again");

    public MinePanel(AppFactory factory) {
        super(factory);
        createButtons(this);
        model.subscribe(this);
    }

    @Override
    public void update() {
        Field field = (Field) model;
        updatePlayAgain(field.getGameState() != Field.GameState.RUNNING);
        controlPanel.revalidate();
        controlPanel.repaint();
    }

    protected void createButtons(ActionListener listener) {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 3));

        JButton northWest = new JButton("NW");
        JButton north = new JButton("N");
        JButton northEast = new JButton("NE");
        JButton west = new JButton("W");
        playAgainButton.setVisible(false);
        JButton east = new JButton("E");
        JButton southWest = new JButton("SW");
        JButton south = new JButton("S");
        JButton southEast = new JButton("SE");

        p.add(northWest);
        p.add(north);
        p.add(northEast);
        p.add(west);
        p.add(playAgainButton);
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
        playAgainButton.addActionListener(listener);

        controlPanel.add(p);
    }

    public void updatePlayAgain(boolean visible) {
        playAgainButton.setVisible(visible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        if ("Play Again".equals(cmmd)) { // intercept this case first
            Model newModel = factory.makeModel();
            updatePlayAgain(false);
            // "Play Again" starts new game without saving
            replaceModel(newModel);
        }
        try {
            // rewriting switch from AppPanel because we want to handle our own "MoveException"
            switch (cmmd) {
                case "Save" -> Utilities.save(model, false);
                case "Save As" -> Utilities.save(model, true);
                case "Open" -> {
                    Model newModel = Utilities.open(model);
                    if (newModel != null) {
                        replaceModel(newModel);
                    }
                }
                case "New" -> {
                    Utilities.saveChanges(model);
                    replaceModel(factory.makeModel());
                }
                case "Quit" -> {
                    Utilities.saveChanges(model);
                    System.exit(0);
                }
                case "About" -> Utilities.inform(factory.getAbout());
                case "Help" -> Utilities.inform(factory.getHelp());
                default -> {
                    factory.makeEditCommand(cmmd, model).execute();
                    view.update();
                }
            }
        }
        catch (MoveException exception) {
            String message;
            System.out.println(exception.getType());
            switch (exception.getType()) {
                case INVALID -> message = "Cannot move off the grid.";
                case DISABLED -> message = "Game has ended. Movement is disabled.";
                case WIN -> message = "You survived. GAME WON.";
                case LOSS -> message = "You stepped on a mine. GAME OVER.";
                default -> message = "Unknown error occurred.";
            }
            Utilities.inform(message);
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