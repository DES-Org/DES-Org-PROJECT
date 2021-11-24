package com.example.mendeleevtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    @Test
    public void makeStringLower_Test() {
        String given = "ПРИВЕт";
        String expected = "привет";
        assertEquals(expected, Controller.makeStringLower(given));
    }

    @Test
    public void deleteAllSpaces_Test() {
        String str = "пр  и вет     ";
        String expected = "привет";
        String actual = Controller.deleteAllSpaces(str);
        assertEquals(expected, actual);
    }

    @Test
    public void takeRightAnswer_Test() {
        int num = 66;
        String expected = "диспрозий";
        String actual = expected + Controller.deleteAllSpaces(Controller.makeStringLower(Controller.takeRightAnswer(num)));
        assertEquals(expected, actual);
    }

    @Test
    public void takeLogo_Test() {
        int num = 101;
        String expected = "Md";
        String actual = expected + Controller.takeLogo(num);
        assertEquals(expected, actual);
    }

    @Test
    public void shuffleArray_Test() {
        int arr[] = new int[118];
        for (int i = 0; i < 118; i++)
            arr[i] = i + 1;
        int[] actual = Controller.shuffleArray(118);
        assertFalse(arr.equals(actual));
    }
}
