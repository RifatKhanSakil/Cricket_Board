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

<<<<<<< HEAD
    public void viewMatchScheduleOnAction(javafx.event.ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerViewMatchSchedule.fxml"));
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

    public void submitAvailabilityOnAction(javafx.event.ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerSubmitAvailability.fxml"));
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

    public void massageCoachOnAction(javafx.event.ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerMessageCoach.fxml"));
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

    public void downloadReportOnAction(javafx.event.ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerDownloadFitnessReport.fxml"));
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

    public void logOutOnAction(javafx.event.ActionEvent actionEvent) {
=======
    @FXML
    public void submitAvailabilityOnAction(ActionEvent actionEvent) {
>>>>>>> origin/master
    }
}