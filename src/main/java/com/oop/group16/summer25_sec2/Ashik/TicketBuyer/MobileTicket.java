package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import java.time.LocalDate;

public class MobileTicket {
    private String id;
    private String matchName;
    private LocalDate date;
    private String seatInfo;

    public MobileTicket() {
    }

    public MobileTicket(String id, String matchName, LocalDate date, String seatInfo) {
        this.id = id;
        this.matchName = matchName;
        this.date = date;
        this.seatInfo = seatInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(String seatInfo) {
        this.seatInfo = seatInfo;
    }

    @Override
    public String toString() {
        return matchName + " | " + date + " | " + seatInfo;
    }
}