package com.example.electronic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField previewTxt;

    @FXML
    private TextField currentTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private Button countBtn;

    @FXML
    private Label summaryTxt;


    @FXML
    void countng(ActionEvent event) {

    }

    @FXML
    void initialize() {
        countBtn.setDisable(true);
    }
}