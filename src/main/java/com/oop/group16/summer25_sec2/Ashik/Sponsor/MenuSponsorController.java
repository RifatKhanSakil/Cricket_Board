package com.oop.group16.summer25_sec2.Ashik.Sponsor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;

import java.net.URL;

public class MenuSponsorController {
    public void openBrandVisibility(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/Sponsorship&BrandVisibility.fxml", "Sponsorship & Brand Visibility");
    }

    public void openPromoteProductLaunches(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/PromoteProductLaunches.fxml", "Promote Product Launches");
    }

    public void openSponsorshipAmount(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/SponsorshipAmount.fxml", "International Tour Sponsorship");
    }

    public void openCompanyEventManagement(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/CompanyEventManagement.fxml", "Co-Branded Fan Event Management");
    }

    public void openSocialMediaImpact(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/SocialMediaImpact.fxml", "Social Media Impact");
    }

    public void openGrassrootDevelopment(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/GrassrootDevelopment.fxml", "Grassroots Development");
    }

    public void openPositiveBrandImage(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/PositiveBrandImage.fxml", "Positive Brand Image");
    }

    public void openSponsorshipObjectives(ActionEvent e) {
        open("/com/oop/group16/summer25_sec2/Ashik/Sponsor/SponsorshipObjectives.fxml", "Strategic Partnership Objectives");
    }

    public void BackToLoginButton(ActionEvent e) {
        openAndClose(e, "/com/oop/group16/summer25_sec2/Login.fxml", "Login");
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void open(String resource, String title) {
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
        } catch (Exception ex) {
            Throwable cause = ex.getCause();
            String detail = ex.getClass().getSimpleName() + ": " + (ex.getMessage() == null ? "" : ex.getMessage());
            if (cause != null)
                detail += "\nCause: " + cause.getClass().getSimpleName() + ": " + (cause.getMessage() == null ? "" : cause.getMessage());
            showError("Failed to open: " + title + "\n" + detail);
        }
    }

    private void openAndClose(ActionEvent e, String resource, String title) {
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
            Node node = (Node) e.getSource();
            Stage current = (Stage) node.getScene().getWindow();
            if (current != null) current.close();
        } catch (Exception ex) {
            Throwable cause = ex.getCause();
            String detail = ex.getClass().getSimpleName() + ": " + (ex.getMessage() == null ? "" : ex.getMessage());
            if (cause != null)
                detail += "\nCause: " + cause.getClass().getSimpleName() + ": " + (cause.getMessage() == null ? "" : cause.getMessage());
            showError("Failed to open: " + title + "\n" + detail);
        }
    }
}