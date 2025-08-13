package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class BrandCommLogItem {
    private String date;
    private String actionTaken;
    private String outcome;

    public BrandCommLogItem() {
    }

    public BrandCommLogItem(String date, String actionTaken, String outcome) {
        this.date = date;
        this.actionTaken = actionTaken;
        this.outcome = outcome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}