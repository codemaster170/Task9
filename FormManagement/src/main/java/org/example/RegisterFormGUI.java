package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFormGUI extends Form {
    public RegisterFormGUI() {
        super("Register");
        addGuiComponents();

    }

    private void addGuiComponents(){

        //Creating Register label
        JLabel registerLabel = new JLabel("Rgister");

        // Configuring component's x, y position and width/height values relative to the GUI
        registerLabel.setBounds(0,25,520,100);

        // Changing font color
        registerLabel.setForeground(CommonConstants.TEXT_COLOR);

        // Changing the font size
        registerLabel.setFont(new Font("Dialog", Font.BOLD,40));

        // Centering text
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding component to GUI
        add(registerLabel);

        // Creating username label
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30,150,400,25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Creating username text field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30,185,450,55);
        usernameField.setBackground(CommonConstants.SECONDARY_COLOR);
        usernameField.setForeground(CommonConstants.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN,24));

        add(usernameField);
        add(usernameLabel);


        // Creating password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30,255,400,25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Creating password text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30,285,450,55);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN,24));

        add(passwordField);
        add(passwordLabel);

        // Creating re-enter password label
        JLabel rePasswordLabel = new JLabel("Re-enter Password");
        rePasswordLabel.setBounds(30,365,400,25);
        rePasswordLabel.setForeground(CommonConstants.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN,18));

        // Creating password text field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(30,395,450,55);
        rePasswordField.setBackground(CommonConstants.SECONDARY_COLOR);
        rePasswordField.setForeground(CommonConstants.TEXT_COLOR);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN,24));

        add(rePasswordLabel);
        add(rePasswordField);

        // Creating Register button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD,18));


        // Changing the cursor to hand when hover the button
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(CommonConstants.TEXT_COLOR);
        registerButton.setBounds(125,520,250,50);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Getting username
                String username = usernameField.getText();

                // Getting password
                String password = new String(passwordField.getPassword());

                // Getting rePassword
                String rePassword = new String(rePasswordField.getPassword());

                // validate user input
                if(validateUserInput(username, password, rePassword)){
                    // registration user to the database
                    if(MyJDBC.register(username, password)){
                        // Dispose pf this gui
                        RegisterFormGUI.this.dispose();

                        // Take user back to the login gui
                        LoginFormGUI loginFormGUI = new LoginFormGUI();
                        loginFormGUI.setVisible(true);

                        // Creating a result dialog
                        JOptionPane.showMessageDialog(loginFormGUI,
                                "Registered Account Successfully!");

                    }else{
                        // register failed (likely due to the user already existing in the database)
                        JOptionPane.showMessageDialog(RegisterFormGUI.this,
                                "Error: Username already taken");
                    }
                }else{
                    // invalid user input
                    JOptionPane.showMessageDialog(RegisterFormGUI.this,
                            "Error: Username must be at least 6 characters \n " +
                            "and/or passwords must match");
                }
            }
        });

        add(registerButton);


        // Creating login label (used to load register GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(CommonConstants.TEXT_COLOR);

        // Adding functionality so that when clicked it will launch the login form gui
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Dispose of this GUI
                RegisterFormGUI.this.dispose();

                // Launch the register gui
                new LoginFormGUI().setVisible(true);

            }
        });

        loginLabel.setBounds(125,600,250,30);
        add(loginLabel);
    }

    public boolean validateUserInput(String username, String password, String rePassword){
        // All fields must have a value
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;

        // username has to be at least 6 characters long
        if(username.length() < 6) return false;

        // password and rePassword must be same
        if(!password.equals(rePassword)) return false;

        // password validation
        return true;
    }

}
