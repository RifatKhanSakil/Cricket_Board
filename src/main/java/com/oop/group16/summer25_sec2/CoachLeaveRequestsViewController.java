package com.oop.group16.summer25_sec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CoachLeaveRequestsViewController
{
    @javafx.fxml.FXML
    private TextField remarkTextField;
    @javafx.fxml.FXML
    private TableColumn leaveDateTableColumn;
    @javafx.fxml.FXML
    private TableView tableTableView;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableColumn reasonTableColumn;
    @javafx.fxml.FXML
    private TextArea leaveDetailTextArea;
    @javafx.fxml.FXML
    private TableColumn platerNameTableColumn;

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