package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerRequestLeaveController
{
    @javafx.fxml.FXML
    private TextField leaveTypeField;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TextField reasonField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void returnOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Player.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void submitRequestOnAction(ActionEvent actionEvent) {
    }
}