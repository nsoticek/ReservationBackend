package com.noahsoticek.Restaurant.model;

public class User {

    private final String email;
    private final String password;
    private final String name;
    private final String adress;
    private final String city;
    private String token;

    public User(String email, String password, String name, String adress, String city, String token) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
