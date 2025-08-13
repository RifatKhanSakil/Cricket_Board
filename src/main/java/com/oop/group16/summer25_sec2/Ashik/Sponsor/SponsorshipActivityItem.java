package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class SponsorshipActivityItem {
    private String activityName;
    private String date;
    private String status;
    private String notes;

    public SponsorshipActivityItem() {
    }

    public SponsorshipActivityItem(String activityName, String date, String status, String notes) {
        this.activityName = activityName;
        this.date = date;
        this.status = status;
        this.notes = notes;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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