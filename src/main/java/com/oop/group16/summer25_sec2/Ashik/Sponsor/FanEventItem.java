package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class FanEventItem {
    private String eventName;
    private String proposalDate;
    private String status;
    private String feedback;

    public FanEventItem() {
    }

    public FanEventItem(String eventName, String proposalDate, String status, String feedback) {
        this.eventName = eventName;
        this.proposalDate = proposalDate;
        this.status = status;
        this.feedback = feedback;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}