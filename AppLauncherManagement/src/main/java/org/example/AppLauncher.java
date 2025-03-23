package org.example;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Instantiate a LoginFormGUI object and make it visible
                new LoginFormGUI().setVisible(true);


                // check user test
//                System.out.println(MyJDBC.checkUser("douglas"));

                // Check register test
//                System.out.println(MyJDBC.register("username", "password"));

                // Check validate login test
//                System.out.println(MyJDBC.validateLogin("username", "password"));
            }

        });
    }
}
