import userInterface.GameJFrame;
import userInterface.LoginJFrame;
import userInterface.RegisterJFrame;

import java.awt.*;

/**
 * This class is the main class of the program.
 */
public class Main {
    public static void main(String[] args) {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();

        System.out.println("Available Fonts:");
        for (String font : fonts) {
            System.out.println(font);
        }

        new LoginJFrame();
//        new GameJFrame();

    }
}
