package com.oop.group16.summer25_sec2.Ashik.Sponsor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SponsorshipObjectivesController {
    @FXML
    private void onBackToMenu(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        if (stage != null) stage.close();
    }
}