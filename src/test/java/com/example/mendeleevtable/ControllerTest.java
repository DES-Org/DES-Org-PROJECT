package com.example.mendeleevtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    final String ELEMENT = "ВоДОрОд";

    @Test
    void makeStringLower_Test() {
        String given = "ПРИВЕт";
        String expected = "привет";
        assertEquals(expected, Controller.makeStringLower(given));
    }

    @Test
    void shuffleArray_Test() {
        final int numberOfElements = 1;
        int[] arr = new int[]{1};
        int[] shuffledArr = Controller.shuffleArray(numberOfElements);
        Assertions.assertArrayEquals(arr, shuffledArr);
    }

    @Test
    void deleteAllSpaces_Test() {
        String str = "пр  и вет     ";
        String expected = "привет";
        String actual = Controller.deleteAllSpaces(str);
        assertEquals(expected, actual);
    }
}
