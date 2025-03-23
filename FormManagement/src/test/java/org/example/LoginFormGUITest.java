package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginFormGUITest {
    @Test
    public void testLoginFormGUI() {

        LoginFormGUI loginFormGUI = new LoginFormGUI();

    // Verify frame title
    assertEquals("Login", loginFormGUI.getTitle());

    // Verify frame size
    assertEquals(new Dimension(520, 680), loginFormGUI.getSize());

    // Verify default close operation
    assertEquals(WindowConstants.EXIT_ON_CLOSE, loginFormGUI.getDefaultCloseOperation());

   // Verify layout
        assertEquals(BorderLayout.class, loginFormGUI.getLayout().getClass());

        // Verify components
    Component[] components = loginFormGUI.getContentPane().getComponents();
    assertEquals(7, components.length);

    // Verify login button
    JButton loginButton = null;
        for (Component component : components) {
        if (component instanceof JButton) {
            loginButton = (JButton) component;
            break;
        }
    }

    assertNotNull(loginButton);

    assertEquals("Login",loginButton.getText());

    // Verify register label
    JLabel registerLabel = null;
        for(
    Component component :components)

    {
        if (component instanceof JLabel && !component.equals(components[0])) {
            registerLabel = (JLabel) component;
            break;
        }
    }

    assertNotNull(registerLabel);

    assertEquals("Username",registerLabel.getText());
}

}