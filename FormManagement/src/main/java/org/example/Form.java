package org.example;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {

    // Creating constructor

    public Form(String title) {

        // Setting the title of the title bar
        super(title);

        // Setting the size of the GUI
        setSize(520,680);

        // Configuring GUI and process after closing
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Setting te layout to null to display layout management so we can use absolute positioning
        // To place the components whenever we want
        setLayout(null);

        // Loading GUI in the center of the screen
        setLocationRelativeTo(null);

        // Preventing GUI from changing size
        setResizable(false);

        // Changing background color of the GUI
        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);



    }
}
