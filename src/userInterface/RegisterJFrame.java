package userInterface;

import javax.swing.*;

/**
 * This class is a JFrame that represents the register window.
 */
public class RegisterJFrame extends JFrame {

    public RegisterJFrame() {
        // Set the size of the window
        this.setSize(488, 500);
        this.setTitle("Klotski Game - Register");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        this.setVisible(true);
    }
}
