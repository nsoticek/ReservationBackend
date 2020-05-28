package com.noahsoticek.Restaurant.api;

import java.util.ArrayList;

import com.noahsoticek.Restaurant.model.Restaurant;
import com.noahsoticek.Restaurant.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantApiController {

    ArrayList<Restaurant> restaurants = new ArrayList<>();

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> all() {
        restaurants.clear();
        restaurants = RestaurantRepository.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant findOne(@PathVariable int id) {
        restaurants = RestaurantRepository.getRestaurants();

        return new Restaurant(restaurants.get(id).getId(), restaurants.get(id).getName(), restaurants.get(id). getSeats(),
                restaurants.get(id).getAdress(), restaurants.get(id).getCity());
    }
}
