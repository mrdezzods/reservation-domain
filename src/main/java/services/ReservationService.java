package services;


import db.ReservationRepository;
import db.ReservationRepositoryFactory;
import domain.Reservation;

public class ReservationService {
    ReservationRepository repository;

    public ReservationService(String type) {
        repository = ReservationRepositoryFactory.make(type);
    }


    public void addReservation(Reservation reservation) {
        repository.addReservation(reservation);
    }

    public Reservation get(Integer reservationId) {
        return repository.get(reservationId);
    }

    public void deleteReservation(Reservation reservation) {
        repository.deleteReservation(reservation);
    }
}
