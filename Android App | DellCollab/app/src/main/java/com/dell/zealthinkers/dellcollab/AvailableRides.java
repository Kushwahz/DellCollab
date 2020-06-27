package com.dell.zealthinkers.dellcollab;

public class AvailableRides {
    public String phoneNumber;
    public String vehicle;
    public String hour;
    public String min;
    public String seats;

    public AvailableRides(String phoneNumber, String vehicle, String hour, String min, String seats) {
        this.phoneNumber = phoneNumber;
        this.vehicle = vehicle;
        this.hour = hour;
        this.min = min;
        this.seats = seats;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
