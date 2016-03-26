package db;

import domain.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ReservationSQLRepository implements ReservationRepository {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public ReservationSQLRepository() {
        openConnection();
    }

    public void openConnection() {
        factory = Persistence.createEntityManagerFactory("reservation");
        manager = factory.createEntityManager();
    }

    public void closeConnection() {
        try {
            manager.close();
            factory.close();
        } catch (Exception e) {
        }
    }


    public void addReservation(Reservation reservation) {
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.persist(reservation);
            tx.commit();
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }


    public Reservation get(Integer reservationId) {
        try {
            Reservation reservation = manager.find(Reservation.class, reservationId);
            return reservation;
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        }
    }

    public void deleteReservation(Integer reservationId) {
        EntityTransaction tx = null;
        try {
            tx = manager.getTransaction();
            tx.begin();
            manager.remove(get(reservationId));
            tx.commit();
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public Set<Reservation> getAll() {
        try {
            List<Reservation> reservations = manager.createQuery("from Reservation ").getResultList();
            return new HashSet<Reservation>(reservations);
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        }

    }

    public void acceptReservation(Integer reservationId) {
        EntityTransaction tx = null;
        try {
            Reservation reservation = get(reservationId);
            reservation.setStatus("Accepted");
            tx = manager.getTransaction();
            tx.begin();
            manager.persist(reservation);
            tx.commit();
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

}
