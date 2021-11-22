package com.example.mendeleevtable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;



public class Controller extends HelloApplication{


    @FXML
    private Label massL;

    @FXML
    private Label nameR;

    @FXML
    private Label numL;

    @FXML
    public Label logoL;

    @FXML
    public Label infoL;

    @FXML
    void initialize() {

    }

    @FXML
    protected void toTableButton(ActionEvent event)  {

        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        String path = "table.fxml";
        try {
            root = loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Table");
        stage.setResizable(false);
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    private static Controller control = new Controller();

    @FXML
    protected void toGameButton(ActionEvent event) throws IOException {
        String logo = "", name = "";
        File file = new File(Objects.requireNonNull(getClass().getResource("1.txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            name = br.readLine();
        }catch (Exception ignored) {}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Игра");
        stage.setResizable(false);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println(logo);
        System.out.println(name);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        control = loader.getController();
    }

    private static boolean ELEMENT_INFO_WINDOW_OPEN = false;
    @FXML
    protected void goToElemInfo(ActionEvent event) throws Exception  {
        String logo = "", name = "", mass = "", info = "", num = "";
        Button btn = (Button) event.getSource();
        File file = new File(Objects.requireNonNull(getClass().getResource(btn.getId() + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            name = br.readLine();
            mass = br.readLine();
            info = br.readLine();
            num = btn.getId();
        }catch (Exception ignored) {}

        FXMLLoader loader = new FXMLLoader(getClass().getResource("info.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Element Info");
        stage.setResizable(false);
        Parent root = loader.load();
        Controller controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        controller.logoL.setText(logo);
        controller.nameR.setText(name);
        controller.massL.setText(mass);
        controller.infoL.setText(info);
        controller.numL.setText(num);
    }

    @FXML
    protected void backToMain(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        String path = "view.fxml";
        try {
            root = loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void backToMain1(ActionEvent event) {
        gameEnd();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        String path = "view.fxml";
        try {
            root = loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void backToTable(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public Label points, health, logoG, nameID, difficultyTitle;
    public Button checkAnswerButton;
    public Button easyModeButton;
    public Button normalModeButton;
    public Button hardModeButton;
    public TextField usersAnswer;
    public ImageView firstHeart;
    public ImageView secondHeart;
    public ImageView thirdHeart;
    public static String DEGREE_OF_DIFFICULTY= "";
    public static byte GAME_NUM = 0;
    public static int GAME_POINTS = 0;
    public static int GAME_HEALTH = 3;
    public static int[] GAME_ARR = new int[118];

    private static String takeRightAnswer(int number){
        String name = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            String tmp = br.readLine();
            name = br.readLine();
        }catch (Exception ignored) {}
        return name;
    }

    private static String takeLogo(int number){
        String logo = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
        }catch (Exception ignored) {}
        return logo;
    }

    private static void generateInfo(int number){
        control.logoG.setText(takeLogo(number));
    }

    private static void rightAnswer() {
        GAME_POINTS++;
        control.points.setText(String.valueOf(GAME_POINTS));
        control.nameID.setTextFill(Color.GREEN);
        control.points.setTextFill(Color.GREEN);
    }

    private static void wrongAnswer() {
        GAME_HEALTH--;
        control.nameID.setTextFill(Color.RED);
        control.points.setTextFill(Color.RED);
    }

    private static void clearAll(){
        GAME_HEALTH = 3;
        GAME_POINTS = 0;
        GAME_NUM = 0;
        control.points.setText("0");
        control.logoG.setText("");
        control.usersAnswer.setText("");
    }

    private static void gameEnd(){
        setGameElemsVisible(false);
        clearAll();
        control.checkAnswerButton.setText("Начать игру");
        control.health.setText("Здоровье");
    }

    private static void gameOver() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("Gameover.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        scene.getRoot().setStyle("-fx-font-family: 'serif';");
        Stage stage = new Stage();
        stage.setTitle("Game over");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static void gameWin() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("GameWin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        scene.getRoot().setStyle("-fx-font-family: 'serif';");
        Stage stage = new Stage();
        stage.setTitle("Game Win");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static int[] shuffleArray(int numberOfElements) {
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = i + 1;
        }
        Random rnd = new Random();
        int n, current;
        for (int i = numberOfElements - 1; i >= 0; i--) {
            n = rnd.nextInt(i + 1);
            current = arr[n];
            arr[n] = arr[i];
            arr[i] = current;
        }
        return arr;
    }

    private static String deleteAllSpaces (String line){
        char[] arrayOfLetters = line.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char arrayOfLetter : arrayOfLetters) {
            if (arrayOfLetter != ' ') {
                answer.append(arrayOfLetter);
            }
        }
        return answer.toString();
    }

    private static String makeStringLower(String line){
        char[] arrayOfLetters = line.toCharArray();
        for (int i = 0; i < arrayOfLetters.length; i++) {
            if ((arrayOfLetters[i] >= 1040) && (arrayOfLetters[i] < 1072)){
                arrayOfLetters[i] = (char) ((int) arrayOfLetters[i] + 32);
            } else {
                if (arrayOfLetters[i] == 1025){
                    arrayOfLetters[i] = (char) ((int) arrayOfLetters[i] + 80); //Ё
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char arrayOfLetter : arrayOfLetters) {
            answer.append(arrayOfLetter);
        }
        return answer.toString();
    }

    private static void checkAnswerFunc(String rightAnswer, String usersAnswer) {
        if ((rightAnswer.trim()).equalsIgnoreCase(usersAnswer.trim())){
            rightAnswer();
        }else{
            wrongAnswer();
        }
        GAME_NUM++;
        if (GAME_HEALTH == 2){
            control.firstHeart.setVisible(false);
        }
        if (GAME_HEALTH == 1){
            control.secondHeart.setVisible(false);
        }
        if (GAME_HEALTH == 0){
            control.thirdHeart.setVisible(false);
            gameOver();
        }else if (GAME_NUM == choosingGameDifficulty(DEGREE_OF_DIFFICULTY) + 1){
            gameWin();
        } else {
            generateInfo(GAME_ARR[GAME_NUM - 1]);
        }
        control.usersAnswer.setText("");
    }

    private static void setGameElemsVisible(boolean way){
        control.difficultyTitle.setVisible(!way);
        control.easyModeButton.setVisible(!way);
        control.normalModeButton.setVisible(!way);
        control.hardModeButton.setVisible(!way);
        control.checkAnswerButton.setVisible(way);
        control.usersAnswer.setVisible(way);
        control.points.setVisible(way);
        control.nameID.setVisible(way);
        control.health.setVisible(way);
        control.firstHeart.setVisible(way);
        control.secondHeart.setVisible(way);
        control.thirdHeart.setVisible(way);
    }

    private static int choosingGameDifficulty(String choice){
        int numberOfElements = 0;
        switch (choice) {
            case ("Easy") -> numberOfElements = 30;
            case ("Normal") -> numberOfElements = 60;
            case ("Hard") -> numberOfElements = 118;
        }
        return numberOfElements;
    }

    @FXML
    protected void esMode(){
        DEGREE_OF_DIFFICULTY = "Easy";
        checkAnswer();
    }

    @FXML
    protected void normMode(){
        DEGREE_OF_DIFFICULTY = "Normal";
        checkAnswer();
    }

    @FXML
    protected void hardMode(){
        DEGREE_OF_DIFFICULTY = "Hard";
        checkAnswer();
    }

    @FXML
    protected void checkAnswer() {
        if (GAME_NUM == 0){
            control.nameID.setTextFill(Color.BLACK);
            control.points.setTextFill(Color.BLACK);
            setGameElemsVisible(true);
            control.checkAnswerButton.setText("Проверить");
            clearAll();
            GAME_ARR = shuffleArray(choosingGameDifficulty(DEGREE_OF_DIFFICULTY));
            GAME_NUM = 1;
            generateInfo(GAME_ARR[GAME_NUM - 1]);
        }else{
            String rAnswer = makeStringLower(deleteAllSpaces(takeRightAnswer(GAME_ARR[GAME_NUM - 1])));
            String uAnswer = makeStringLower(deleteAllSpaces(usersAnswer.getText()));
            if(usersAnswer.getText().equals("cheat::answer")){
                control.usersAnswer.setText(rAnswer);
            }else if (usersAnswer.getText().equals("cheat::win")){
                GAME_POINTS = choosingGameDifficulty(DEGREE_OF_DIFFICULTY);
                gameWin();
                control.usersAnswer.setText("");
            } else if (usersAnswer.getText().equals("cheat::gameover")){
                gameOver();
                control.usersAnswer.setText("");
            } else if (usersAnswer.getText().equals("cheat::pluspoints")){
                GAME_POINTS += 5;
                control.points.setText(String.valueOf(GAME_POINTS));
                control.usersAnswer.setText("");
            } else if (usersAnswer.getText().equals("cheat::heal")){
                GAME_HEALTH = 3;
                control.firstHeart.setVisible(true);
                control.secondHeart.setVisible(true);
                control.thirdHeart.setVisible(true);
                control.usersAnswer.setText("");
            }else if(usersAnswer.getText().equals("cheat::godmode")){
                GAME_HEALTH = 5000;
                control.firstHeart.setVisible(false);
                control.secondHeart.setVisible(false);
                control.thirdHeart.setVisible(false);
                control.health.setText("Бессмертен");
                control.usersAnswer.setText("");

            } else {
                checkAnswerFunc(rAnswer, uAnswer);
            }
        }
        health.setVisible(false);
        health1.setVisible(false);
        xxx.setText("Здоровье:");
    }
}
