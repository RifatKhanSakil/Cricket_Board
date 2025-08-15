package com.oop.group16.summer25_sec2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

public class Player
{
    @javafx.fxml.FXML
    private Button messageCoachButton;
    @javafx.fxml.FXML
    private Button viewPerformanceButton;
    @javafx.fxml.FXML
    private Button logOutButton;
    @javafx.fxml.FXML
    private Button submitAvailabilityButton;
    @javafx.fxml.FXML
    private Button downloadReportButton;
    @javafx.fxml.FXML
    private Button viewMatchScheduleButton;
    @javafx.fxml.FXML
    private Button updateFitnessInformationButton;
    @javafx.fxml.FXML
    private Button teamRankingButton;
    @javafx.fxml.FXML
    private Button applyLeaveRequestButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void viewMatchScheduleOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerViewMatchSchedule.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void downloadReportOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerDownloadFitnessReport.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void messageCoachOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerMessageCoach.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void submitAvailabilityOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerSubmitAvailability.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }

    }

    @javafx.fxml.FXML
    public void viewPerformanceOnAction(javafx.event.ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerViewPerformanceStats.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void updateFitnessInformationOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerUpdateFitnessInformation.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void teamRankingOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerTeamRankingsView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }

    @javafx.fxml.FXML
    public void leaveRequestOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerRequestLeave.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            System.out.println(" ");
        }
    }
}