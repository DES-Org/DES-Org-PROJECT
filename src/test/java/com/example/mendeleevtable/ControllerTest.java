package com.example.mendeleevtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void makeStringLower_Test() {
        String given = "ПРИвет";
        String expected = "привет";
        assertEquals(expected, Controller.makeStringLower(given));
    }

    @Test
    void takeRightAnswer_Test() {
        int num = 6;
        String expected = "углерод";
        String actual = Controller.makeStringLower(Controller.takeRightAnswer(num));
        assertEquals(expected, actual);
    }

    @Test
    void takeLogo_Test() {
        int num = 2;
        String expected = "Не";
        String actual = Controller.deleteAllSpaces(Controller.takeLogo(num));
        assertEquals(expected, actual);
    }

    @Test
    void shuffleArray_Test() {
        int[] arr = new int[118];
        for (int i = 0; i < 118; i++)
            arr[i] = i + 1;
        int[] shuffledArr = Controller.shuffleArray();
        assertFalse(arr.equals(shuffledArr));
    }

    @Test
    void deleteAllSpaces_Test() {
        String str = "пр  и вет     ";
        String expected = "привет";
        String actual = Controller.deleteAllSpaces(str);
        assertEquals(expected, actual);
    }
}
