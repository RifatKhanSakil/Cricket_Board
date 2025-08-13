package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;

import java.time.LocalDate;

public class EasyTicketPurchaseController {

    @FXML
    private Label titleLabel;
    @FXML
    private ComboBox<String> eventComboBox;
    @FXML
    private TextField buyerInputField;
    @FXML
    private ToggleGroup ticketTypeGroup;
    @FXML
    private RadioButton regularRadio;
    @FXML
    private RadioButton vipRadio;
    @FXML
    private DatePicker matchDatePicker;

    @FXML
    private TableView<Seat> seatsTable;
    @FXML
    private TableColumn<Seat, String> seatNumberColumn;
    @FXML
    private TableColumn<Seat, String> sectionColumn;
    @FXML
    private TableColumn<Seat, Number> priceColumn;
    @FXML
    private TableColumn<Seat, String> availabilityColumn;

    private final ObservableList<Seat> seatData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        availabilityColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(
                cell.getValue().isAvailable() ? "Available" : "Sold"
        ));

        eventComboBox.setItems(FXCollections.observableArrayList(
                "Match A: Team X vs Team Y",
                "Match B: Team Z vs Team W",
                "Concert: Star Live"
        ));

        seatData.clear();
        seatsTable.setItems(seatData);

        regularRadio.setSelected(true);
        matchDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void handleProceedToPayment(ActionEvent event) {
        String selectedEvent = eventComboBox.getSelectionModel().getSelectedItem();
        LocalDate date = matchDatePicker.getValue();
        String buyer = buyerInputField.getText() == null ? "" : buyerInputField.getText().trim();
        String ticketType = ((RadioButton) ticketTypeGroup.getSelectedToggle()).getText();

        if (selectedEvent == null || selectedEvent.isBlank()) {
            showAlert(Alert.AlertType.WARNING, "Please select a match or event.");
            return;
        }
        if (date == null) {
            showAlert(Alert.AlertType.WARNING, "Please select a match date.");
            return;
        }
        if (buyer.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please enter buyer name or number of tickets.");
            return;
        }

        Seat selectedSeat = seatsTable.getSelectionModel().getSelectedItem();
        if (selectedSeat == null) {
            showAlert(Alert.AlertType.INFORMATION, "No seat selected. Proceeding without seat selection.");
        }

        String summary = String.format(
                "Event: %s\nDate: %s\nBuyer/Count: %s\nType: %s\nSeat: %s",
                selectedEvent,
                date,
                buyer,
                ticketType,
                selectedSeat != null ? selectedSeat.getSeatNumber() : "(none)"
        );
        showAlert(Alert.AlertType.INFORMATION, "Proceeding to payment...\n\n" + summary);
    }

    @FXML
    private void handleBackToEvents(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Back to events triggered.");
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Ticket Purchase");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
