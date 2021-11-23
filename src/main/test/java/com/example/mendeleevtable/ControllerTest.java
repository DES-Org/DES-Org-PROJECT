package com.example.mendeleevtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void makeStringLower() {
        String given = "HEllo";
        String expected = Controller.makeStringLower(given);
        assertEquals(given, expected);
    }
}