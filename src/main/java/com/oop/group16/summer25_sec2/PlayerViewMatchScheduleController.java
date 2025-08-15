package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerViewMatchScheduleController
{
    @javafx.fxml.FXML
    private TableView matchTable;
    @javafx.fxml.FXML
    private TextField dateRangeField;
    @javafx.fxml.FXML
    private TableColumn opponentColumn;
    @javafx.fxml.FXML
    private TableColumn matchDateColumn;
    @javafx.fxml.FXML
    private TableColumn venueColumn;
    @javafx.fxml.FXML
    private TableColumn matchTypeColumn;
    @javafx.fxml.FXML
    private Label titleLabel;

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
    public void loadScheduleOnAction(ActionEvent actionEvent) {
    }
}