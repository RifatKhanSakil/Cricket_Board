package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerViewPerformanceStatsController
{
    @javafx.fxml.FXML
    private Label averageLabel;
    @javafx.fxml.FXML
    private TextField dateRangeField;
    @javafx.fxml.FXML
    private Label runsLabel;
    @javafx.fxml.FXML
    private TextField matchTypeField;
    @javafx.fxml.FXML
    private Label strikeRateLabel;
    @javafx.fxml.FXML
    private Label wicketsLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void returnOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Player.fxml"));
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
    public void loadStatsOnAction(ActionEvent actionEvent) {
    }
}