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
    private Label nameL;

    @FXML
    private Label nameR;

    @FXML
    private Label numL;

    @FXML
    public Label logoL;


    @FXML
    void initialize() {
        assert nameR != null : "fx:id=\"nameR\" was not injected: check your FXML file 'info.fxml'.";
        assert logoL != null : "fx:id=\"logoL\" was not injected: check your FXML file 'info.fxml'.";
        assert massL != null : "fx:id=\"massL\" was not injected: check your FXML file 'info.fxml'.";
        assert nameL != null : "fx:id=\"nameL\" was not injected: check your FXML file 'info.fxml'.";
        assert numL != null : "fx:id=\"numL\" was not injected: check your FXML file 'info.fxml'.";
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
        String path = "info.fxml";
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

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(path));
        Stage stage = new Stage();
        stage.setTitle("Element Info");
        stage.setResizable(false);
        stage.setScene(new Scene(loader.load(), 468, 480));
        stage.show();
        System.out.println(logo);
        System.out.println(name);
        System.out.println(mass);
        System.out.println(info);
        System.out.println(num);
        System.out.println();
        /*
        logoL.setText(logo);
        nameR.setText(name);
        massL.setText(mass);
        numL.setText(num);
        infoL.setText(info);*/
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

