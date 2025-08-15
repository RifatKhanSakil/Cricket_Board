package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CoachSeasonStatsViewController
{
    @javafx.fxml.FXML
    private TableView tableTableView;
    @javafx.fxml.FXML
    private TableColumn valueTableColumn;
    @javafx.fxml.FXML
    private TableColumn additionalInformationTableColumn;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private ChoiceBox saveReportChoiceBox;
    @javafx.fxml.FXML
    private TableColumn metricTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveReportOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadDataButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void returnOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Coach.fxml"));
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