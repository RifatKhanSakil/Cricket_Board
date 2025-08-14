package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PlayerTeamRankingsViewController
{
    @javafx.fxml.FXML
    private TableColumn rankColumn;
    @javafx.fxml.FXML
    private Button exportButton;
    @javafx.fxml.FXML
    private ComboBox boardComboBox;
    @javafx.fxml.FXML
    private TableColumn teamColumn;
    @javafx.fxml.FXML
    private TableColumn playerColumn;
    @javafx.fxml.FXML
    private Button loadButton;
    @javafx.fxml.FXML
    private TableColumn pointsColumn;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TableColumn formatColumn;
    @javafx.fxml.FXML
    private ComboBox formatComboBox;
    @javafx.fxml.FXML
    private TableView rankingsTable;
    @javafx.fxml.FXML
    private Button returnButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleLoadRankings(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleReturnHome(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleExportRankings(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ReturnOnAction(ActionEvent actionEvent) {
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
}