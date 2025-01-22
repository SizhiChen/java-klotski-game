package userInterface;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

/**
 * This class is a JFrame that represents the game window.
 */
public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    // Random method
    private final Random random = new Random();
    // Initial Data Array
    private int [][] data = new int[4][4];
    private final int[][] winData = new int[][]{
            {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}
    };
    private boolean win = false;
    private int xZero = 0;
    private int yZero = 0;
    private String path = "image/animal/animal3/";
    private int count = 0;
    // Initial Mean Item in Mean Bar
    private final JMenuItem restart = new JMenuItem("Restart Game");
    private final JMenuItem logout = new JMenuItem("Logout");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem myGithub = new JMenuItem("Github");
    private final JMenuItem myLinkedIn = new JMenuItem("LinkedIn");
    private final JMenuItem animal = new JMenuItem("Animal Picture");
    private final JMenuItem sport = new JMenuItem("Sport Picture");
    private final JMenu changePicture = new JMenu("Change Picture");

    public GameJFrame() {
        // Set the default settings of the window
        initJFrame();
        // Set the menu bar
        initMenuBar();
        // Set the data
        initData();
        // Set the image
        initImage();

        // Add KeyListener to the game
        this.addKeyListener(this);
        // Bind the Action Listener
        this.restart.addActionListener(this);
        this.logout.addActionListener(this);
        this.exit.addActionListener(this);
        this.animal.addActionListener(this);
        this.sport.addActionListener(this);
        // Make the window visible
        this.setVisible(true);
    }

    private void initImage() {
        // Remove all the image
        this.getContentPane().removeAll();

        // Set the Step count
        JLabel stepCount = new JLabel("Steps Count: " + this.count);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        // Test whether you win the game
        if (Arrays.deepEquals(this.data, this.winData)) {
            JLabel winLabel = new JLabel(new ImageIcon("image/win.png"));
            winLabel.setBounds(203, 303, 197, 73);
            win = true;
            this.getContentPane().add(winLabel);
        }

        // Set the game image
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                String path = this.path + this.data[y][x] + ".jpg";
                JLabel jLabel = new JLabel(new ImageIcon(path));
                jLabel.setBounds(105 * x + 83, 105 * y + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }

        // Set the background
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(40 , 40, 508, 560);
        this.getContentPane().add(background);

        // Refresh the page
        this.getContentPane().repaint();
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
            if (initArray[i] == 0) {
                this.yZero = i / 4;
                this.xZero = i % 4;
            }
            this.data[i / 4][i % 4] = initArray[i];
        }
    }

    private void initMenuBar() {
        // Set the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Set the menu
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        menu.add(this.changePicture);
        menu.add(this.restart);
        menu.add(this.logout);
        menu.add(this.exit);
        this.changePicture.add(this.animal);
        this.changePicture.add(this.sport);

        // Set the About Us menu
        JMenu aboutMe = new JMenu("About Us");
        menuBar.add(aboutMe);
        aboutMe.add(this.myGithub);
        aboutMe.add(this.myLinkedIn);

        // Display the menu bar
        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        // Set the default settings of the window
        this.setSize(603, 780);
        this.setTitle("Klotski Game v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Cancel default layout
        this.setLayout(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (win) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {  // press A
            // Remove all the image
            this.getContentPane().removeAll();

            // Draw the competed picture
            String path = this.path + "all.jpg";
            JLabel competedPicture = new JLabel(new ImageIcon(path));
            competedPicture.setBounds(83, 134, 420, 420);
            this.getContentPane().add(competedPicture);
            competedPicture.setBorder(new BevelBorder(BevelBorder.LOWERED));


            // Draw the background
            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            background.setBounds(40 , 40, 508, 560);
            this.getContentPane().add(background);

            // Refresh the page
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (win) {
            return;
        }
        // left:37, up:38,right:39, down:40
        int code = e.getKeyCode();
        if (code == 37){ // release left
            if (xZero != 3) {  // 0 not in the most right column
                // Exchange the image from right label to 0 label
                data[this.yZero][this.xZero] = data[this.yZero][this.xZero + 1];
                data[this.yZero][this.xZero + 1] = 0;
                this.xZero++;
                this.count++;
                initImage();
            }
        } else if (code == 38) {  // release up
            if (yZero != 3) {  // 0 not in the bottom row
                // Exchange the image from lower label to 0 label
                data[this.yZero][this.xZero] = data[this.yZero + 1][this.xZero];
                data[this.yZero + 1][this.xZero] = 0;
                this.yZero++;
                this.count++;
                initImage();
            }
        } else if (code == 39) { // release right
            if (xZero != 0) {  // 0 not in the most left column
                // Exchange the image from left label to 0 label
                data[this.yZero][this.xZero] = data[this.yZero][this.xZero - 1];
                data[this.yZero][this.xZero - 1] = 0;
                this.xZero--;
                this.count++;
                initImage();
            }
        } else if (code == 40) { // release down
            if (yZero != 0) {  // 0 not in the top row
                // Exchange the image from upper label to 0 label
                data[this.yZero][this.xZero] = data[this.yZero - 1][this.xZero];
                data[this.yZero - 1][this.xZero] = 0;
                this.yZero--;
                this.count++;
                initImage();
            }
        } else if (code == 65) { // release a
            initImage();
        } else if (code == 87) { // release w
            data = new int[][] {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            xZero = 3;
            yZero = 3;
            initImage();
        }
        System.out.println();
        System.out.println("y: " + this.yZero);
        System.out.println("x: " + this.xZero);
        System.out.println("count " + this.count);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var chosenItem = e.getSource();
        if (chosenItem == this.restart) {
            this.count = 0;
            this.win = false;
            initData();
            initImage();
        } else if (chosenItem == this.logout) {
            this.setVisible(false);
            new LoginJFrame();
        } else if (chosenItem == this.exit) {
            System.exit(0);
        } else if (chosenItem == this.animal) {
            this.path = "image/animal/animal" + (random.nextInt(8) + 1) + "/";
            System.out.println(this.path);
            this.count = 0;
            this.win = false;
            initData();
            initImage();
        } else if (chosenItem == this.sport) {
            this.path = "image/sport/sport" + (random.nextInt(10) + 1) + "/";
            System.out.println(this.path);
            this.count = 0;
            this.win = false;
            initData();
            initImage();
        }
    }

}
