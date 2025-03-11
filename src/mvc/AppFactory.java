package mvc;

import tools.Command;

public interface AppFactory {
    public static void makeMode() {
        // this is supposed to return a Model
    }

    public static View makeView() {
        return new View();
    }

    public static String getTitle() {
        return "Mine Field";
    }

    public static String getHelp() {
        return "Help";
    }

    public static String about() {
        return "About";
    }

    public static String getEditCommands() {
        return "Edit";
    }

    public static void makeEditCommands(String name) {
        // this is supposed to return a Command
    }
}
