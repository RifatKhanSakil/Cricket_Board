package com.oop.group16.summer25_sec2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.Node;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    private ComboBox<String> userComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> users = new ArrayList<>();
        users.add("User1: Team Manager");
        users.add("User2: Inventory Manager");
        users.add("User3: HR Manager");
        users.add("User4: Account Manager");
        users.add("User5: Player");
        users.add("User6: Coach");
        users.add("User7: security control officer");
        users.add("User8: National Team Selector");
        users.add("User9: Ticket Buyer");
        users.add("User10: Sponsor");
        userComboBox.getItems().setAll(users);
        userComboBox.setOnAction(e -> onUserSelected());
    }

    @FXML
    public void onSubmit(ActionEvent event) {
        String selected = userComboBox.getSelectionModel().getSelectedItem();
        if (selected == null || selected.isBlank()) {
            showInfo("Select a user to continue.");
            return;
        }
        if (selected.contains("Ticket Buyer")) {
            open(event, "/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/MenuTicketBuyer.fxml", "Ticket Buyer Menu");
            return;
        }
        if (selected.contains("Sponsor")) {
            open(event, "/com/oop/group16/summer25_sec2/Ashik/Sponsor/MenuSponsor.fxml", "Sponsor Menu");
            return;
        }
        showInfo("Logged in as: " + selected);
    }

    private void onUserSelected() {
        // no-op on selection; use Submit to proceed
    }

    private void showInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Login");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void open(ActionEvent event, String resource, String title) {
        try {
            URL url = getClass().getResource(resource);
            if (url == null) {
                showError("View not found: " + resource);
                return;
            }
            Parent root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
            Node node = (Node) event.getSource();
            Stage current = (Stage) node.getScene().getWindow();
            if (current != null) current.close();
        } catch (Exception ex) {
            showError("Failed to open: " + title + "\n" + ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }
}