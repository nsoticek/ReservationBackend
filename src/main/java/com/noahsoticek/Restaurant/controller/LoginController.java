package com.noahsoticek.Restaurant.controller;

import com.noahsoticek.Restaurant.model.User;
import com.noahsoticek.Restaurant.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Random;

public class LoginController {

    public static User login(String email, String password, ArrayList<User> users) {
        // Check username and password; if true return full user object; if false return user = null
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equalsIgnoreCase(email)) {
                if(bCryptPasswordEncoder.matches(password, users.get(i).getPassword())) {
                    user = users.get(i);
                    user.setToken(getToken());
                }
            }
        }
        return user;
    }

    public static String getToken() {
        // Generate new token and return it
        String token = "";
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int num = random.nextInt(106 - 81) + 81;
            char newChar = (char) num;
            token += newChar;
        }
        return token;
    }

    public static User isTokenValid(String token, UserRepository userRepo) {
        // Check if token is valid; if true return current user
        ArrayList<User> users = userRepo.getUsers();
        User user = null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getToken().equals(token)) {
                user = users.get(i);
                break;
            }
        }
        return user;
    }
}
