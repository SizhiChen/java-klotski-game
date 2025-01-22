package userInterface;

import data.userData;
import verification.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is a JFrame that represents the login window.
 */
public class LoginJFrame extends JFrame implements MouseListener {

    // Login
    private final JLabel userNameLogo = new JLabel(new ImageIcon("image/login/loginLogoCn.png"));
    private final JTextField userNameText = new JTextField();
    // Password
    private final JLabel passwordLogo = new JLabel(new ImageIcon("image/login/passwordLogoCn.png"));
    private final JPasswordField passwordText = new JPasswordField();
    private final JButton visible = new JButton(new ImageIcon("image/login/visible.png"));
    // Verification Code
    private final JLabel verificationCode = new JLabel(new ImageIcon("image/login/codeLogoCn.png"));
    private final JTextField verificationCodeText = new JTextField();
    private String verification = code.verificationCode();
    private final JButton verificationCodeShow = new JButton(verification);
    // Login button
    private final JButton loginButton = new JButton(new ImageIcon("image/login/loginButtonCn.png"));
    private final JButton registerButton = new JButton(new ImageIcon("image/login/registerButtonCn.png"));
    // Background
    private final JLabel background = new JLabel(new ImageIcon("image/login/backgroundCn.png"));

    public LoginJFrame() {
        // Set the default settings of the window
        initJFrame();
        // Set the image
        initImage();

        // Make the window visible
        this.setVisible(true);
    }

    private void initImage() {
        // Remove all the image
        this.getContentPane().removeAll();

        // Set the username logo
        this.userNameLogo.setBounds(116, 140, 51, 19);
        this.getContentPane().add(this.userNameLogo);
        // Set the username text field
        this.userNameText.setBounds(195, 134, 200, 30);
        this.getContentPane().add(this.userNameText);
        // Set the password logo
        this.passwordLogo.setBounds(130, 200, 35, 19);
        this.getContentPane().add(this.passwordLogo);
        // Set the password text field
        this.passwordText.setBounds(195, 195, 200, 30);
        this.passwordText.setEchoChar('*');
        this.getContentPane().add(this.passwordText);
        // Set the password visible icon
        this.visible.setBounds(410, 195, 18, 29);
        this.getContentPane().add(this.visible);
        this.visible.setBorderPainted(false);
        this.visible.setContentAreaFilled(false);
        this.visible.addMouseListener(this);
        // Set the verification Code
        this.verificationCode.setBounds(110, 260, 56, 21);
        this.getContentPane().add(this.verificationCode);
        // Set the verification Code text field
        this.verificationCodeText.setBounds(195, 256, 80, 30);
        this.getContentPane().add(this.verificationCodeText);
        // Show the verification Code
        this.verificationCodeShow.setBounds(280, 256, 110, 30);
        verificationCodeShow.setFont(new Font("Algerian", Font.PLAIN, 20)); // Script MT Bold
        this.getContentPane().add(this.verificationCodeShow);
        this.verificationCodeShow.setBorderPainted(false);
        this.verificationCodeShow.setContentAreaFilled(false);
        this.verificationCodeShow.addMouseListener(this);
        // Set the login button
        this.loginButton.setBounds(123, 310, 128, 47);
        this.getContentPane().add(this.loginButton);
        this.loginButton.setBorderPainted(false);
        this.loginButton.setContentAreaFilled(false);
        this.loginButton.addMouseListener(this);
        // Set the register button
        this.registerButton.setBounds(256, 310, 128, 47);
        this.getContentPane().add(registerButton);
        this.registerButton.setBorderPainted(false);
        this.registerButton.setContentAreaFilled(false);
        this.registerButton.addMouseListener(this);


        // Set the background
        this.background.setBounds(0 , 0, 470, 390);
        this.getContentPane().add(this.background);

        // Refresh the page
        this.getContentPane().repaint();
    }

    private void initJFrame() {
        // Set the size of the window
        this.setSize(488, 430);
        this.setTitle("Klotski Game - Login");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cancel default layout
        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var logo = e.getSource();
        if (logo == this.registerButton) {
            this.setVisible(false);
            new RegisterJFrame();
        } else if (logo == this.loginButton) {
            String username = getUsername();
            String password = getPassword();
            boolean verificationCodeCheck = this.verificationCodeText.getText().equalsIgnoreCase(verification);
            if (userData.login(username, password) && verificationCodeCheck) {
                this.setVisible(false);
                new GameJFrame();
            } else {
                verification = code.verificationCode();
                this.verificationCodeShow.setText(verification);
                this.verificationCodeShow.repaint();
                if (!verificationCodeCheck) {
                    JOptionPane.showMessageDialog(this,
                            "Verification Code is Wrong. Please try again!");
                    verificationCodeText.setText("");  // Only Clear verification code field
                } else if (!userData.usernameExit(username)) {
                    JOptionPane.showMessageDialog(this,
                            "Username does not exist. Please try again!");
                    userNameText.setText("");  // Clear username field
                    passwordText.setText("");  // Clear password field
                    verificationCodeText.setText("");  // Clear verification code field
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Wrong password. Please try again!");
                    passwordText.setText("");  // Clear password field
                    verificationCodeText.setText("");  // Clear verification code field
                }
            }
        } else if (logo == this.verificationCodeShow) {
            verification = code.verificationCode();
            this.verificationCodeShow.setText(verification);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        var logo = e.getSource();
        if (logo == this.visible) {
            this.visible.setIcon(new ImageIcon("image/login/visibleHold.png"));
            this.visible.repaint();  // Force UI refresh
            this.passwordText.setEchoChar((char) 0);
        } else if (logo == this.loginButton) {
            this.loginButton.setIcon(new ImageIcon("image/login/loginButtonHoldCn.png"));
            this.loginButton.repaint();  // Force UI refresh
        } else if (logo == this.registerButton) {
            this.registerButton.setIcon(new ImageIcon("image/login/registerButtonHoldCn.png"));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        var logo = e.getSource();
        if (logo == this.visible) {
            this.visible.setIcon(new ImageIcon("image/login/visible.png"));
            this.visible.repaint();  // Force UI refresh
            this.passwordText.setEchoChar('*');
        } else if (logo == this.loginButton) {
            this.loginButton.setIcon(new ImageIcon("image/login/loginButtonCn.png"));
            this.loginButton.repaint();  // Force UI refresh
        } else if (logo == this.registerButton) {
            this.registerButton.setIcon(new ImageIcon("image/login/registerButtonCn.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public String getUsername() {
        return this.userNameText.getText();
    }

    public String getPassword() {
        return new String(passwordText.getPassword());
    }
}
