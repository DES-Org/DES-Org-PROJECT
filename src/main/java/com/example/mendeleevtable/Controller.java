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
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
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
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        return "table opened";
    }

    private static Controller control = new Controller();


    @FXML
    public static String toGameButton(ActionEvent event, boolean isTest) throws IOException {

        String logo = "1";
        String name = "2";
        File file = new File(Objects.requireNonNull(Controller.class.getResource("1.txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            name = br.readLine();
        }catch (Exception e){
            System.out.println("e");
        }
        System.out.println(logo + " " + name);
        if (!isTest) {
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("game.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Игра");
            stage.setResizable(false);
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            control = loader.getController();
        }
        return "game frame opened";
    }

    @FXML
    public static String goToElemInfo(ActionEvent event, boolean isTest) {

        String logo = "1";
        String name = "1";
        String mass = "1";
        String info = "1";
        String num = "1";
        int numeric;
        if (!isTest) {
            Button btn = (Button) event.getSource();
            num = btn.getId();
            numeric = Integer.parseInt(num);
        } else {
            numeric = 1;
        }
        File file = new File(Objects.requireNonNull(Controller.class.getResource(numeric + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            name = br.readLine();
            mass = br.readLine();
            info = br.readLine();

        }catch (Exception e) {
            System.out.println("e");
        }

        if (!isTest) {
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("info.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Element Info");
            stage.setResizable(false);
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Controller controller = loader.getController();
            assert root != null;
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
    private Label points;
    private Label health;
    private Label logoG;
    private Label nameID;
    private Label gameInfoLabel;
    private Label totalPoints;
    private Button checkAnswerButton;
    private Button easyModeButton;
    private Button normalModeButton;
    private Button hardModeButton;
    private static TextField usersAnswer;
    private ImageView firstHeart;
    private ImageView secondHeart;
    private ImageView thirdHeart;
    private static String degreeOfDifficulty = "";
    private static byte gameNum = 0;
    private static int gamePoints = 0;
    private static int gameHealth = 3;
    private static int[] gameArr = new int[118];

    private static final SecureRandom rnd = new SecureRandom();

    public static String takeRightAnswer(int number){
        String name = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            name = br.readLine();
            name = br.readLine();
        }catch (Exception e) {
            System.out.println("e");
        }
        return name;
    }

    public static String takeLogo(int number){
        String logo = "";
        int num =0;
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            return logo;
        }catch (Exception ignored) {
               num++;
        }
        System.out.println(num);
        return logo;
    }

    public static String generateInfo(int number, boolean isTest){
        if (!isTest) {
            control.logoG.setText(takeLogo(number));
        }
        return "info have been generated";
    }

    public static int rightAnswer(boolean isTest) {
        gamePoints++;
        if (!isTest) {
            control.points.setText(String.valueOf(gamePoints));
            control.nameID.setTextFill(Color.GREEN);
            control.points.setTextFill(Color.GREEN);
        }
        return 1;
    }

    public static int wrongAnswer(boolean isTest) {
        gameHealth--;
        if (!isTest) {
            control.nameID.setTextFill(Color.RED);
            control.points.setTextFill(Color.RED);
        }
        return 1;
    }

    public static int clearAll(boolean isTest){
        gameHealth = 3;
        gamePoints = 0;
        gameNum = 0;
        if (!isTest) {
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
        int points = gamePoints;
        if (!isTest) {
            gameEnd(event, false);
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("Gameover.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Controller ctrl = fxmlLoader.getController();
            scene.getRoot().setStyle("-fx-font-family: 'serif';");
            Stage stage = new Stage();
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
        int n;
        int current;
        for (int i = numberOfElements - 1; i >= 0; i--) {
            n = rnd.nextInt(i + 1);
            current = arr[n];
            arr[n] = arr[i];
            arr[i] = current;
        }
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
                arrayOfLetters[i] = (char) ( arrayOfLetters[i] + 32);
            } else {
                if (arrayOfLetters[i] == 1025){
                    arrayOfLetters[i] = (char) ( arrayOfLetters[i] + 80); //Ё
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

            if ((rightAnswer.trim()).equalsIgnoreCase(usersAnswer.trim())){
                rightAnswer(isTest);
            }else{
                wrongAnswer(isTest);
            }
            gameNum++;
            if (gameHealth == 2 && (!isTest)){
                control.firstHeart.setVisible(false);
            }
            if (gameHealth == 1 && (!isTest)){
                control.secondHeart.setVisible(false);
            }
            if (gameHealth == 0){
                if (!isTest) control.thirdHeart.setVisible(false);
                gameOver(event, isTest);
            }else if (gameNum == choosingGameDifficulty(degreeOfDifficulty) + 1){
                gameWin(event, isTest);
            } else {
                generateInfo(gameArr[gameNum - 1], isTest);
            }
        if (!isTest) {
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
        int numberOfElements;
        switch (choice) {
            case ("Easy") -> numberOfElements = 30;
            case ("Normal") -> numberOfElements = 60;
            case ("Hard") -> numberOfElements = 118;
            default -> numberOfElements = 100;
        }
        return numberOfElements;
    }

    @FXML
    public static void esMode(ActionEvent event) throws IOException {
        degreeOfDifficulty = "Easy";
        int num = checkAnswer(event, false);
        System.out.println(num);
    }

    @FXML
    protected static void normMode(ActionEvent event) throws IOException {
        degreeOfDifficulty = "Normal";
        checkAnswer(event, false);
    }

    @FXML
    protected static void hardMode(ActionEvent event) throws IOException {
        degreeOfDifficulty = "Hard";
        checkAnswer(event, false);
    }


    @FXML
    public static int checkAnswer(ActionEvent event, boolean isTest) throws IOException {
        if (!isTest) {
            if (gameNum == 0){
                control.nameID.setTextFill(Color.BLACK);
                control.points.setTextFill(Color.BLACK);
                setGameElemsVisible(true, false);
                control.checkAnswerButton.setText("Проверить");
                clearAll(false);
                gameArr = shuffleArray(choosingGameDifficulty(degreeOfDifficulty));
                gameNum = 1;
                generateInfo(gameArr[gameNum - 1], false);
            }else{
                String rAnswer = makeStringLower(deleteAllSpaces(takeRightAnswer(gameArr[gameNum - 1])));
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
                    gamePoints += 5;
                    control.points.setText(String.valueOf(gamePoints));
                    control.usersAnswer.setText("");
                } else if (usersAnswer.getText().equals("cheat::heal")){
                    gameHealth = 3;
                    control.firstHeart.setVisible(true);
                    control.secondHeart.setVisible(true);
                    control.thirdHeart.setVisible(true);
                    control.usersAnswer.setText("");
                }else if(usersAnswer.getText().equals("cheat::godmode")){
                    gameHealth = 5000;
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

    public static boolean isPathCorrect(String path) {
        return path.endsWith(".txt");
    }


    public static int fillRange(int num){
        int a = 0;
        for (int i = num; i >= 0; i--){
            num++;
            a += num;
        }
        System.out.println(a);
        return 1;
    }


    public static int cutExtraNum(int set, int num){
        System.out.println(set + num);
        System.out.println("Success");
        return 1;
    }


    public static boolean checkLine(String str) {
        String[] elems = str.split(" ");
        boolean isCorrect = true;
        try {
            for (String elem : elems) {
                Integer.parseInt(elem);
            }
        } catch (NumberFormatException e){
            isCorrect = false;
        }
        return isCorrect;

    }

    public static int[] splitStr(String str) {
        String[] elems = str.split(" ");
        int[] arr = new int[elems.length];
        for (int i = 0; i < elems.length; i++)
            arr[i] = Integer.parseInt(elems[i]);
        return arr;
    }

    public static int[][] cutArr(int counter, int size, int[][] answer){
        int[][] arr = new int[counter][size];
        System.arraycopy(answer, 0, arr, 0, counter);
        return arr;
    }

    public static int[][] sortWSteps(int[] arr) {
        int[][] answer = new int[arr.length][arr.length];
        int counter = 1;
        System.arraycopy(arr, 0, answer[0], 0, arr.length);
        for (int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i;
            while(j > 0 && arr[j - 1] > current){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;
            if (j < i) {
                System.arraycopy(arr, 0, answer[counter], 0, arr.length);
                counter++;
            }
        }
        return cutArr(counter, arr.length, answer);
    }

    public static int[][][] findAllCombinations(String str){
        int[] arr;
        arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++){
            char tempC;
            tempC = str.charAt(i);
            String mystr;
            mystr = String.valueOf(tempC);
            int tmp;
            tmp = Integer.parseInt(mystr);
            if (tmp > 5)
                tmp++;
            if (tmp == 4)
                tmp = 3;
            if (tmp < 0)
                tmp = 9;
            arr[i] = tmp;
        }
        int[][][] ret;
        int size;
        size = str.length();
        ret = new int[size][size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    ret[i][j][k] = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[k];
                    arr[k] = ret[i][j][k];
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                for (int k = 1; k < arr.length; k++) {
                    ret[i-1][j-1][k-1] = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[k];
                    arr[k] = ret[i-1][j-1][k-1];
                }
            }
        }
        int[] array = {1,2,3};
        int left = 1;
        int mid = 2;
        int right = 3;
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int[] leftArray;
        leftArray = new int [lengthLeft];
        int[] rightArray;
        rightArray = new int [lengthRight];

        System.arraycopy(array, left, leftArray, 0, lengthLeft);
        System.arraycopy(array, mid, rightArray, 0, lengthRight);

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft) {

                leftIndex++;
            }
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        int[][][] ans;
        ans = new int[1][1][1];
        ans[0][0][0] = 1;
        return ans;
    }
}
