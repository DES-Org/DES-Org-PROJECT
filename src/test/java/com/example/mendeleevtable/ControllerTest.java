package com.example.mendeleevtable;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private final ActionEvent event = new ActionEvent();

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
        String actual = Controller.deleteAllSpaces(Controller.makeStringLower(Controller.takeRightAnswer(num)));
        assertEquals(expected, actual);
    }

    @Test
    public void takeLogo_Test() {
        int num = 101;
        String expected = "Md";
        String actual = Controller.takeLogo(num);
        assertEquals(expected, actual);
    }

    @Test
    public void shuffleArray_Test() {
        int[] arr = new int[118];
        for (int i = 0; i < 118; i++)
            arr[i] = i + 1;
        int[] actual = Controller.shuffleArray(118);
        assertFalse(Arrays.equals(arr, actual));
    }

    @Test
    public void toTableButton_Test(){
        String expected = "table opened";
        String actual = Controller.toTableButton(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void toGameButton_Test() throws IOException {
        String expected = "game frame opened";
        String actual = Controller.toGameButton(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void toElemInfo_Test() throws Exception {
        String expected = "info opened";
        String actual = Controller.goToElemInfo(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void backToMain_Test() {
        String expected = "main opened";
        String actual = Controller.backToMain(event, true);
        assertEquals(expected, actual);
    }


    @Test
    public void backToMain1_Test() {
        String expected = "main opened";
        String actual = Controller.backToMain1(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void backToTable_Test() {
        String expected = "info hided";
        String actual = Controller.backToTable(event, true);
        assertEquals(expected, actual);
    }

    @Test
    public void generateInfo_Test() {
        String expected = "info have been generated";
        String actual = Controller.generateInfo(1, true);
        assertEquals(expected, actual);
    }

    @Test
    public void rightAnswer_Test(){
        assertEquals(1, Controller.rightAnswer(true));
    }

    @Test
    public void wrongAnswer_Test(){
        assertEquals(1, Controller.wrongAnswer(true));
    }

    @Test
    public void gameEnd_Test(){
        assertEquals(1, Controller.gameEnd(event, true));
    }

    @Test
    public void clearAll_Test(){
        assertEquals(1, Controller.clearAll(true));
    }

    @Test
    public void gameOver_Test() throws IOException {
        assertEquals(1, Controller.gameOver(event, true));
    }

    @Test
    public void gameWin_Test() throws IOException {
        assertEquals(1, Controller.gameWin(event, true));
    }


    @Test
    public void checkAnswerFunc_Test() throws IOException {
        assertEquals(1, Controller.checkAnswerFunc("", "", event, true));
    }

    @Test
    public void setGameElemsVisible_Test()  {
        assertEquals("done", Controller.setGameElemsVisible(true, true));
    }

    @Test
    public void choosingGameDifficulty_Test()  {
        int expected = 30;
        int actual = Controller.choosingGameDifficulty("Easy");
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "D:\\in.txt",
            ".txt"
    })
    public void isPathCorrect_Test_True(String input) {
        assertTrue(Controller.isPathCorrect(input));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "dawd",
            "D:\\ou.ttx",
    })
    public void isPathCorrect_Test_False(String input) {
        assertFalse(Controller.isPathCorrect(input));
    }

    @Test
    public void fillRange_test() {
        int n = 5;
        Set<Integer> expectedResult = new HashSet<>();
        expectedResult.add(5);
        expectedResult.add(6);
        expectedResult.add(7);
        expectedResult.add(8);
        expectedResult.add(9);
        expectedResult.add(10);
        Set<Integer> myResult = Controller.fillRange(n);
        assertEquals(expectedResult, myResult);
    }

    @Test
    public void cutExtraNum_Test() {
        int n = 10;
        HashSet<Integer> set = Controller.fillRange(n);
        Set<Integer> expectedResult = new HashSet<>();
        expectedResult.add(11);
        expectedResult.add(13);
        expectedResult.add(17);
        expectedResult.add(19);
        Set<Integer> myResult = Controller.cutExtraNum(set, n);
        assertEquals(expectedResult, myResult);

    }

    @Test
    public void testCheckLine() {
        String str = "1 5 9 7 1 5 2 11";
        boolean myResult = Controller.checkLine(str);
        assertTrue(myResult);
    }

    @Test
    public  void splitStr_Test() {
        int[] expected = {1, 2, 3, 4, 5};
        String str = "1 2 3 4 5";
        int[] myResult = Controller.splitStr(str);
        assertArrayEquals(expected, myResult);
    }

    @Test
    public void sortWSteps_Test() {
        int[][] expected = {
                {1, 2, 5, 4, 3},
                {1, 2, 4, 5, 3},
                {1, 2, 3, 4, 5}
        };
        int[] arr = {1, 2, 5, 4, 3};
        int[][] my = Controller.sortWSteps(arr);
        assertArrayEquals(expected, my);
    }

    @Test
    public void cutArr_Test(){
        int[][] expected = {
                {1, 2, 5, 4, 3},
                {1, 2, 4, 5, 3},
                {1, 2, 3, 4, 5}
        };
        int[][] my = {
                {1, 2, 5, 4, 3},
                {1, 2, 4, 5, 3},
                {1, 2, 3, 4, 5},
                {1, 2, 5, 4, 3},
                {1, 2, 4, 5, 3}
        };
        int[][] actual = Controller.cutArr(3, 5, my);
    }
    
    
    @Test
    public void findAllCombinations_Test(){
        int[][][] expected = new int[1][1][1];
        expected[0][0][0] = 1;
        int[][][] actual = Controller.findAllCombinations("12359");
        assertArrayEquals(expected, actual);
    }
    
    
}
