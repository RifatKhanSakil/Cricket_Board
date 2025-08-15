package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SeatAvailabilityController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private ComboBox<String> matchComboBox;
    @FXML
    private TextField searchField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private RadioButton allSeatsRadio;
    @FXML
    private RadioButton availableOnlyRadio;
    @FXML
    private TableView<SeatAvailabilityItem> seatsTable;
    @FXML
    private TableColumn<SeatAvailabilityItem, String> seatNumberColumn;
    @FXML
    private TableColumn<SeatAvailabilityItem, String> blockRowColumn;
    @FXML
    private TableColumn<SeatAvailabilityItem, Number> priceColumn;
    @FXML
    private TableColumn<SeatAvailabilityItem, String> availabilityColumn;
    @FXML
    private Button addToWaitlistButton;
    @FXML
    private Button backButton;

    private final ArrayList<SeatAvailabilityItem> allSeats = new ArrayList<>();
    private final ArrayList<String> availableMatches = new ArrayList<>();
    private ToggleGroup viewToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        blockRowColumn.setCellValueFactory(new PropertyValueFactory<>("blockRow"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        viewToggleGroup = new ToggleGroup();
        allSeatsRadio.setToggleGroup(viewToggleGroup);
        availableOnlyRadio.setToggleGroup(viewToggleGroup);
        allSeatsRadio.setSelected(true);

        availableMatches.add("Team A vs Team B");
        availableMatches.add("Team C vs Team D");
        availableMatches.add("Team E vs Team F");
        matchComboBox.getItems().setAll(availableMatches);

        datePicker.setValue(LocalDate.now());

        searchField.textProperty().addListener((o, ov, nv) -> applyFilters());
        matchComboBox.setOnAction(e -> refreshData());
        datePicker.setOnAction(e -> refreshData());
        allSeatsRadio.setOnAction(e -> applyFilters());
        availableOnlyRadio.setOnAction(e -> applyFilters());

        refreshData();
    }

    @FXML
    private void onAddToWaitlist(ActionEvent event) {
        SeatAvailabilityItem sel = seatsTable.getSelectionModel().getSelectedItem();
        if (sel != null) {
            if (!"Available".equalsIgnoreCase(sel.getAvailability())) {
                sel.setAvailability("Waitlist");
            } else {
                // If it was available, keep it but mark as waitlisted
                sel.setAvailability("Waitlist");
            }
            // Ensure the updated row remains visible by switching to "All Seats"
            allSeatsRadio.setSelected(true);
            applyFilters();
        }
    }

    @FXML
    private void onBackToMenu(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private void refreshData() {
        allSeats.clear();
        seatsTable.getItems().clear();

        String selectedMatch = matchComboBox.getValue();
        if (selectedMatch == null && !availableMatches.isEmpty()) {
            selectedMatch = availableMatches.get(0);
            matchComboBox.getSelectionModel().select(0);
        }

        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate == null) {
            selectedDate = LocalDate.now();
            datePicker.setValue(selectedDate);
        }

        // Populate mock data based on selected match and date so the table is not empty
        // In a real app, replace this with a service/database call
        String block = selectedMatch == null ? "Block" : selectedMatch.split(" ")[0];
        for (int i = 1; i <= 10; i++) {
            String seatNo = "A" + i;
            String blockRow = block + "/R" + ((i - 1) / 5 + 1);
            double price = 50 + i * 5;
            String availability = (i % 3 == 0) ? "Booked" : "Available";
            allSeats.add(new SeatAvailabilityItem(seatNo, blockRow, price, availability));
        }

        applyFilters();
    }

    private void applyFilters() {
        String q = searchField.getText();
        if (q == null) q = "";
        String s = q.toLowerCase();
        boolean onlyAvailable = availableOnlyRadio.isSelected();
        ArrayList<SeatAvailabilityItem> filtered = new ArrayList<>();
        for (SeatAvailabilityItem item : allSeats) {
            if (onlyAvailable && !"Available".equalsIgnoreCase(item.getAvailability())) continue;
            boolean matches = false;
            if (item.getSeatNumber() != null && item.getSeatNumber().toLowerCase().contains(s)) matches = true;
            if (!matches && item.getBlockRow() != null && item.getBlockRow().toLowerCase().contains(s)) matches = true;
            if (!matches && item.getAvailability() != null && item.getAvailability().toLowerCase().contains(s))
                matches = true;
            if (matches) filtered.add(item);
        }
        seatsTable.getItems().setAll(filtered);
    }
}