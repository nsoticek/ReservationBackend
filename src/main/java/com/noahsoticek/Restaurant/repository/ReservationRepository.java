package com.noahsoticek.Restaurant.repository;

import com.noahsoticek.Restaurant.model.Reservation;
import java.util.ArrayList;

public class ReservationRepository {

    ArrayList<Reservation> reservations = new ArrayList<>();
    private static ReservationRepository instance;

    public static ReservationRepository getInstance() {
        if(instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void deleteReservation(int id) {
        reservations.get(id).setSeats(0);
    }

    public void updateReservation(int id, int updatedSeats) {
        reservations.get(id).setSeats(updatedSeats);
    }
}
