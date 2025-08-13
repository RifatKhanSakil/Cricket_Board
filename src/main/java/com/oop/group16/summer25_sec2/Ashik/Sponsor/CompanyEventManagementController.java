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

public class CompanyEventManagementController implements Initializable {
    @FXML
    private TextField orgNameField;
    @FXML
    private ComboBox<String> eventTypeCombo;
    @FXML
    private DatePicker eventDatePicker;
    @FXML
    private RadioButton venueStadiumRadio;
    @FXML
    private RadioButton venueHotelRadio;
    @FXML
    private RadioButton venueOutdoorRadio;
    @FXML
    private TextField budgetField;
    @FXML
    private TextArea proposalDetailsArea;
    @FXML
    private Button submitButton;
    @FXML
    private TableView<FanEventItem> eventTable;
    @FXML
    private TableColumn<FanEventItem, String> eventNameColumn;
    @FXML
    private TableColumn<FanEventItem, String> proposalDateColumn;
    @FXML
    private TableColumn<FanEventItem, String> statusColumn;
    @FXML
    private TableColumn<FanEventItem, String> feedbackColumn;
    @FXML
    private Button backButton;

    private final ArrayList<FanEventItem> items = new ArrayList<>();
    private ToggleGroup venueToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        proposalDateColumn.setCellValueFactory(new PropertyValueFactory<>("proposalDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        feedbackColumn.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        venueToggleGroup = new ToggleGroup();
        venueStadiumRadio.setToggleGroup(venueToggleGroup);
        venueHotelRadio.setToggleGroup(venueToggleGroup);
        venueOutdoorRadio.setToggleGroup(venueToggleGroup);
        venueStadiumRadio.setSelected(true);
        eventTypeCombo.getItems().setAll("Fan Meetup", "Autograph Session", "Live Screening");
        eventDatePicker.setValue(LocalDate.now());
        eventTable.getItems().setAll(items);
    }

    @FXML
    private void onSubmitProposal(ActionEvent e) {
        String org = valueOrEmpty(orgNameField.getText());
        String type = eventTypeCombo.getSelectionModel().getSelectedItem();
        String budget = valueOrEmpty(budgetField.getText());
        String details = valueOrEmpty(proposalDetailsArea.getText());
        if (org.isEmpty() || type == null || type.isEmpty()) return;
        String eventName = org + " - " + type;
        String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String venue = venueText();
        String feedback = venue + " | Budget: " + budget + " | " + shortText(details, 40);
        items.add(new FanEventItem(eventName, date, "Pending", feedback));
        eventTable.getItems().setAll(items);
        orgNameField.clear();
        budgetField.clear();
        proposalDetailsArea.clear();
        eventTypeCombo.getSelectionModel().clearSelection();
        venueStadiumRadio.setSelected(true);
        eventDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void onBackToMenu(ActionEvent e) {
        Node n = (Node) e.getSource();
        Stage s = (Stage) n.getScene().getWindow();
        if (s != null) s.close();
    }

    private String venueText() {
        if (venueHotelRadio.isSelected()) return "Hotel/Convention Hall";
        if (venueOutdoorRadio.isSelected()) return "Outdoor Park";
        return "Stadium";
    }

    private String valueOrEmpty(String s) {
        return s == null ? "" : s.trim();
    }

    private String shortText(String s, int max) {
        String t = valueOrEmpty(s);
        return t.length() > max ? t.substring(0, max) + "..." : t;
    }
}
