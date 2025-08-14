package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    private final Random random = new Random();
    private final List<String> teamAPlayers = List.of("A. Smith", "B. Khan", "C. Lee", "D. Patel", "E. Das", "F. Roy");
    private final List<String> teamBPlayers = List.of("G. Silva", "H. Kumar", "I. Chen", "J. Ahmed", "K. Singh", "L. Brown");

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

        String match = matchComboBox.getValue();
        if (match == null || match.isBlank()) {
            if (!availableMatches.isEmpty()) {
                match = availableMatches.get(0);
                matchComboBox.setValue(match);
            }
        }

        generateRandomEvents(match);
        applyFilters();
    }

    private void applyFilters() {
        String q = searchField.getText();
        if (q == null) q = "";
        String s = q.toLowerCase();
        boolean showPlayerStatsOnly = playerStatsRadio.isSelected();
        ArrayList<MatchEvent> filtered = new ArrayList<>();
        for (MatchEvent e : allEvents) {
            boolean matchesSearch = (e.getTime() != null && e.getTime().toLowerCase().contains(s)) ||
                    (e.getEventType() != null && e.getEventType().toLowerCase().contains(s)) ||
                    (e.getPlayerName() != null && e.getPlayerName().toLowerCase().contains(s)) ||
                    (e.getTeam() != null && e.getTeam().toLowerCase().contains(s));
            if (!matchesSearch) continue;
            if (showPlayerStatsOnly) {
                // Keep only events tied to a specific player action
                if (e.getPlayerName() != null && !e.getPlayerName().isBlank()) {
                    filtered.add(e);
                }
            } else {
                filtered.add(e);
            }
        }
        eventsTable.getItems().setAll(filtered);
    }

    private void generateRandomEvents(String match) {
        // Basic running score simulation for both teams
        int runsA = 0, wicketsA = 0, ballsA = 0;
        int runsB = 0, wicketsB = 0, ballsB = 0;
        String teamA = "Team A";
        String teamB = "Team B";
        if (match != null) {
            String[] parts = match.split(" vs ");
            if (parts.length == 2) {
                teamA = parts[0].trim();
                teamB = parts[1].trim();
            }
        }

        int totalEvents = 15 + random.nextInt(6); // 15-20 events
        for (int i = 0; i < totalEvents; i++) {
            boolean isTeamA = random.nextBoolean();
            String team = isTeamA ? teamA : teamB;
            String player = isTeamA ? teamAPlayers.get(random.nextInt(teamAPlayers.size()))
                    : teamBPlayers.get(random.nextInt(teamBPlayers.size()));

            String eventType;
            int event = random.nextInt(10);
            if (event <= 3) { // singles/doubles/triples
                int r = 1 + random.nextInt(3);
                eventType = r + " run" + (r > 1 ? "s" : "");
                if (isTeamA) runsA += r;
                else runsB += r;
                if (isTeamA) ballsA++;
                else ballsB++;
            } else if (event == 4) { // four
                eventType = "FOUR";
                if (isTeamA) runsA += 4;
                else runsB += 4;
                if (isTeamA) ballsA++;
                else ballsB++;
            } else if (event == 5) { // six
                eventType = "SIX";
                if (isTeamA) runsA += 6;
                else runsB += 6;
                if (isTeamA) ballsA++;
                else ballsB++;
            } else if (event == 6) { // wide
                eventType = "WIDE";
                if (isTeamA) runsA += 1;
                else runsB += 1;
                // no ball count
            } else if (event == 7) { // no ball
                eventType = "NO BALL";
                if (isTeamA) runsA += 1;
                else runsB += 1;
            } else if (event == 8) { // wicket
                eventType = "WICKET";
                if (isTeamA) {
                    wicketsA = Math.min(10, wicketsA + 1);
                    ballsA++;
                } else {
                    wicketsB = Math.min(10, wicketsB + 1);
                    ballsB++;
                }
            } else { // dot ball
                eventType = "DOT";
                if (isTeamA) ballsA++;
                else ballsB++;
            }

            String time = formatOver(isTeamA ? ballsA : ballsB);
            allEvents.add(new MatchEvent(time, eventType, player, team));

            // Occasionally add a score update snapshot
            if (i % 3 == 2) {
                String scoreA = formatScore(runsA, wicketsA, ballsA);
                String scoreB = formatScore(runsB, wicketsB, ballsB);
                allEvents.add(new MatchEvent(time, "SCORE: " + teamA + " " + scoreA, "", teamA));
                allEvents.add(new MatchEvent(time, "SCORE: " + teamB + " " + scoreB, "", teamB));
            }
        }
    }

    private String formatOver(int balls) {
        int overs = balls / 6;
        int rem = balls % 6;
        return overs + "." + rem + " ov";
    }

    private String formatScore(int runs, int wickets, int balls) {
        int overs = balls / 6;
        int rem = balls % 6;
        return runs + "/" + wickets + " (" + overs + "." + rem + ")";
    }
}