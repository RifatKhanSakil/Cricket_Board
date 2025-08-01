package com.oop.group16.summer25_sec2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class PlayerDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewMatchScheduleOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void downloadReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void massageCoachOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewPerformanceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitAvailabilityOnAction(ActionEvent actionEvent) {

    }

    public void viewPerformanceOnAction(javafx.event.ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerViewPerformanceStats.fxml"));
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

    public void viewMatchScheduleOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void submitAvailabilityOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void massageCoachOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void downloadReportOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void logOutOnAction(javafx.event.ActionEvent actionEvent) {
    }
}