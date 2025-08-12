package com.oop.group16.summer25_sec2.Ashik.Sponsor;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SponsorshipAmountController implements Initializable {
    @FXML
    private TextField orgNameField;
    @FXML
    private ComboBox<String> tourDestinationCombo;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private RadioButton fullFundingRadio;
    @FXML
    private RadioButton partialFundingRadio;
    @FXML
    private RadioButton marketingOnlyRadio;
    @FXML
    private TextField amountField;
    @FXML
    private TextArea proposalDetailsArea;
    @FXML
    private Button submitButton;
    @FXML
    private TableView<TourSponsorshipItem> trackerTable;
    @FXML
    private TableColumn<TourSponsorshipItem, String> tourNameColumn;
    @FXML
    private TableColumn<TourSponsorshipItem, String> proposalDateColumn;
    @FXML
    private TableColumn<TourSponsorshipItem, String> statusColumn;
    @FXML
    private TableColumn<TourSponsorshipItem, String> notesColumn;
    @FXML
    private Button backButton;

    private final ArrayList<TourSponsorshipItem> items = new ArrayList<>();
    private ToggleGroup focusToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tourNameColumn.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        proposalDateColumn.setCellValueFactory(new PropertyValueFactory<>("proposalDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        focusToggleGroup = new ToggleGroup();
        fullFundingRadio.setToggleGroup(focusToggleGroup);
        partialFundingRadio.setToggleGroup(focusToggleGroup);
        marketingOnlyRadio.setToggleGroup(focusToggleGroup);
        fullFundingRadio.setSelected(true);
        tourDestinationCombo.getItems().setAll("Australia", "England", "South Africa", "India", "New Zealand");
        startDatePicker.setValue(LocalDate.now());
        trackerTable.getItems().setAll(items);
    }

    @FXML
    private void onSubmitProposal(ActionEvent e) {
        String org = valueOrEmpty(orgNameField.getText());
        String dest = tourDestinationCombo.getSelectionModel().getSelectedItem();
        String amount = valueOrEmpty(amountField.getText());
        String details = valueOrEmpty(proposalDetailsArea.getText());
        if (org.isEmpty() || dest == null || dest.isEmpty()) return;
        String tourName = org + " - " + dest;
        String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String focus = focusText();
        String notes = focus + " | Amount: " + amount + " | " + shortText(details, 40);
        items.add(new TourSponsorshipItem(tourName, date, "Pending", notes));
        trackerTable.getItems().setAll(items);
        orgNameField.clear();
        amountField.clear();
        proposalDetailsArea.clear();
        tourDestinationCombo.getSelectionModel().clearSelection();
        fullFundingRadio.setSelected(true);
        startDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void onBackToMenu(ActionEvent e) {
        Node n = (Node) e.getSource();
        Stage s = (Stage) n.getScene().getWindow();
        if (s != null) s.close();
    }

    private String focusText() {
        if (partialFundingRadio.isSelected()) return "Partial Funding";
        if (marketingOnlyRadio.isSelected()) return "Marketing Support Only";
        return "Full Tour Funding";
    }

    private String valueOrEmpty(String s) {
        return s == null ? "" : s.trim();
    }

    private String shortText(String s, int max) {
        String t = valueOrEmpty(s);
        return t.length() > max ? t.substring(0, max) + "..." : t;
    }
}
