package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardFrame extends JFrame {
    public DashboardFrame(String username, List<String> users) {
        // Setting title of the dashboard window
        super("Dashboard");

        // Setting size of the frame
        setSize(600, 400);

        // Centering the frame on the screen
        setLocationRelativeTo(null);

        // Ensuring program exits when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the layout to null for absolute positioning
        setLayout(null);

        // Setting background color to match the existing theme
        getContentPane().setBackground(CommonConstants.SECONDARY_COLOR);

        // Creating a welcome label
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setBounds(50, 20, 500, 40);
        welcomeLabel.setForeground(CommonConstants.TEXT_COLOR);
        welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel);

        // Creating a label to display all users
        JLabel usersLabel = new JLabel("Users with access:");
        usersLabel.setBounds(50, 80, 500, 30);
        usersLabel.setForeground(CommonConstants.TEXT_COLOR);
        usersLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        usersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(usersLabel);

        // Creating a list component to display users
        DefaultListModel<String> userListModel = new DefaultListModel<>();
        for (String user : users) {
            userListModel.addElement(user);
        }

        JList<String> userList = new JList<>(userListModel);
        userList.setBackground(CommonConstants.SECONDARY_COLOR);
        userList.setForeground(CommonConstants.TEXT_COLOR);
        userList.setFont(new Font("Dialog", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setBounds(150, 120, 300, 150);
        scrollPane.setBackground(CommonConstants.SECONDARY_COLOR);
        add(scrollPane);

        // Creating a logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 300, 200, 40);
        logoutButton.setBackground(CommonConstants.TEXT_COLOR);
        logoutButton.setForeground(CommonConstants.SECONDARY_COLOR);
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // Adding action listener to handle logout
        logoutButton.addActionListener(e -> {
            dispose(); // Close dashboard window
            System.exit(0); // Exit the application to prevent circular dependency
        });

        add(logoutButton);
    }
}
