package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

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

public class FeedBackSubmissionController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> matchComboBox;
    @FXML
    private DatePicker matchDatePicker;
    @FXML
    private RadioButton excellentRadio;
    @FXML
    private RadioButton goodRadio;
    @FXML
    private RadioButton averageRadio;
    @FXML
    private RadioButton poorRadio;
    @FXML
    private TextField titleField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private Button submitButton;
    @FXML
    private Button backMenuButton;
    @FXML
    private Button backAccountButton;
    @FXML
    private TableView<ComplaintStatusItem> complaintTable;
    @FXML
    private TableColumn<ComplaintStatusItem, String> ticketIdColumn;
    @FXML
    private TableColumn<ComplaintStatusItem, String> dateSubmittedColumn;
    @FXML
    private TableColumn<ComplaintStatusItem, String> statusColumn;
    @FXML
    private TableColumn<ComplaintStatusItem, String> responseSummaryColumn;

    private final ArrayList<ComplaintStatusItem> complaints = new ArrayList<>();
    private final ArrayList<String> matches = new ArrayList<>();
    private ToggleGroup ratingGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ticketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        dateSubmittedColumn.setCellValueFactory(new PropertyValueFactory<>("dateSubmitted"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        responseSummaryColumn.setCellValueFactory(new PropertyValueFactory<>("responseSummary"));
        ratingGroup = new ToggleGroup();
        excellentRadio.setToggleGroup(ratingGroup);
        goodRadio.setToggleGroup(ratingGroup);
        averageRadio.setToggleGroup(ratingGroup);
        poorRadio.setToggleGroup(ratingGroup);
        goodRadio.setSelected(true);
        matches.add("Team A vs Team B");
        matches.add("Team C vs Team D");
        matches.add("Team E vs Team F");
        matchComboBox.getItems().setAll(matches);
        matchDatePicker.setValue(LocalDate.now());
        seedComplaints();
        complaintTable.getItems().setAll(complaints);
    }

    @FXML
    private void onSubmitFeedback(ActionEvent event) {
        String name = valueOrEmpty(nameField.getText());
        String match = matchComboBox.getSelectionModel().getSelectedItem();
        String title = valueOrEmpty(titleField.getText());
        String details = valueOrEmpty(detailsArea.getText());
        if (title.isEmpty()) return;
        String rating = selectedRating();
        String id = "C-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        String date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String status = "Pending";
        String summary = buildSummary(name, match, rating, title, details);
        complaints.add(new ComplaintStatusItem(id, date, status, summary));
        complaintTable.getItems().setAll(complaints);
        nameField.clear();
        titleField.clear();
        detailsArea.clear();
        matchComboBox.getSelectionModel().clearSelection();
        matchDatePicker.setValue(LocalDate.now());
        goodRadio.setSelected(true);
    }

    @FXML
    private void onBackToMenu(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    @FXML
    private void onBackToAccount(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private String selectedRating() {
        if (excellentRadio.isSelected()) return "Excellent";
        if (goodRadio.isSelected()) return "Good";
        if (averageRadio.isSelected()) return "Average";
        if (poorRadio.isSelected()) return "Poor";
        return "Good";
    }

    private String valueOrEmpty(String s) {
        return s == null ? "" : s.trim();
    }

    private String buildSummary(String name, String match, String rating, String title, String details) {
        String d = details == null ? "" : details;
        String shortDetails = d.length() > 40 ? d.substring(0, 40) + "..." : d;
        String m = match == null ? "" : match;
        String n = name == null ? "" : name;
        return n + " " + m + " " + rating + " | " + title + " | " + shortDetails;
    }

    private void seedComplaints() {
        String today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        complaints.add(new ComplaintStatusItem("C-0001", today, "In Review", "Good Team A vs Team B | Entry delay | Security queue slow"));
        complaints.add(new ComplaintStatusItem("C-0002", today, "Resolved", "Average Team C vs Team D | Seat issue | Moved to Row B"));
    }
}