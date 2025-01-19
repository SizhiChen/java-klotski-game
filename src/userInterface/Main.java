package userInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame klotski = new JFrame("Klotski Game");
        klotski.setSize(603, 680);
        klotski.setVisible(true);

        // Create a login panel
        JFrame login = new JFrame();
        login.setSize(488, 430);
        login.setVisible(true);

        // Create a register panel
        JFrame register = new JFrame();
        register.setSize(488, 500);
        register.setVisible(true);
    }
}
