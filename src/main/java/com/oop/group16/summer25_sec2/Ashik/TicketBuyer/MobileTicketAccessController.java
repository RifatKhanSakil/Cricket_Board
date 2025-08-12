package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MobileTicketAccessController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private ListView<MobileTicket> ticketsListView;
    @FXML
    private Button downloadButton;
    @FXML
    private Button addToWalletButton;
    @FXML
    private javafx.scene.image.ImageView qrImageView;
    @FXML
    private Label qrNoteLabel;
    @FXML
    private Button shareButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ToggleButton notificationsToggle;
    @FXML
    private Button backButton;

    private final ArrayList<MobileTicket> tickets = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tickets.add(new MobileTicket("T-001", "Team A vs Team B", LocalDate.now().plusDays(1), "Block 1 Row A Seat 12"));
        tickets.add(new MobileTicket("T-002", "Team C vs Team D", LocalDate.now().plusDays(3), "Block 2 Row B Seat 7"));
        tickets.add(new MobileTicket("T-003", "Team E vs Team F", LocalDate.now().plusDays(5), "Block 3 Row C Seat 4"));
        ticketsListView.getItems().setAll(tickets);
        ticketsListView.setCellFactory(lv -> new ListCell<MobileTicket>() {
            @Override
            protected void updateItem(MobileTicket item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getMatchName() + " | " + item.getDate() + " | " + item.getSeatInfo());
            }
        });
        ticketsListView.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> updateQr(nv));
        if (!tickets.isEmpty()) ticketsListView.getSelectionModel().selectFirst();
        notificationsToggle.setSelected(false);
        updateNotificationsText();
    }

    @FXML
    private void onDownloadTicket(ActionEvent event) {
        MobileTicket t = ticketsListView.getSelectionModel().getSelectedItem();
        if (t == null) return;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Ticket");
        fc.setInitialFileName(t.getId() + ".txt");
        java.io.File f = fc.showSaveDialog(stage);
        if (f == null) return;
        String content = "Ticket ID: " + t.getId() + System.lineSeparator() +
                "Match: " + t.getMatchName() + System.lineSeparator() +
                "Date: " + t.getDate() + System.lineSeparator() +
                "Seat: " + t.getSeatInfo() + System.lineSeparator();
        try {
            java.nio.file.Files.writeString(f.toPath(), content);
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void onAddToWallet(ActionEvent event) {
    }

    @FXML
    private void onShareTicket(ActionEvent event) {
    }

    @FXML
    private void onDeleteTicket(ActionEvent event) {
        MobileTicket t = ticketsListView.getSelectionModel().getSelectedItem();
        if (t == null) return;
        tickets.remove(t);
        ticketsListView.getItems().setAll(tickets);
        if (!tickets.isEmpty()) ticketsListView.getSelectionModel().selectFirst();
        else qrImageView.setImage(null);
    }

    @FXML
    private void onToggleNotifications(ActionEvent event) {
        updateNotificationsText();
    }

    @FXML
    private void onBackToHome(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }

    private void updateNotificationsText() {
        notificationsToggle.setText("Match Start Notifications: " + (notificationsToggle.isSelected() ? "On" : "Off"));
    }

    private void updateQr(MobileTicket t) {
        if (t == null) {
            qrImageView.setImage(null);
            return;
        }
        String seed = t.getId() + "|" + t.getMatchName() + "|" + t.getDate() + "|" + t.getSeatInfo();
        qrImageView.setImage(generatePatternImage(seed, 180, 180, 24));
    }

    private WritableImage generatePatternImage(String seed, int width, int height, int cells) {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw = img.getPixelWriter();
        Random r = new Random(seed.hashCode());
        int cw = Math.max(1, width / cells);
        int ch = Math.max(1, height / cells);
        for (int y = 0; y < cells; y++) {
            for (int x = 0; x < cells; x++) {
                boolean on = r.nextBoolean();
                Color c = on ? Color.BLACK : Color.WHITE;
                int sx = x * cw;
                int sy = y * ch;
                int ex = Math.min(width, sx + cw);
                int ey = Math.min(height, sy + ch);
                for (int py = sy; py < ey; py++) {
                    for (int px = sx; px < ex; px++) {
                        pw.setColor(px, py, c);
                    }
                }
            }
        }
        return img;
    }
}