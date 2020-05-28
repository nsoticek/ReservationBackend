package com.noahsoticek.Restaurant.model;

public class Restaurant {

    private final int id;
    private final String name;
    private final int seats;
    private final String adress;
    private final String city;

    public Restaurant(int id, String name, int seats, String adress, String city) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.adress = adress;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }
}
