package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CoachFitnessReviewController
{
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TextArea remarkTextArea;
    @javafx.fxml.FXML
    private ComboBox selectPlayerComboBox;
    @javafx.fxml.FXML
    private TextArea SubmittedFitnessDataTextArea;

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
    public void rejectOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOnAction(ActionEvent actionEvent) {
    }
}