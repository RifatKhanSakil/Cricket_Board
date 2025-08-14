package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PlayerDownloadFitnessReportController
{
    @javafx.fxml.FXML
    private TableColumn bmiColumn;
    @javafx.fxml.FXML
    private TableColumn reportDateColumn;
    @javafx.fxml.FXML
    private TableColumn heartRateColumn;
    @javafx.fxml.FXML
    private TableView fitnessReportTable;
    @javafx.fxml.FXML
    private TableColumn staminaColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void returnOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlayerDashboard.fxml"));
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
    public void downloadReportOnAction(ActionEvent actionEvent) {
    }
}