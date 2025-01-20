package userInterface;

import javax.swing.*;
import java.util.Random;

/**
 * This class is a JFrame that represents the game window.
 */
public class GameJFrame extends JFrame {

    private final int [][] data = new int[4][4];

    public GameJFrame() {
        // Set the default settings of the window
        initJFrame();
        // Set the menu bar
        initMenuBar();
        // Set the data
        initData();
        // Set the image
        initImage();

        // Make the window visible
        this.setVisible(true);
    }

    private void initImage() {
        // Set the default image
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                JLabel jLabel = new JLabel(new ImageIcon("F:\\Java\\Klotski\\image\\animal\\animal3\\%d.jpg"
                        .formatted(data[y][x])));
                jLabel.setBounds(105 * x, 105 * y, 105, 105);
                this.getContentPane().add(jLabel);
            }
        }
    }

    private void initData() {
        Random random = new Random();
        // Set random array
        int[] initArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < initArray.length; i++) {
            int index = random.nextInt(initArray.length);
            int temp = initArray[i];
            initArray[i] = initArray[index];
            initArray[index] = temp;
        }
        // Put them into a two-dimensional array
        for (int i = 0; i < initArray.length; i++) {
            this.data[i / 4][i % 4] = initArray[i];
        }
    }

    private void initMenuBar() {
        // Set the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Set the function menu
        JMenu function = new JMenu("Menu");
        menuBar.add(function);
        JMenuItem restart = new JMenuItem("Restart Game");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem exit = new JMenuItem("Exit");
        function.add(restart);
        function.add(logout);
        function.add(exit);

        // Set the About Us menu
        JMenu aboutMe = new JMenu("About Us");
        menuBar.add(aboutMe);
        JMenuItem myGithub = new JMenuItem("Github");
        JMenuItem myLinkedIn = new JMenuItem("LinkedIn");
        aboutMe.add(myGithub);
        aboutMe.add(myLinkedIn);

        // Display the menu bar
        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        // Set the default settings of the window
        this.setSize(603, 680);
        this.setTitle("Klotski Game v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Cancel default layout
        this.setLayout(null);
    }

}
