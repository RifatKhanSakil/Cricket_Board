package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Seat {
    private final StringProperty name = new SimpleStringProperty(this, "name");
    private final StringProperty seatNumber = new SimpleStringProperty(this, "seatNumber");
    private final StringProperty section = new SimpleStringProperty(this, "section");
    private final DoubleProperty price = new SimpleDoubleProperty(this, "price");
    private final BooleanProperty available = new SimpleBooleanProperty(this, "available");

    public Seat(String seatNumber, String section, double price, boolean available) {
        setSeatNumber(seatNumber);
        setSection(section);
        setPrice(price);
        setAvailable(available);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getSeatNumber() {
        return seatNumber.get();
    }

    public void setSeatNumber(String value) {
        seatNumber.set(value);
    }

    public StringProperty seatNumberProperty() {
        return seatNumber;
    }


    public String getSection() {
        return section.get();
    }

    public void setSection(String value) {
        section.set(value);
    }

    public StringProperty sectionProperty() {
        return section;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double value) {
        price.set(value);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public boolean isAvailable() {
        return available.get();
    }

    public void setAvailable(boolean value) {
        available.set(value);
    }

    public BooleanProperty availableProperty() {
        return available;
    }
}
