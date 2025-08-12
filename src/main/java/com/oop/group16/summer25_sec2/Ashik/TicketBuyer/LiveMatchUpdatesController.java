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

public class LiveMatchUpdatesController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private ComboBox<String> matchComboBox;
    @FXML
    private TextField searchField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private RadioButton scoreboardRadio;
    @FXML
    private RadioButton playerStatsRadio;
    @FXML
    private TableView<MatchEvent> eventsTable;
    @FXML
    private TableColumn<MatchEvent, String> timeColumn;
    @FXML
    private TableColumn<MatchEvent, String> eventTypeColumn;
    @FXML
    private TableColumn<MatchEvent, String> playerNameColumn;
    @FXML
    private TableColumn<MatchEvent, String> teamColumn;
    @FXML
    private Button refreshButton;
    @FXML
    private Button backButton;

    private final ArrayList<MatchEvent> allEvents = new ArrayList<>();
    private final ArrayList<String> availableMatches = new ArrayList<>();
    private ToggleGroup viewToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        eventTypeColumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));

        viewToggleGroup = new ToggleGroup();
        scoreboardRadio.setToggleGroup(viewToggleGroup);
        playerStatsRadio.setToggleGroup(viewToggleGroup);
        scoreboardRadio.setSelected(true);

        availableMatches.add("Team A vs Team B");
        availableMatches.add("Team C vs Team D");
        availableMatches.add("Team E vs Team F");
        matchComboBox.getItems().setAll(availableMatches);

        datePicker.setValue(LocalDate.now());

        searchField.textProperty().addListener((o, ov, nv) -> applyFilters());
        matchComboBox.setOnAction(e -> refreshData());
        datePicker.setOnAction(e -> refreshData());
        scoreboardRadio.setOnAction(e -> applyFilters());
        playerStatsRadio.setOnAction(e -> applyFilters());

        refreshData();
    }

    @FXML
    private void onRefreshUpdates(ActionEvent event) {
        refreshData();
    }

    @FXML
    private void onBackToMenu(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private void refreshData() {
        allEvents.clear();
        eventsTable.getItems().clear();
        applyFilters();
    }

    private void applyFilters() {
        String q = searchField.getText();
        if (q == null) q = "";
        String s = q.toLowerCase();
        ArrayList<MatchEvent> filtered = new ArrayList<>();
        for (MatchEvent e : allEvents) {
            if ((e.getTime() != null && e.getTime().toLowerCase().contains(s)) ||
                    (e.getEventType() != null && e.getEventType().toLowerCase().contains(s)) ||
                    (e.getPlayerName() != null && e.getPlayerName().toLowerCase().contains(s)) ||
                    (e.getTeam() != null && e.getTeam().toLowerCase().contains(s))) {
                filtered.add(e);
            }
        }
        eventsTable.getItems().setAll(filtered);
    }
}