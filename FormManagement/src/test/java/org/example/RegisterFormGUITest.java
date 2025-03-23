package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFormGUITest {
    @Test
    public void testRegisterFormGUI() {
        RegisterFormGUI registerFormGUI = new RegisterFormGUI();

        // Verify frame title
        assertEquals("Register", registerFormGUI.getTitle());

        // Verify frame size
        assertEquals(new Dimension(520, 680), registerFormGUI.getSize());

        // Verify default close operation
        assertEquals(WindowConstants.EXIT_ON_CLOSE, registerFormGUI.getDefaultCloseOperation());

        // Verify layout
    assertEquals(BorderLayout.class, registerFormGUI.getLayout().getClass());

    // Verify components
    Component[] components = registerFormGUI.getContentPane().getComponents();
    assertEquals(9, components.length);

    // Verify register button
    JButton registerButton = null;
        for (Component component : components) {
        if (component instanceof JButton) {
            registerButton = (JButton) component;
            break;
        }
    }
    assertNotNull(registerButton);
    assertEquals("Register", registerButton.getText());
}
    @Test
    public void testValidateUserInput() {
        RegisterFormGUI registerFormGUI = new RegisterFormGUI();

        // Test valid input
        boolean result = registerFormGUI.validateUserInput("username", "password", "password");
        assertTrue(result);

        // Test invalid input (mismatched passwords)
        result = registerFormGUI.validateUserInput("username", "password", "different");
        assertFalse(result);
    }


}