package com.noahsoticek.Restaurant.api;

import com.noahsoticek.Restaurant.controller.LoginController;
import com.noahsoticek.Restaurant.model.PostRequest;
import com.noahsoticek.Restaurant.model.User;
import com.noahsoticek.Restaurant.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class UserApiController {

    private UserRepository userRepo;

    public UserApiController() {
        this.userRepo = UserRepository.getInstance();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginApi(@RequestBody PostRequest inputPayload) {
        ArrayList<User> users = userRepo.getUsers();

        User user = LoginController.login(inputPayload.getEmail(), inputPayload.getPassword(), users);

        if(user != null) {
            return user.getToken();
        } else {
            return "Login failed!";
        }
    }
}

