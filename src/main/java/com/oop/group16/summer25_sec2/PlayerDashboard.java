package com.oop.group16.summer25_sec2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PlayerDashboard {
    @FXML
    public void initialize() {
    }

    @FXML
    public void logOutOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void viewMatchScheduleOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void downloadReportOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void massageCoachOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void viewPerformanceOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerViewPerformanceStats.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(" ");
        }
    }

    @FXML
    public void submitAvailabilityOnAction(ActionEvent actionEvent) {
    }
}