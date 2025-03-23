package org.example;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {

    // Create a reusable database connection method using DriverManager
    private static Connection getDatabaseConnection() {
        try {
            // Load MySQL JDBC driver (optional for some setups, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection using DriverManager
            Connection connection = DriverManager.getConnection(
                    CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME,
                    CommonConstants.DB_PASSWORD);

            JOptionPane.showMessageDialog(null, "Connected to database successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            return connection;

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    // Check if a user exists in the database
    public static boolean checkUser(String username) {
        String query = "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME + " WHERE USERNAME = ?";

        try (Connection connection = getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.isBeforeFirst(); // Returns true if the user exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Register a new user in the database
    public static boolean register(String username, String password) {
        try {
            // First check if the username already exists in the database
            if (!checkUser(username)) {
                try (Connection connection = getDatabaseConnection();
                     PreparedStatement insertUser = connection.prepareStatement(
                             "INSERT INTO " + CommonConstants.DB_USERS_TABLE_NAME + " (username, password) VALUES(?, ?)")) {

                    // Insert parameters in the insert query
                    insertUser.setString(1, username);
                    insertUser.setString(2, password);

                    // Update database with new user
                    insertUser.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Validate login credentials by checking to see if username/password pair exists in the database
    public static boolean validateLogin(String username, String password) {
        String query = "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME + " WHERE USERNAME = ? AND PASSWORD = ?";

        try (Connection connection = getDatabaseConnection();
             PreparedStatement validateUser = connection.prepareStatement(query)) {

            validateUser.setString(1, username);
            validateUser.setString(2, password);

            try (ResultSet resultSet = validateUser.executeQuery()) {
                return resultSet.isBeforeFirst(); // Returns true if credentials are correct
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve a list of all logged-in users from the database
    public static List<String> getAllLoggedInUsers() {
        List<String> users = new ArrayList<>();
        String query = "SELECT username FROM " + CommonConstants.DB_USERS_TABLE_NAME;

        try (Connection connection = getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Adding each username to the list
            while (resultSet.next()) {
                users.add(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
