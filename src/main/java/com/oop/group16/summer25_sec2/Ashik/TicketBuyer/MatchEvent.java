package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class MatchEvent {
    private String time;
    private String eventType;
    private String playerName;
    private String team;

    public MatchEvent() {
    }

    public MatchEvent(String time, String eventType, String playerName, String team) {
        this.time = time;
        this.eventType = eventType;
        this.playerName = playerName;
        this.team = team;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}