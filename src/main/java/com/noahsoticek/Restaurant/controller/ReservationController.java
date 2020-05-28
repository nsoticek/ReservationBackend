package com.noahsoticek.Restaurant.controller;

import com.noahsoticek.Restaurant.model.Reservation;
import com.noahsoticek.Restaurant.model.User;
import com.noahsoticek.Restaurant.repository.ReservationRepository;

import java.util.ArrayList;

public class ReservationController {

    public static ArrayList<Reservation> getUserReservations(User user) {
        ReservationRepository reservationRepo = ReservationRepository.getInstance();

        ArrayList<Reservation> reservations = reservationRepo.getReservations();
        return reservations;
    }

    public static void addReservation(Reservation reservation) {
        ReservationRepository reservationRepo = ReservationRepository.getInstance();
        reservationRepo.addReservation(reservation);
    }

    public static boolean deleteReservation(int id) {
        boolean isRemoved = false;

        // Delete reservation
        ReservationRepository reservationRepo = ReservationRepository.getInstance();
        reservationRepo.deleteReservation(id);

        // Check if reservation is deleted; if yes return true
        if(reservationRepo.getReservations().get(id).getSeats() == 0) {
            isRemoved = true;
        }
        return isRemoved;
    }

    public static boolean updateReservation(int id, int updatedSeats) {
        boolean isUpdated = false;

        ReservationRepository reservationRepo = ReservationRepository.getInstance();
        reservationRepo.updateReservation(id, updatedSeats);

        if(reservationRepo.getReservations().get(id).getSeats() == updatedSeats) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
