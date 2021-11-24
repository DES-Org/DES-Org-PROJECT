package com.example.mendeleevtable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
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
    public static String toTableButton(ActionEvent event, boolean isTest)  {
        if (!isTest){
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            String path = "table.fxml";
            try {
                root = loader.load(Controller.class.getResourceAsStream(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Table");
            stage.setResizable(false);
            assert root != null;
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        return "table opened";
    }

    public static Controller control = new Controller();

    @FXML
    public static String toGameButton(ActionEvent event, boolean isTest) throws IOException {
        if (!isTest) {
            String logo = "", name = "";
            File file = new File(Objects.requireNonNull(Controller.class.getResource("1.txt")).getFile());
            try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
                logo = br.readLine();
                name = br.readLine();
            }catch (Exception ignored) {}
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("game.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Игра");
            stage.setResizable(false);
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println(logo);
            System.out.println(name);
            ((Node)(event.getSource())).getScene().getWindow().hide();
            control = loader.getController();
        }
        return "game frame opened";
    }

    @FXML
    public static String goToElemInfo(ActionEvent event, boolean isTest) throws Exception  {
        if (!isTest) {
            String logo = "", name = "", mass = "", info = "", num = "";
            Button btn = (Button) event.getSource();
            File file = new File(Objects.requireNonNull(Controller.class.getResource(btn.getId() + ".txt")).getFile());
            try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
                logo = br.readLine();
                name = br.readLine();
                mass = br.readLine();
                info = br.readLine();
                num = btn.getId();
            }catch (Exception ignored) {}

            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("info.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Element Info");
            stage.setResizable(false);
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
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
        return "info opened";
    }

    @FXML
    public static String backToMain(ActionEvent event, boolean isTest) {
        if (!isTest) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            String path = "view.fxml";
            try {
                root = loader.load(Controller.class.getResourceAsStream(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();
        }
        return "main opened";
    }

    @FXML
    public static String backToMain1(ActionEvent event, boolean isTest) {
        if (!isTest) {
            gameEnd(event, false);
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            String path = "view.fxml";
            try {
                root = loader.load(Controller.class.getResourceAsStream(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();
        }
        return "main opened";
    }

    @FXML
    public static String backToTable(ActionEvent event, boolean isTest){
        if (!isTest) {((Node)(event.getSource())).getScene().getWindow().hide();}
        return "info hided";
    }

    @FXML
    public Label points, health, logoG, nameID, gameInfoLabel, totalPoints;
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

    public static Random rnd = new Random();

    public static String takeRightAnswer(int number){
        String name = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            name = br.readLine();
            name = br.readLine();
        }catch (Exception ignored) {}
        return name;
    }

    public static String takeLogo(int number){
        String logo = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            return logo;
        }catch (Exception ignored) {}
        return logo;
    }

    public static String generateInfo(int number, boolean isTest){
        if (!isTest) {
            control.logoG.setText(takeLogo(number));
        }
        return "info have been generated";
    }

    public static int rightAnswer(boolean isTest) {
        if (!isTest) {
            GAME_POINTS++;
            control.points.setText(String.valueOf(GAME_POINTS));
            control.nameID.setTextFill(Color.GREEN);
            control.points.setTextFill(Color.GREEN);
        }
        return 1;
    }

    public static int wrongAnswer(boolean isTest) {
        if (!isTest) {
            GAME_HEALTH--;
            control.nameID.setTextFill(Color.RED);
            control.points.setTextFill(Color.RED);
        }
        return 1;
    }

    public static int clearAll(boolean isTest){
        if (!isTest) {
            GAME_HEALTH = 3;
            GAME_POINTS = 0;
            GAME_NUM = 0;
            control.points.setText("0");
            control.logoG.setText("");
            control.usersAnswer.setText("");
        }
        return 1;
    }

    public static int gameEnd(ActionEvent event, boolean isTest){
        if (!isTest) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            setGameElemsVisible(false, false);
            clearAll(false);
            control.checkAnswerButton.setText("Начать игру");
            control.health.setText("Здоровье");
        }
        return 1;
    }

    public static int gameOver(ActionEvent event, boolean isTest) throws IOException{
        if (!isTest) {
            int points = GAME_POINTS;
            System.out.println(points);
            gameEnd(event, false);
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("Gameover.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Controller ctrl = fxmlLoader.getController();
            scene.getRoot().setStyle("-fx-font-family: 'serif';");
            Stage stage = new Stage();
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
            stage.setTitle("Game over");
            stage.setScene(scene);
            stage.show();
            ctrl.totalPoints.setText(String.valueOf(points));
        }
        return 1;
    }

    public static int gameWin(ActionEvent event, boolean isTest) throws IOException{
        if (!isTest) {
            gameEnd(event, false);
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("GameWin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getRoot().setStyle("-fx-font-family: 'serif';");
            Stage stage = new Stage();
            stage.getIcons().add(new Image("https://www.koob.ru/foto/author/8002.jpg"));
            stage.setTitle("Game Win");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        return 1;
    }

    public static int[] shuffleArray(int numberOfElements) {
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            arr[i] = i + 1;
        }
        int n, current;
        for (int i = numberOfElements - 1; i >= 0; i--) {
            n = rnd.nextInt(i + 1);
            current = arr[n];
            arr[n] = arr[i];
            arr[i] = current;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static String deleteAllSpaces (String line){
        char[] arrayOfLetters = line.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char arrayOfLetter : arrayOfLetters) {
            if (arrayOfLetter != ' ') {
                answer.append(arrayOfLetter);
            }
        }
        return answer.toString();
    }

    public static String makeStringLower(String line){
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

    public static int checkAnswerFunc(String rightAnswer, String usersAnswer, ActionEvent event, boolean isTest) throws IOException {
        if (!isTest) {
            if ((rightAnswer.trim()).equalsIgnoreCase(usersAnswer.trim())){
                rightAnswer(false);
            }else{
                wrongAnswer(false);
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
                gameOver(event, false);
            }else if (GAME_NUM == choosingGameDifficulty(DEGREE_OF_DIFFICULTY) + 1){
                gameWin(event, false);
            } else {
                generateInfo(GAME_ARR[GAME_NUM - 1], false);
            }
            control.usersAnswer.setText("");
        }
        return 1;
    }

    public static String setGameElemsVisible(boolean way, boolean isTest){
        if (!isTest) {
            control.gameInfoLabel.setVisible(!way);
            control.easyModeButton.setVisible(!way);
            control.normalModeButton.setVisible(!way);
            control.hardModeButton.setVisible(!way);
            control.checkAnswerButton.setVisible(way);
            control.checkAnswerButton.setVisible(way);
            control.usersAnswer.setVisible(way);
            control.points.setVisible(way);
            control.nameID.setVisible(way);
            control.health.setVisible(way);
            control.firstHeart.setVisible(way);
            control.secondHeart.setVisible(way);
            control.thirdHeart.setVisible(way);
        }
        return "done";
    }

    public static int choosingGameDifficulty(String choice){
        int numberOfElements = 0;
        switch (choice) {
            case ("Easy") -> numberOfElements = 30;
            case ("Normal") -> numberOfElements = 60;
            case ("Hard") -> numberOfElements = 118;
        }
        return numberOfElements;
    }

    @FXML
    public void esMode(ActionEvent event, boolean isTest) throws IOException {
        DEGREE_OF_DIFFICULTY = "Easy";
        checkAnswer(event, false);
    }

    @FXML
    protected void normMode(ActionEvent event) throws IOException {
        DEGREE_OF_DIFFICULTY = "Normal";
        checkAnswer(event, false);
    }

    @FXML
    protected void hardMode(ActionEvent event) throws IOException {
        DEGREE_OF_DIFFICULTY = "Hard";
        checkAnswer(event, false);
    }


    @FXML
    public int checkAnswer(ActionEvent event, boolean isTest) throws IOException {
        if (!isTest) {
            if (GAME_NUM == 0){
                control.nameID.setTextFill(Color.BLACK);
                control.points.setTextFill(Color.BLACK);
                setGameElemsVisible(true, false);
                control.checkAnswerButton.setText("Проверить");
                clearAll(false);
                GAME_ARR = shuffleArray(choosingGameDifficulty(DEGREE_OF_DIFFICULTY));
                GAME_NUM = 1;
                generateInfo(GAME_ARR[GAME_NUM - 1], false);
            }else{
                String rAnswer = makeStringLower(deleteAllSpaces(takeRightAnswer(GAME_ARR[GAME_NUM - 1])));
                String uAnswer = makeStringLower(deleteAllSpaces(usersAnswer.getText()));
                if(usersAnswer.getText().equals("cheat::answer")){
                    control.usersAnswer.setText(rAnswer);
                }else if (usersAnswer.getText().equals("cheat::win")){
                    gameWin(event, false);
                    control.usersAnswer.setText("");
                } else if (usersAnswer.getText().equals("cheat::gameover")){
                    gameOver(event, false);
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
                    checkAnswerFunc(rAnswer, uAnswer, event, false);
                }
            }
        }
        return 1;
    }
}
