package com.noahsoticek.Restaurant.model;

public class Reservation {

    private int seats;
    private String email;

    public Reservation(int seats, String email) {
        this.seats = seats;
        this.email = email;
    }

    public int getSeats() {
        return seats;
    }

    public String getEmail() {
        return email;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "seats=" + seats +
                ", email='" + email + '\'' +
                '}';
    }
}
