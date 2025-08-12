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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RefundTicketTransferController implements Initializable {
    @FXML
    private TextField ticketIdField;
    @FXML
    private DatePicker purchaseDatePicker;
    @FXML
    private RadioButton refundRadio;
    @FXML
    private RadioButton transferRadio;
    @FXML
    private TextField friendField;
    @FXML
    private Button submitButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<RefundTransferRecord> historyTable;
    @FXML
    private TableColumn<RefundTransferRecord, String> ticketIdColumn;
    @FXML
    private TableColumn<RefundTransferRecord, String> actionTypeColumn;
    @FXML
    private TableColumn<RefundTransferRecord, String> statusColumn;
    @FXML
    private TableColumn<RefundTransferRecord, String> dateProcessedColumn;

    private final ArrayList<RefundTransferRecord> history = new ArrayList<>();
    private ToggleGroup actionToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ticketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        actionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("actionType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateProcessedColumn.setCellValueFactory(new PropertyValueFactory<>("dateProcessed"));

        actionToggleGroup = new ToggleGroup();
        refundRadio.setToggleGroup(actionToggleGroup);
        transferRadio.setToggleGroup(actionToggleGroup);
        refundRadio.setSelected(true);
        friendField.setVisible(false);
        friendField.setManaged(false);

        refundRadio.setOnAction(e -> toggleFriendField());
        transferRadio.setOnAction(e -> toggleFriendField());

        seedHistory();
        historyTable.getItems().setAll(history);
    }

    private void toggleFriendField() {

    }

    @FXML
    private void onSubmitRequest(ActionEvent event) {
    }

    @FXML
    private void onBackToAccount(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private void seedHistory() {}
}