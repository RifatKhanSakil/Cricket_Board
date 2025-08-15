package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CoachViewPlayerReportsController
{
    @javafx.fxml.FXML
    private TableView reportTable;
    @javafx.fxml.FXML
    private ComboBox playerNameComboBox;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableColumn additionalInformationColumn;
    @javafx.fxml.FXML
    private TableColumn valueColumn;
    @javafx.fxml.FXML
    private ComboBox matchTypeComboBox;
    @javafx.fxml.FXML
    private Button loadReportButton;
    @javafx.fxml.FXML
    private TableColumn statTypeColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void returnOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Coach.fxml"));
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
    public void loadReportOnAction(ActionEvent actionEvent) {
    }
}