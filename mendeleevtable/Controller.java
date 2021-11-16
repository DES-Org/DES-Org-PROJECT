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
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

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
    public Label points, health, logoG, hearts, nameID;
    public Button checkAnswerButton;
    public TextField usersAnswer;
    public Label colorRight, colorWrong;


    public static byte GAME_NUM = 0;
    public static int GAME_POINTS = 0;
    public static int GAME_HEALTH = 3;

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

    private static void RightAnswer() throws InterruptedException {
        control.colorRight.setVisible(true);
        control.colorWrong.setVisible(false);
        GAME_POINTS++;
        control.points.setText(String.valueOf(GAME_POINTS));
    }

    private static void WrongAnswer() throws InterruptedException {
        control.colorWrong.setVisible(true);
        control.colorWrong.setVisible(false);
        GAME_HEALTH--;
        control.hearts.setText(String.valueOf(GAME_HEALTH));
    }

    private static void clearAll(){
        GAME_HEALTH = 3;
        GAME_POINTS = 0;
        GAME_NUM = 0;
        control.hearts.setText("3");
        control.points.setText("0");
        control.logoG.setText("");
        control.usersAnswer.setText("");
    }

    private static void gameEnd(){
        setGameElemsVisible(false);
        clearAll();
    }

    private static void gameOver(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вы проиграли!");
        alert.setHeaderText("У вас не осталось жизней!");
        alert.setContentText("Вы набрали " + GAME_POINTS + " очков. В следующий раз будет больше!");
        alert.showAndWait();
        GAME_HEALTH = 3;
        GAME_POINTS = 0;
        GAME_NUM = 0;
        gameEnd();
    }

    private static void gameWin() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вы победили!");
        alert.setHeaderText("Вы знаете все элементы!");
        alert.setContentText("Поздравляем! Теперь вы самый крутой химик!");
        alert.showAndWait();
        GAME_HEALTH = 3;
        GAME_POINTS = 0;
        GAME_NUM = 0;
        gameEnd();
    }

    

    private static String makeStringLower(String line){
        char[] arrayOfLetters = line.toCharArray();
        for (int i = 0; i < arrayOfLetters.length; i++) {
            if ((arrayOfLetters[i] >= 1040) && (arrayOfLetters[i] < 1072)){
                arrayOfLetters[i] = (char) ((int) arrayOfLetters[i] + 32);
            } else {
                if (arrayOfLetters[i] == 1025){
                    arrayOfLetters[i] = (char) ((int) arrayOfLetters[i] + 80);
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char arrayOfLetter : arrayOfLetters) {
            answer.append(arrayOfLetter);
        }
        System.out.println(answer);
        return answer.toString();
    }



    private static void checkAnswerFunc(String rightAnswer, String usersAnswer) throws InterruptedException {
        if ((rightAnswer.trim()).equalsIgnoreCase(usersAnswer.trim())){
            RightAnswer();
        }else{
            WrongAnswer();
        }
        GAME_NUM++;
        if (GAME_HEALTH == 0){
            gameOver();
        }else if (GAME_NUM == 119){
            gameWin();
        } else {
            generateInfo(GAME_NUM);
        }
        control.usersAnswer.setText("");
    }

    private static void setGameElemsVisible(boolean way){
        control.usersAnswer.setVisible(way);
        control.points.setVisible(way);
        control.nameID.setVisible(way);
        control.hearts.setVisible(way);
        control.health.setVisible(way);
    }

    @FXML
    protected void checkAnswer() throws InterruptedException {
        if (GAME_NUM == 0){
            setGameElemsVisible(true);
            control.checkAnswerButton.setText("Проверить");
            clearAll();
            GAME_NUM = 1;
            generateInfo(1);
        }else{
            String rAnswer = takeRightAnswer(GAME_NUM);
            String uAnswer = usersAnswer.getText();
            checkAnswerFunc(rAnswer, uAnswer);
            System.out.println(rAnswer + "    " + uAnswer);
            if (rAnswer.equals(uAnswer))
                System.out.println("correct");
        }
    }
}

