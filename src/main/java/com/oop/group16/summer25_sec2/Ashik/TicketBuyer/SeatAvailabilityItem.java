package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class SeatAvailabilityItem {
    private String seatNumber;
    private String blockRow;
    private double price;
    private String availability;

    public SeatAvailabilityItem() {
    }

    public SeatAvailabilityItem(String seatNumber, String blockRow, double price, String availability) {
        this.seatNumber = seatNumber;
        this.blockRow = blockRow;
        this.price = price;
        this.availability = availability;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBlockRow() {
        return blockRow;
    }

    public void setBlockRow(String blockRow) {
        this.blockRow = blockRow;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}