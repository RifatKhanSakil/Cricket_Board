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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MatchScheduleController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private TableView<MatchScheduleItem> matchesTable;
    @FXML
    private TableColumn<MatchScheduleItem, String> dateColumn;
    @FXML
    private TableColumn<MatchScheduleItem, String> teamsColumn;
    @FXML
    private TableColumn<MatchScheduleItem, String> venueColumn;
    @FXML
    private TableColumn<MatchScheduleItem, String> timeColumn;
    @FXML
    private Button setReminderButton;
    @FXML
    private Button downloadFixtureButton;
    @FXML
    private ListView<MatchScheduleItem> remindersListView;
    @FXML
    private Label alertsLabel;
    @FXML
    private Button backButton;

    private final ArrayList<MatchScheduleItem> matches = new ArrayList<>();
    private final ArrayList<MatchScheduleItem> reminders = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
        teamsColumn.setCellValueFactory(new PropertyValueFactory<>("teams"));
        venueColumn.setCellValueFactory(new PropertyValueFactory<>("venue"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        remindersListView.setCellFactory(lv -> new ListCell<MatchScheduleItem>() {
            @Override
            protected void updateItem(MatchScheduleItem item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.toString());
            }
        });

        matchesTable.getItems().setAll(matches);
        alertsLabel.setText("Alerts: No alerts");
    }

    private void seedData() {
        LocalDate today = LocalDate.now();
        matches.add(new MatchScheduleItem(today.plusDays(1).toString(), "Team A vs Team B", "Stadium Alpha", "18:00"));
        matches.add(new MatchScheduleItem(today.plusDays(3).toString(), "Team C vs Team D", "Stadium Beta", "20:00"));
        matches.add(new MatchScheduleItem(today.plusDays(5).toString(), "Team E vs Team F", "Stadium Gamma", "17:30"));
        matches.add(new MatchScheduleItem(today.plusDays(7).toString(), "Team G vs Team H", "Stadium Delta", "19:45"));
    }

    @FXML
    private void onSetReminder(ActionEvent event) {
        MatchScheduleItem selected = matchesTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        boolean exists = false;
        for (MatchScheduleItem m : reminders) {
            if (m.getMatchDate().equals(selected.getMatchDate()) && m.getTeams().equals(selected.getTeams())) {
                exists = true;
                break;
            }
        }
        if (!exists) reminders.add(selected);
        remindersListView.getItems().setAll(reminders);
        alertsLabel.setText("Alerts: Reminder set for " + selected.getTeams() + " on " + selected.getMatchDate() + " at " + selected.getTime());
    }

    @FXML
    private void onDownloadFixture(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Fixture");
        fc.setInitialFileName("fixture.ics");
        java.io.File f = fc.showSaveDialog(stage);
        if (f == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append("BEGIN:VCALENDAR\n");
        sb.append("VERSION:2.0\n");
        sb.append("PRODID:-//MatchSchedule//EN\n");
        for (MatchScheduleItem m : matches) {
            sb.append("BEGIN:VEVENT\n");
            sb.append("SUMMARY:").append(m.getTeams()).append("\\n");
            sb.append("LOCATION:").append(m.getVenue()).append("\\n");
            sb.append("DESCRIPTION:").append("Match at ").append(m.getTime()).append("\\n");
            sb.append("DTSTART;VALUE=DATE:").append(m.getMatchDate().replace("-", "")).append("\\n");
            sb.append("END:VEVENT\n");
        }
        sb.append("END:VCALENDAR\n");
        try {
            java.nio.file.Files.writeString(f.toPath(), sb.toString());
            alertsLabel.setText("Alerts: Fixture downloaded");
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void onBackToHome(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }
}