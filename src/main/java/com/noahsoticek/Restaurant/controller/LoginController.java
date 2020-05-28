package com.noahsoticek.Restaurant.controller;

import com.noahsoticek.Restaurant.model.User;
import com.noahsoticek.Restaurant.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;

public class LoginController {

    String SECRET_KEY = "8Zz5tw0Ionm3XPZZfN0NOml3z9FMfmpgXwovR9fp6ryDIoGRM8EPHAB6iHsc0fb";

    public User login(String email, String password, ArrayList<User> users) {
        // Check username and password; if true return full user object; if false return user = null
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equalsIgnoreCase(email)) {
                if(bCryptPasswordEncoder.matches(password, users.get(i).getPassword())) {
                    user = users.get(i);
                    user.setToken(generateJWT(user.getName()));
                }
            }
        }
        return user;
    }

    private String generateJWT(String username) {
        return Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS256, DatatypeConverter.parseBase64Binary(SECRET_KEY)).compact();
    }

    public User getUser(String jwt) {
        UserRepository userRepo = new UserRepository();
        ArrayList<User> users = userRepo.getUsers();

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(jwt).getBody();

            return userRepo.getUser(claims.getSubject());
        }catch (Exception e) {
            return null;
        }
    }
}
