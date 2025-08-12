package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class RefundTransferRecord {
    private String ticketId;
    private String actionType;
    private String status;
    private String dateProcessed;

    public RefundTransferRecord() {
    }

    public RefundTransferRecord(String ticketId, String actionType, String status, String dateProcessed) {
        this.ticketId = ticketId;
        this.actionType = actionType;
        this.status = status;
        this.dateProcessed = dateProcessed;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(String dateProcessed) {
        this.dateProcessed = dateProcessed;
    }
}