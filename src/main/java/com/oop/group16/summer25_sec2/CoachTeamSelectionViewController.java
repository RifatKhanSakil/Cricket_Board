package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CoachTeamSelectionViewController
{
    @javafx.fxml.FXML
    private ListView availablePlayersListView;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TextArea selectTeamTextArea;
    @javafx.fxml.FXML
    private Label SelectedTeamLabel;

    @javafx.fxml.FXML
    public void initialize() {
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

    @javafx.fxml.FXML
    public void confirmTeamOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportTeamOnAction(ActionEvent actionEvent) {
    }
}