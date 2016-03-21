package db;

import domain.Reservation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrdezzods on 21/03/16.
 */
public class ReservationFakeRepository implements ReservationRepository {
    protected Set<Reservation> reservations = new HashSet<Reservation>();

    public ReservationFakeRepository() {
//fill reservations
    }

    public void addReservation(Reservation reservation) {

    }

    public Reservation get(Integer reservationId) {
        return null;
    }

    public void deleteReservation(Reservation reservation) {

    }
}
