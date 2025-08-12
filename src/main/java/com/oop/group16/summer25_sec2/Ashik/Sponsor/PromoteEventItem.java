package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class PromoteEventItem {
    private String eventName;
    private String stage;
    private String status;
    private String notes;

    public PromoteEventItem() {
    }

    public PromoteEventItem(String eventName, String stage, String status, String notes) {
        this.eventName = eventName;
        this.stage = stage;
        this.status = status;
        this.notes = notes;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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