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
    private TextField matchTextField;
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
    private ComboBox<String> priceComboBox;
    @FXML
    private ComboBox<String> seatTierComboBox;

    @FXML
    private TableView<Seat> seatsTable;
    @FXML
    private TableColumn<Seat, String> nameColumn;
    @FXML
    private TableColumn<Seat, String> sectionColumn;
    @FXML
    private TableColumn<Seat, Number> priceColumn;
    @FXML
    private TableColumn<Seat, String> availabilityColumn;

    private final ObservableList<Seat> seatData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        nameColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
        sectionColumn.setCellValueFactory(cell -> cell.getValue().sectionProperty());
        priceColumn.setCellValueFactory(cell -> cell.getValue().priceProperty());
        availabilityColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(
                cell.getValue().isAvailable() ? "Available" : "Sold"
        ));

        // Set up selectable tiers (up to 3)
        seatTierComboBox.setItems(FXCollections.observableArrayList(
                "Tier 1", "Tier 2", "Tier 3"
        ));
        // Map tier selection to price
        seatTierComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldTier, newTier) -> {
            updatePriceForTier(newTier);
        });

        seatData.clear();
        seatsTable.setItems(seatData);

        regularRadio.setSelected(true);
        matchDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void handleProceedToPayment(ActionEvent event) {
        String selectedMatch = matchTextField == null ? null : matchTextField.getText();
        LocalDate date = matchDatePicker.getValue();
        String buyer = buyerInputField.getText() == null ? "" : buyerInputField.getText().trim();
        String ticketType = ((RadioButton) ticketTypeGroup.getSelectedToggle()).getText();
        String tier = seatTierComboBox != null ? seatTierComboBox.getValue() : null;
        String priceText = priceComboBox != null ? priceComboBox.getValue() : null;

        if (selectedMatch == null || selectedMatch.isBlank()) {
            showAlert(Alert.AlertType.WARNING, "Please enter a match or event.");
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

        // Append current inputs as a new row in the table
        double price = parsePrice(priceText);
        Seat newRow = new Seat("", tier != null ? tier : "", price, true);
        newRow.setName(buyer);
        seatData.add(newRow);

        String header = String.format(
                "Event: %s\nDate: %s\nBuyer/Count: %s\nType: %s\nTier: %s\nPrice: %s",
                selectedMatch,
                date,
                buyer,
                ticketType,
                tier != null ? tier : "(none)",
                priceText != null ? priceText : "(none)"
        );
        String tableSummary = buildTableDataSummary();
        showAlert(Alert.AlertType.INFORMATION, header + "\n\nTable Data:\n" + tableSummary);

        // Reset the form for the next entry
        if (matchTextField != null) matchTextField.clear();
        if (buyerInputField != null) buyerInputField.clear();
        if (seatTierComboBox != null) seatTierComboBox.getSelectionModel().clearSelection();
        if (priceComboBox != null) {
            priceComboBox.getItems().clear();
            priceComboBox.setValue(null);
        }
        if (regularRadio != null) regularRadio.setSelected(true);
        if (matchDatePicker != null) matchDatePicker.setValue(LocalDate.now());
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

    private void updatePriceForTier(String tier) {
        if (priceComboBox == null) return;
        if (tier == null || tier.isBlank()) {
            priceComboBox.getItems().clear();
            priceComboBox.setValue(null);
            return;
        }
        String priceValue;
        switch (tier) {
            case "Tier 1":
                priceValue = "$50";
                break;
            case "Tier 2":
                priceValue = "$250";
                break;
            case "Tier 3":
                priceValue = "$1199";
                break;
            default:
                priceValue = null;
        }
        priceComboBox.getItems().setAll(priceValue);
        priceComboBox.setValue(priceValue);
        priceComboBox.setEditable(false);
    }

    private double parsePrice(String text) {
        if (text == null) return 0.0;
        String digits = text.replaceAll("[^0-9.]", "");
        if (digits.isEmpty()) return 0.0;
        try {
            return Double.parseDouble(digits);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private String buildTableDataSummary() {
        if (seatsTable == null || seatsTable.getItems() == null || seatsTable.getItems().isEmpty()) {
            return "(no rows)";
        }
        StringBuilder sb = new StringBuilder();
        for (Seat s : seatsTable.getItems()) {
            if (s == null) continue;
            String name = s.getName() != null ? s.getName() : "";
            String tier = s.getSection() != null ? s.getSection() : "";
            String price = String.format("$%.2f", s.getPrice());
            String status = s.isAvailable() ? "Available" : "Sold";
            sb.append(String.format("Name: %s, Tier: %s, Price: %s, Status: %s", name, tier, price, status)).append('\n');
        }
        return sb.toString().trim();
    }
}
