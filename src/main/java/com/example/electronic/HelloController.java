package com.example.electronic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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

    private void checkEvent(TextField field,TextField nextField , KeyEvent event){
        if (!Character.isDigit(event.getCode().getCode()) &&
                !Character.isISOControl(event.getCode().getCode())) {
            if (!event.getCode().getChar().equals(",")) {
                createAlert("Предупреждение",
                        "Некорректные данные в поле ввода данных",
                        "Проверьте корректность введенных данных в поле.",
                        Alert.AlertType.WARNING
                );
            } else if (field.getText().indexOf(',') != -1){
                createAlert("Предупреждение",
                        "Некорректные данные в поле ввода данных",
                        "Проверьте корректность введенных данных в поле.",
                        Alert.AlertType.WARNING
                );
            }
        }
        if (event.getCode() == KeyCode.ENTER){
            nextField.requestFocus();
        }
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
        checkEvent(previewTxt, currentTxt, event);
    }

    @FXML
    void currentCheck(KeyEvent event) {
        checkEvent(currentTxt, priceTxt, event);
    }

    @FXML
    void priceCheck(KeyEvent event) {
        if(previewTxt.getText().length() == 0 ||
                currentTxt.getText().length()==0){
            createAlert("Предупреждение",
                    "Не заполненные данные",
                    "Заполните предыдущие поля.",
                    Alert.AlertType.WARNING
            );

            if (previewTxt.getText().length() == 0)
                previewTxt.requestFocus();
            else  currentTxt.requestFocus();
        }
        checkEvent(currentTxt, priceTxt, event);
        countBtn.setDisable(false);
    }

    @FXML
    void countng(ActionEvent event) {
        if (priceTxt.getText().trim().isEmpty() == false)
            summaryTxt.setText("nice");
        else{
            countBtn.setDisable(true);
            createAlert("Предупреждение",
                    "Не заполненные данные",
                    "Заполните данные о цене.",
                    Alert.AlertType.WARNING
            );
            priceTxt.requestFocus();
        }
    }

    @FXML
    void initialize() {
        countBtn.setDisable(true);
    }
}