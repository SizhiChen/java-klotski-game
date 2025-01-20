package userInterface;

import javax.swing.*;

/**
 * This class is a JFrame that represents the login window.
 */
public class LoginJFrame extends JFrame {

    public LoginJFrame() {
        // Set the size of the window
        this.setSize(488, 430);
        this.setTitle("Klotski Game - Login");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        this.setVisible(true);
    }
}
