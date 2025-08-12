package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class RewardHistoryItem {
    private String date;
    private String action;
    private int points;
    private String description;

    public RewardHistoryItem() {
    }

    public RewardHistoryItem(String date, String action, int points, String description) {
        this.date = date;
        this.action = action;
        this.points = points;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}