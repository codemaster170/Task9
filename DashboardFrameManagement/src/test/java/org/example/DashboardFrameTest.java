package org.example;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DashboardFrameTest {
    @Test
    public void testDashboardFrame() {
        List<String> users = Arrays.asList("User1", "User2", "User3");
        DashboardFrame dashboardFrame = new DashboardFrame("TestUser", users);

        // Verify frame title
        assertEquals("Dashboard", dashboardFrame.getTitle());

        // Verify welcome label
        Component[] components = dashboardFrame.getContentPane().getComponents();
        JLabel welcomeLabel = null;
        for (Component component : components) {
            if (component instanceof JLabel) {
                welcomeLabel = (JLabel) component;
                break;
            }
        }

        assertNotNull(welcomeLabel); // Added null check
        assertEquals("Welcome, TestUser!", welcomeLabel.getText());

        // Verify user list
        JList<String> userList = null;
        for (Component component : components) {
            if (component instanceof JScrollPane) {
                userList = (JList<String>) ((JScrollPane) component).getViewport().getView();
                break;
            }
        }

        assertNotNull(userList); // Added null check
        assertEquals(3, userList.getModel().getSize());

        // Verify logout button
        JButton logoutButton = null;
        for (Component component : components) {
            if (component instanceof JButton) {
                logoutButton = (JButton) component;
                break;
            }
        }
        assertNotNull(logoutButton); // Added null check
        assertEquals("Logout", logoutButton.getText());
    }

}