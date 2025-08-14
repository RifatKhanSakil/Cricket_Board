package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MenuTicketBuyerController {
    public void openEasyTicketPurchase(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/EasyTicketPurchase.fxml", "Easy Ticket Purchase");
    }

    public void openLiveMatchUpdates(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/LiveMatchUpdates.fxml", "Live Match Updates");
    }

    public void openSeatAvailability(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/SeatAvailability.fxml", "Seat Availability");
    }

    public void openMobileTicketAccess(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/MobileTicketAccess.fxml", "Mobile Ticket Access");
    }

    public void openMatchSchedule(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/MatchSchdule.fxml", "Match Schedule");
    }

    public void openRefundTicketTransfer(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/RefundTicketTransfer.fxml", "Refund & Ticket Transfer");
    }

    public void openRoyaltyProgram(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/RoyaltyProgram.fxml", "Loyalty & Rewards Program");
    }

    public void openFeedbackSubmission(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/TicketBuyer/FeedBackSubmission.fxml", "Feedback Submission");
    }

    public void BackToLoginButton(ActionEvent e) {
        openAndClose(e, "/com/oop/group16/summer25_sec2/Login.fxml", "Login");
    }

    private void open(String resource, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ignored) {
        }
    }

    private void openAndClose(ActionEvent e, String resource, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
            Node node = (Node) e.getSource();
            Stage current = (Stage) node.getScene().getWindow();
            if (current != null) current.close();
        } catch (Exception ignored) {
        }
    }
}