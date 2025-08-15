package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Coach
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void MonitorPlayerPerformanceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ScheduleTrainingOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SendFeedbackToPlayersOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void ReviewPlayerReportsOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void LogOutOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
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
    public void MessageTeamManagerOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewPlayerReportsOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CoachViewPlayerReports.fxml"));
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
}