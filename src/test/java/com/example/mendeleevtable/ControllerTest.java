package com.example.mendeleevtable;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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




}
