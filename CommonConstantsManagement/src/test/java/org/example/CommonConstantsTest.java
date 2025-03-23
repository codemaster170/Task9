package org.example;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CommonConstantsTest {
    @Test
    public void testPrimaryColor() {
        Color expectedColor = new Color(19, 45, 70);
        assertEquals(expectedColor, CommonConstants.PRIMARY_COLOR);
    }

    @Test
    public void testSecondaryColor() {
        Color expectedColor = new Color(25, 30, 41);
        assertEquals(expectedColor, CommonConstants.SECONDARY_COLOR);
    }

    @Test
    public void testDbUrl() {
        String expectedUrl = "jdbc:mysql://127.0.0.1:3307/login_registration";
        assertEquals(expectedUrl, CommonConstants.DB_URL);
    }

    @Test
    public void testDbUsername() {
        String expectedUsername = "root";
        assertEquals(expectedUsername, CommonConstants.DB_USERNAME);
    }

    @Test
    public void testDbPassword() {
        String expectedPassword = "YASIn&144";
        assertEquals(expectedPassword, CommonConstants.DB_PASSWORD);
    }
    @Test
    public void testDbUsersTableName() {
        String expectedTableName = "USERS";
        assertEquals(expectedTableName, CommonConstants.DB_USERS_TABLE_NAME);
    }



}