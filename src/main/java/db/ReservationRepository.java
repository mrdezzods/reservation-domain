package db;

import domain.Reservation;

/**
 * Created by mrdezzods on 01/03/16.
 */
public interface ReservationRepository {
    void addReservation(Reservation reservation);
    Reservation get(Integer reservationId);

    void deleteReservation(Reservation reservation);
}
