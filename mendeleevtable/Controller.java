package com.example.mendeleevtable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

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
    public Button e1, e2, e3, e4, d5, e6, e7, e8;

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

    @FXML
    protected void toGameButton(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        String path = "game.fxml";
        try {
            root = loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Game");
        stage.setResizable(false);
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
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
        Parent root = (Parent) loader.load();
        Controller controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println(logo);
        System.out.println(name);
        System.out.println(mass);
        System.out.println(info);
        System.out.println(num);
        System.out.println();
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
    protected void backToTable(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}

