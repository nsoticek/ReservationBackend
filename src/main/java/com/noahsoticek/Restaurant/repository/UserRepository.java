package com.noahsoticek.Restaurant.repository;

import com.noahsoticek.Restaurant.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        users.add(new User("noah@gmx.at", getHashedPassword("123"), "Noah Soticek",
                "Strasse 1", "Bludesch", ""));
        return users;
    }

    public String getHashedPassword(String plainPassword) {
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        return crypt.encode(plainPassword);
    }
}
