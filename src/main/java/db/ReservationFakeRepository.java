package db;

import domain.Reservation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrdezzods on 21/03/16.
 */
public class ReservationFakeRepository implements ReservationRepository {
    protected Set<Reservation> reservations = new HashSet<Reservation>();

    private int autoNumberingId = 0;

    public ReservationFakeRepository() {
//fill reservations
    }

    public void addReservation(Reservation reservation) {
        reservation.setId(++autoNumberingId);
        this.reservations.add(reservation);
    }

    public Reservation get(Integer reservationId) {
        for (Reservation reservation : this.reservations) {
            if (reservation.getId() == reservationId) {
                return reservation;
            }
        }
        throw new DBException("Reservation not found");
    }

    public void deleteReservation(Integer reservationId) {

        for (Reservation reservation : this.reservations) {
            if (reservation.getId() == reservationId) {
                reservations.remove(reservation);
                return;
            }
        }

        throw new DBException("Reservation not found");
    }

    public Set<Reservation> getAll() {
        return reservations;
    }
}
