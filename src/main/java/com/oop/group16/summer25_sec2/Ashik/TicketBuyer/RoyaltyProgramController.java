package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RoyaltyProgramController implements Initializable {
    @FXML
    private Button joinButton;
    @FXML
    private TableView<RewardSummary> summaryTable;
    @FXML
    private TableColumn<RewardSummary, Number> pointsEarnedColumn;
    @FXML
    private TableColumn<RewardSummary, Number> pointsRedeemedColumn;
    @FXML
    private TableColumn<RewardSummary, Number> currentBalanceColumn;
    @FXML
    private TextField couponField;
    @FXML
    private Button redeemButton;
    @FXML
    private TableView<RewardHistoryItem> historyTable;
    @FXML
    private TableColumn<RewardHistoryItem, String> dateColumn;
    @FXML
    private TableColumn<RewardHistoryItem, String> actionColumn;
    @FXML
    private TableColumn<RewardHistoryItem, Number> pointsColumn;
    @FXML
    private TableColumn<RewardHistoryItem, String> descriptionColumn;
    @FXML
    private Button backButton;

    private final ArrayList<RewardSummary> summaryData = new ArrayList<>();
    private final ArrayList<RewardHistoryItem> historyData = new ArrayList<>();
    private boolean joined = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pointsEarnedColumn.setCellValueFactory(new PropertyValueFactory<>("pointsEarned"));
        pointsRedeemedColumn.setCellValueFactory(new PropertyValueFactory<>("pointsRedeemed"));
        currentBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        summaryData.clear();
        summaryTable.getItems().setAll(summaryData);
        historyData.clear();
        historyTable.getItems().setAll(historyData);
        updateJoinButton();
    }

    @FXML
    private void onJoinProgram(ActionEvent event) {
    }

    @FXML
    private void onRedeem(ActionEvent event) {

    }

    @FXML
    private void onBackToAccount(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private void addHistory() {

    }

    private void updateJoinButton() {
        joinButton.setDisable(joined);
        joinButton.setText(joined ? "Enrolled" : "Join Rewards Program");
    }
}