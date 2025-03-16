import mine_field.MinePanel;
import mine_field.MineFactory;

public class Main {
    public static void main(String[] args) {
        MinePanel app = new MinePanel(new MineFactory());
        app.display();
    }
}