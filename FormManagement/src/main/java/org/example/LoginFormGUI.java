package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class LoginFormGUI extends Form {
    public LoginFormGUI() {
        // Setting the title of the login form
        super("Login");

        // Adding UI components to the login form
        addGuiComponents();
    }

    private void addGuiComponents() {
        // Creating login label
        JLabel loginLabel = new JLabel("Login");

        // Configuring position and size of the login label
        loginLabel.setBounds(0, 25, 520, 100);

        // Changing font color
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);

        // Changing font size and style
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // Centering text horizontally
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding login label to the form
        add(loginLabel);

        // Creating username label
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Creating username input field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(CommonConstants.SECONDARY_COLOR);
        usernameField.setForeground(CommonConstants.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        // Adding username label and field to the form
        add(usernameField);
        add(usernameLabel);

        // Creating password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 335, 400, 25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Creating password input field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 365, 450, 55);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        // Adding password label and field to the form
        add(passwordField);
        add(passwordLabel);

        // Creating login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // Changing cursor style when hovering over the button
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(CommonConstants.TEXT_COLOR);
        loginButton.setBounds(125, 520, 250, 50);

        // Adding event listener to handle login action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieving entered username
                String username = usernameField.getText();

                // Retrieving entered password
                String password = new String(passwordField.getPassword());

                // Checking credentials in the database
                if (MyJDBC.validateLogin(username, password)) {
                    // Displaying success message
                    JOptionPane.showMessageDialog(LoginFormGUI.this, "Login Successful!");

                    // Retrieving the list of logged-in users from the database
                    List<String> users = MyJDBC.getAllLoggedInUsers();

                    // Opening the dashboard and passing the username and user list
                    new DashboardFrame(username, users).setVisible(true);

                    // Closing the login form
                    dispose();
                } else {
                    // Displaying login failure message
                    JOptionPane.showMessageDialog(LoginFormGUI.this, "Login Failed...");
                }
            }
        });

        // Adding login button to the form
        add(loginButton);

        // Creating register label to navigate to the registration form
        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);

        // Adding event listener to navigate to the registration form when clicked
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Closing the login form
                LoginFormGUI.this.dispose();

                // Opening the registration form
                new RegisterFormGUI().setVisible(true);
            }
        });

        // Setting position of register label
        registerLabel.setBounds(125, 600, 250, 30);

        // Adding register label to the form
        add(registerLabel);
    }
}
