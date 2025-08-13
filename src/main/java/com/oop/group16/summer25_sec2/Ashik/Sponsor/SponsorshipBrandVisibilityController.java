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

public class SponsorshipBrandVisibilityController implements Initializable {
    @FXML
    private TextField sponsorNameField;
    @FXML
    private ComboBox<String> sponsorshipTypeCombo;
    @FXML
    private DatePicker agreementDatePicker;
    @FXML
    private RadioButton stadiumBrandingRadio;
    @FXML
    private RadioButton digitalAdsRadio;
    @FXML
    private RadioButton merchBrandingRadio;
    @FXML
    private TextField brandingSpaceField;
    @FXML
    private TextArea budgetProposalArea;
    @FXML
    private Button submitButton;
    @FXML
    private TableView<SponsorshipActivityItem> activityTable;
    @FXML
    private TableColumn<SponsorshipActivityItem, String> activityNameColumn;
    @FXML
    private TableColumn<SponsorshipActivityItem, String> activityDateColumn;
    @FXML
    private TableColumn<SponsorshipActivityItem, String> statusColumn;
    @FXML
    private TableColumn<SponsorshipActivityItem, String> notesColumn;
    @FXML
    private Button backMenuButton;

    private final ArrayList<SponsorshipActivityItem> activities = new ArrayList<>();
    private ToggleGroup brandingToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activityNameColumn.setCellValueFactory(new PropertyValueFactory<>("activityName"));
        activityDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        brandingToggleGroup = new ToggleGroup();
        stadiumBrandingRadio.setToggleGroup(brandingToggleGroup);
        digitalAdsRadio.setToggleGroup(brandingToggleGroup);
        merchBrandingRadio.setToggleGroup(brandingToggleGroup);
        stadiumBrandingRadio.setSelected(true);
        sponsorshipTypeCombo.getItems().setAll("Title Sponsor", "Associate Sponsor", "Official Partner");
        agreementDatePicker.setValue(LocalDate.now());
        activityTable.getItems().setAll(activities);
    }

    @FXML
    private void onSubmitRequest(ActionEvent event) {
        String sponsor = valueOrEmpty(sponsorNameField.getText());
        String type = sponsorshipTypeCombo.getSelectionModel().getSelectedItem();
        String space = valueOrEmpty(brandingSpaceField.getText());
        String budget = valueOrEmpty(budgetProposalArea.getText());
        if (sponsor.isEmpty() || type == null || type.isEmpty()) return;
        String pref = brandingPreference();
        String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String notes = pref + " | " + space + " | " + shortText(budget, 40);
        activities.add(new SponsorshipActivityItem(sponsor + " - " + type, date, "Pending", notes));
        activityTable.getItems().setAll(activities);
        sponsorNameField.clear();
        brandingSpaceField.clear();
        budgetProposalArea.clear();
        sponsorshipTypeCombo.getSelectionModel().clearSelection();
        stadiumBrandingRadio.setSelected(true);
        agreementDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void onBackToMenu(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private String brandingPreference() {
        if (digitalAdsRadio.isSelected()) return "Digital Advertisement";
        if (merchBrandingRadio.isSelected()) return "Merchandise Branding";
        return "Stadium Branding";
    }

    private String valueOrEmpty(String s) {
        return s == null ? "" : s.trim();
    }

    private String shortText(String s, int max) {
        String t = valueOrEmpty(s);
        return t.length() > max ? t.substring(0, max) + "..." : t;
    }
}
