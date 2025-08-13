package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class ProgramMonitorItem {
    private String programName;
    private String startDate;
    private String status;
    private String notes;

    public ProgramMonitorItem() {
    }

    public ProgramMonitorItem(String programName, String startDate, String status, String notes) {
        this.programName = programName;
        this.startDate = startDate;
        this.status = status;
        this.notes = notes;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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