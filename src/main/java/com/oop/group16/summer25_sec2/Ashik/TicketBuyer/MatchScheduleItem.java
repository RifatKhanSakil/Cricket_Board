package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class MatchScheduleItem {
    private String matchDate;
    private String teams;
    private String venue;
    private String time;

    public MatchScheduleItem() {
    }

    public MatchScheduleItem(String matchDate, String teams, String venue, String time) {
        this.matchDate = matchDate;
        this.teams = teams;
        this.venue = venue;
        this.time = time;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return matchDate + " | " + teams + " | " + venue + " | " + time;
    }
}