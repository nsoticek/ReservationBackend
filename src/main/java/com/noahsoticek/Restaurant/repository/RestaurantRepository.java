package com.noahsoticek.Restaurant.repository;

import com.noahsoticek.Restaurant.model.Restaurant;

import java.util.ArrayList;

public class RestaurantRepository {

    public static ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(0, "Pizzeria Valentino", 20, "Strasse 3", "Bludesch"));
        restaurants.add(new Restaurant(1, "Essen", 30, "Strasse 4", "Bludenz"));
        restaurants.add(new Restaurant(2, "Pizzeria 2020", 80, "Strasse 6", "Feldkirch"));
        return restaurants;
    }
}
