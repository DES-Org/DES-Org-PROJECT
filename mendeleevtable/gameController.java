package com.example.mendeleevtable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gameController extends HelloApplication{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }

    @FXML
    protected void backToMain(ActionEvent event) throws Exception {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        String path = "view.fxml";
        try {
            root = (Parent) loader.load(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}

