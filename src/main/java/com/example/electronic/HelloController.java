package com.example.electronic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class HelloController {
    private void createAlert(String title, String header, String text, Alert.AlertType code){
        Alert alert = new Alert(code);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }

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
    void previewCheck(KeyEvent event) {
        if (!Character.isDigit(event.getCode().getCode()) &&
                !Character.isISOControl(event.getCode().getCode())) {
            if (!event.getCode().getChar().equals(",")) {
                createAlert("Предупреждение",
                        "Некорректные данные в поле ввода данных",
                        "Проверьте корректность введенных данных в поле\nпредыдущее показание",
                        Alert.AlertType.WARNING
                        );
            } else if (previewTxt.getText().indexOf(',') != -1){
                createAlert("Предупреждение",
                        "Некорректные данные в поле ввода данных",
                        "Проверьте корректность введенных данных в поле\nпредыдущее показание",
                        Alert.AlertType.WARNING
                );
            }
        }
    }

    @FXML
    void currentCheck(KeyEvent event) {

    }

    @FXML
    void priceCheck(KeyEvent event) {

    }

    @FXML
    void countng(ActionEvent event) {

    }

    @FXML
    void initialize() {
        countBtn.setDisable(true);
    }
}