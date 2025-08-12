package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class ComplaintStatusItem {
    private String ticketId;
    private String dateSubmitted;
    private String status;
    private String responseSummary;

    public ComplaintStatusItem() {
    }

    public ComplaintStatusItem(String ticketId, String dateSubmitted, String status, String responseSummary) {
        this.ticketId = ticketId;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
        this.responseSummary = responseSummary;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseSummary() {
        return responseSummary;
    }

    public void setResponseSummary(String responseSummary) {
        this.responseSummary = responseSummary;
    }
}