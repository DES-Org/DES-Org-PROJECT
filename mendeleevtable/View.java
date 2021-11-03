package com.example.mendeleevtable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class View {
    @FXML
    private Label infoL;

    public void setViewLabelFxText(String text) {
        infoL.setText(text);
    }
}
