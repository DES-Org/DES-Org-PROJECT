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

/
 * This is main controller class, here is the main program code
 * @author Written by Egor Vakar, Denis Talalaev, Vitushko Sergei for our project
 * @version 1.1
 * @since 1.0
 */

public class Controller extends HelloApplication{

    /
     * massL Label for element's mass output
     */
    @FXML
    public Label massL;

    /
     * nameR Label for element's name output
     */

    @FXML
    public Label nameR;

    /
     * numL Label for element's number in table output
     */

    @FXML
    public Label numL;

    /
     * logoL Label for element's logo output
     */

    @FXML
    public Label logoL;

    /
     * infoL Label for element's info output
     */
    @FXML
    public Label infoL;

    /
     * backToMain starts backToMain() method
     */
    @FXML
    public Button backToMain;

    /
     * colorRight using to show correctness of answer
     */
    @FXML
    public Label colorRight;

    /
     * colorWrong using to show incorrectness of answer
     */
    @FXML
    public Label colorWrong;

    /
     * This method close last and open table.fxml Stage
     * @param event action, which start method
     */
    @FXML
    public void toTableButton(ActionEvent event)  {

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

    /
     * control object for changing FXML objects
     */
    public static Controller control = new Controller();

    /
     * This method close last window and open game.fxml Stage
     * @param event action, which start method
     * @throws IOException Exception if it can't open file
     */
    @FXML
    public void toGameButton(ActionEvent event) throws IOException {
        String logo = "", name = "";
        File file = new File(Objects.requireNonNull(getClass().getResource("1.txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
            name = br.readLine();
        }catch (Exception ignored) {}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Game");
        stage.setResizable(false);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println(logo);
        System.out.println(name);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        control = loader.getController();
    }
    /
     * This method close last window and open info.fxml Stage
     * @param event action, which start method
     * @throws Exception Throws Exception if it can't open file for info output
     */

    @FXML
    public void goToElemInfo(ActionEvent event) throws Exception  {
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

    /
     * This method close last window and open view.fxml Stage
     * @param event action, which start method
     */
    @FXML
    public void backToMain(ActionEvent event) {
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

    /
     * This method close last window and open view.fxml Stage
     * @param event action, which start method
     */

    @FXML
    public void backToMain1(ActionEvent event) {
        gameEnd(event);
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

    /
     * This method close info window
     * @param event action, which start method
     */
    @FXML
    public void backToTable(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    /
     * points Label stores number of points in game
     */
    @FXML
    public Label points;
    /
     * health Label stores number of health in game
     */
    @FXML
    public Label health;
    /
     * logoG Label stores element's logo
     */
    @FXML
    public Label logoG;
    /
     * nameID Label is auxiliary title
     */
    @FXML
    public Label nameID;
    /
     * gameInfoLabel Label stores info about game
     */
    @FXML
    public Label gameInfoLabel;
    /
     * totalPoints Label stores points for GameOver
     */
    @FXML
    public Label totalPoints;
    /
     * The button checkAnswerButton starts the checkAnswer() method
     */
    @FXML
    public Button checkAnswerButton;
    /
     * The button easyModeButton starts the esMode() method
     */
    @FXML
    public Button easyModeButton;
    /
     * The button normalModeButton starts the normMode() method
     */
    @FXML
    public Button normalModeButton;
    /
     * The button hardModeButton starts the hardMode() method
     */
    @FXML
    public Button hardModeButton;
    /
     * usersAnswer TextField takes user's answer about element's name
     */
    @FXML
    public TextField usersAnswer;
    /
     * firstHeart ImageView is heart for 1st live
     */
    @FXML
    public ImageView firstHeart;
    /
     * secondHeart ImageView is heart for 2nd live
     */
    @FXML
    public ImageView secondHeart;
    /
     * thirdHeart ImageView is heart for 3rd live
     */
    @FXML
    public ImageView thirdHeart;
    /
     * DEGREE_OF_DIFFICULTY Label stores information about difficulty
     */
    public static String DEGREE_OF_DIFFICULTY= "";
    /
     * GAME_NUM Label information about number of current game element
     */
    public static byte GAME_NUM = 0;
    /
     * GAME_POINTS stores information about user's points in game
     */
    public static int GAME_POINTS = 0;
    /
     * GAME_HEALTH stores information about user's lives in game
     */
    public static int GAME_HEALTH = 3;
    /
     * GAME_ARR stores array of elements numbers for game
     */
    public static int[] GAME_ARR = new int[118];

    /
     * rnd object using for randomize elements numbers
     */
    public static SecureRandom rnd = new SecureRandom();

    /
     * This method find elements name from file with element's number
     * @param number is int value of element's number
     * @return name is element's name
     */
    public static String takeRightAnswer(int number){
        String name = "";
        String tmp = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            tmp = br.readLine();
            name = br.readLine();
        }catch (Exception ignored) {}
        System.out.println(tmp + " " + name);
        return name;
    }

    /
     * This method find elements logo from file with element's number
     * @param number is int value of element's number
     * @return logo is element's logo
     */
    public static String takeLogo(int number){
        String logo = "";
        File file = new File(Objects.requireNonNull(Controller.class.getResource(number + ".txt")).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
            logo = br.readLine();
        }catch (Exception ignored) {}
        return logo;
    }

    /
     * This method change logoG text for element's logo using  takeLogo() method
     * @param number is int value of element's number
     */
    public static void generateInfo(int number){
        control.logoG.setText(takeLogo(number));
    }

    /
     * This method increase users health in game if answer is right
     */
    public static void rightAnswer() {
        GAME_POINTS++;
        control.points.setText(String.valueOf(GAME_POINTS));
        control.nameID.setTextFill(Color.GREEN);
        control.points.setTextFill(Color.GREEN);
    }
    /
     * This method decrease users health in game if answer is wrong
     */
    public static void wrongAnswer() {
        GAME_HEALTH--;
        control.nameID.setTextFill(Color.RED);
        control.points.setTextFill(Color.RED);
    }

    /
     * This method reset points and number of games in game window
     */
    public static void clearAll(){
        GAME_HEALTH = 3;
        GAME_POINTS = 0;
        GAME_NUM = 0;
        control.points.setText("0");
        control.logoG.setText("");
        control.usersAnswer.setText("");
    }

    /
     * This method clear the window and offers to start the game
     * @param event action, which start method
     */
    public static void gameEnd(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
        setGameElemsVisible(false);
        clearAll();
        control.checkAnswerButton.setText("Start the game");
        control.health.setText("Health");
    }

    /
     * This method shows the lose window to user
     * @param event action, which start method
     * @throws IOException Throws Exception if it can't make game over variant
     */
    public static void gameOver(ActionEvent event) throws IOException{
        int points = GAME_POINTS;
        System.out.println(points);
        gameEnd(event);
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

    /
     * This method shows the win window to user
     * @param event action, which start method
     * @throws IOException Trows Exception if can't make game win variant
     */
    public static void gameWin(ActionEvent event) throws IOException{
        gameEnd(event);
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("GameWin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getRoot().setStyle("-fx-font-family: 'serif';");
        Stage stage = new Stage();
        stage.setTitle("Game Win");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /
     * This method shuffles and makes random appearance of elements in game
     * @param numberOfElements uses to shuffle elements in game
     */
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
        return arr;
    }

    /
     * This method deletes all spaces between elements
     * @param line uses to delete all spaces in line
     */
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

    /
     * This method makes line elements lower
     * @param line uses to make string lower
     */
        public static String makeStringLower(String line){
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
        return answer.toString();
    }

    /
     *This method gets the user answer and compares it with the correct one. If there is a match, it calls the rightAnswer() method, otherwise wrongAnswer().
     * @param rightAnswer correct element name
     * @param usersAnswer user element name variant
     * @param event action, which start method
     * @throws IOException Exception if it can't get right answer from file
     */


    public static void checkAnswerFunc(String rightAnswer, String usersAnswer, ActionEvent event) throws IOException {
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
            gameOver(event);
        }else if (GAME_NUM == choosingGameDifficulty(DEGREE_OF_DIFFICULTY) + 1){
            gameWin(event);
        } else {
            generateInfo(GAME_ARR[GAME_NUM - 1]);
        }
        control.usersAnswer.setText("");
    }

    /
     * This method makes elements visible in game window
     * @param way uses to make element of game visible
     */
    public static void setGameElemsVisible(boolean way){
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

    /
     * This method allows user to set difficulty mode in game
     * @param choice variant of user choice
     */
    public static int choosingGameDifficulty(String choice){
        int numberOfElements = 0;
        switch (choice) {
            case ("Easy") -> numberOfElements = 30;
            case ("Normal") -> numberOfElements = 60;
            case ("Hard") -> numberOfElements = 118;
        }
        return numberOfElements;
    }

    /
     * This method allows user to set easy mode in game
     * @param event action, which start method
     * @throws IOException Trows Exception if can't set easy mode
     */
    @FXML
    public void esMode(ActionEvent event) throws IOException {
        DEGREE_OF_DIFFICULTY = "Easy";
        checkAnswer(event);
    }
    /
     * This method allows user to set normal mode in game
     * @param event action, which start method
     * @throws IOException Trows Exception if can't set normal mode
     */
    @FXML
    public void normMode(ActionEvent event) throws IOException {
        DEGREE_OF_DIFFICULTY = "Normal";
        checkAnswer(event);
    }
    /
     * This method allows user to set hard mode in game
     * @param event action, which start method
     * @throws IOException Trows Exception if can't set hard mode
     */
    @FXML
    public void hardMode(ActionEvent event) throws IOException {
        DEGREE_OF_DIFFICULTY = "Hard";
        checkAnswer(event);
    }

    /**
     * checkAnswer void
     * @param event action, which start method
     * @throws IOException Trows Exception if can't check the answer
     */

    @FXML
    public void checkAnswer(ActionEvent event) throws IOException {
        if (GAME_NUM == 0){
            control.nameID.setTextFill(Color.BLACK);
            control.points.setTextFill(Color.BLACK);
            setGameElemsVisible(true);
            control.checkAnswerButton.setText("Check");
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
                gameWin(event);
                control.usersAnswer.setText("");
            } else if (usersAnswer.getText().equals("cheat::gameover")){
                gameOver(event);
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
                control.health.setText("Immortal");
                control.usersAnswer.setText("");

            } else {
                checkAnswerFunc(rAnswer, uAnswer, event);
            }
        }
    }
}
