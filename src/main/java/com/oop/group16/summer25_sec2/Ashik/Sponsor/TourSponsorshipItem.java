package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class TourSponsorshipItem {
    private String tourName;
    private String proposalDate;
    private String status;
    private String notes;

    public TourSponsorshipItem() {
    }

    public TourSponsorshipItem(String tourName, String proposalDate, String status, String notes) {
        this.tourName = tourName;
        this.proposalDate = proposalDate;
        this.status = status;
        this.notes = notes;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(String proposalDate) {
        this.proposalDate = proposalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}