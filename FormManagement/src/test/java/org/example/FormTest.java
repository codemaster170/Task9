package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class FormTest {
    @Test
    public void testFormConstructor() {
        Form form = new Form("Test Form");

        // Verify frame title
        assertEquals("Test Form", form.getTitle());

        // Verify frame size
        assertEquals(new Dimension(520, 680), form.getSize());

        // Verify default close operation
        assertEquals(WindowConstants.EXIT_ON_CLOSE, form.getDefaultCloseOperation());

        // Verify layout
        assertEquals(BorderLayout.class, form.getLayout().getClass());

        // Verify location
        assertNotNull(form.getLocation());

        // Verify resizable
        assertFalse(form.isResizable());

        // Verify background color
        assertEquals(CommonConstants.PRIMARY_COLOR, form.getContentPane().getBackground());
    }


}