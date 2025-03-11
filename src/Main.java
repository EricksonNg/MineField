import mineField.MinePanel;
import mvc.AppPanel;
import mineField.MineFactory;

public class Main {
    public static void main(String[] args) {
        MinePanel app = new MinePanel(new MineFactory());
        app.display();
    }
}