package com.oop.group16.summer25_sec2.Ashik.Sponsor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

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