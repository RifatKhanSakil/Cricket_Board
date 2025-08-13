package com.oop.group16.summer25_sec2.Ashik.Sponsor;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PromoteProductLaunchesController implements Initializable {
    @FXML
    private TextArea notesArea;
    @FXML
    private TableView<PromoteEventItem> workflowTable;
    @FXML
    private TableColumn<PromoteEventItem, String> eventNameColumn;
    @FXML
    private TableColumn<PromoteEventItem, String> stageColumn;
    @FXML
    private TableColumn<PromoteEventItem, String> statusColumn;
    @FXML
    private TableColumn<PromoteEventItem, String> notesColumn;
    @FXML
    private Button backButton;

    private final ArrayList<PromoteEventItem> items = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        stageColumn.setCellValueFactory(new PropertyValueFactory<>("stage"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        workflowTable.getItems().setAll(items);
    }

    @FXML
    private void onSchedulePromo(ActionEvent e) {
        addItem("Schedule Product Promo at Match", "REQ");
    }

    @FXML
    private void onDistributeMerch(ActionEvent e) {
        addItem("Distribute Branded Merchandise", "ACT");
    }

    @FXML
    private void onAnalyzeEngagement(ActionEvent e) {
        addItem("Analyze Fan Engagement Reports", "INF");
    }

    @FXML
    private void onEvaluateROI(ActionEvent e) {
        addItem("Evaluate ROI on Product Campaign", "DEC");
    }

    @FXML
    private void onBackToMenu(ActionEvent e) {
        Node n = (Node) e.getSource();
        Stage s = (Stage) n.getScene().getWindow();
        if (s != null) s.close();
    }

    private void addItem(String name, String stage) {
        String notes = notesArea.getText() == null ? "" : notesArea.getText().trim();
        items.add(new PromoteEventItem(name, stage, "Pending", notes));
        workflowTable.getItems().setAll(items);
        notesArea.clear();
    }
}