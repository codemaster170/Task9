package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MyJDBCTest {

    @org.junit.jupiter.api.Test
   public void checkUser() {
        boolean exists = MyJDBC.checkUser("Abdulle12");
        assertTrue(exists);

    }


    @org.junit.jupiter.api.Test
    public void validateLogin() {
        boolean valid = MyJDBC.validateLogin("Muna23", "2323");
        assertTrue(valid);

    }

    @org.junit.jupiter.api.Test
    public void getAllLoggedInUsers() {
        List<String> users = MyJDBC.getAllLoggedInUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());

    }
}