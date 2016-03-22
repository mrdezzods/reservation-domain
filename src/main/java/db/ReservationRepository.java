package db;

import domain.Reservation;

import java.util.Set;

/**
 * Created by mrdezzods on 01/03/16.
 */
public interface ReservationRepository {
    void addReservation(Reservation reservation);
    Reservation get(Integer reservationId);

    void deleteReservation(Integer reservation);

    Set<Reservation> getAll();
}
