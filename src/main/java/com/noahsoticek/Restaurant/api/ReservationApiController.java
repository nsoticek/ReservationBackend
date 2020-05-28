package com.noahsoticek.Restaurant.api;

import com.noahsoticek.Restaurant.controller.LoginController;
import com.noahsoticek.Restaurant.controller.ReservationController;
import com.noahsoticek.Restaurant.model.Reservation;
import com.noahsoticek.Restaurant.model.UpdateSeats;
import com.noahsoticek.Restaurant.model.User;
import com.noahsoticek.Restaurant.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class ReservationApiController {

    private UserRepository userRepo;

    public ReservationApiController() {
        this.userRepo = UserRepository.getInstance();
    }

    @GetMapping("/reservations")
    public ArrayList<Reservation> reservation(@RequestHeader("Token") String token) {
        ArrayList<Reservation> reservations = null;
        User user = LoginController.isTokenValid(token, userRepo);

        if (user != null) {
            reservations = ReservationController.getUserReservations(user);
        }
        return reservations;
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public String addReservationApi(@RequestBody Reservation reservation, @RequestHeader("Token") String token) {

        User user = LoginController.isTokenValid(token, userRepo);

        if (user != null) {
            ReservationController.addReservation(new Reservation(reservation.getSeats(), user.getEmail()));
            return "Reservation added";
        } else {
            return "Token invalid!";
        }
    }

    @RequestMapping(value = "/deleteReservation/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteReservation(@PathVariable int id, @RequestHeader("Token") String token) {

        User user = LoginController.isTokenValid(token, userRepo);

        if (user != null) {
            boolean isRemoved = ReservationController.deleteReservation(id);

            if (!isRemoved) {
                return HttpStatus.NOT_FOUND;
            }
            return HttpStatus.OK;
        } else {
            return HttpStatus.FORBIDDEN;
        }
    }

    @RequestMapping(value = "/updateReservation/{id}", method = RequestMethod.PUT)
    public HttpStatus updateReservation(@PathVariable int id, @RequestBody UpdateSeats updateSeats, @RequestHeader("Token") String token) {

        User user = LoginController.isTokenValid(token, userRepo);

        if (user != null) {
            boolean isRemoved = ReservationController.updateReservation(id, updateSeats.getSeats());

            if (!isRemoved) {
                return HttpStatus.NOT_FOUND;
            }
            return HttpStatus.OK;
        } else {
            return HttpStatus.FORBIDDEN;
        }
    }
}
