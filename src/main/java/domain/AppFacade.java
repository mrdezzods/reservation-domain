package domain;


import services.ReservationService;
import services.RestaurantService;
import services.ReviewService;

import java.util.List;
import java.util.Set;

public class AppFacade {

    private RestaurantService restaurantService;

    private ReservationService reservationService;

    private ReviewService reviewService;

    public AppFacade(String type) {
        reservationService = new ReservationService(type);
        restaurantService = new RestaurantService(type);
        reviewService = new ReviewService();
    }


    public Set<Restaurant> getAllRestaurants() {
        return restaurantService.getAll();
    }


    public void addReservation(Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    public void deleteReservation(Integer reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    public Restaurant findRestaurantBySlug(String slug) {
        return restaurantService.findBySlug(slug);
    }

    public Reservation getReservation(Integer reservationId) {
        return reservationService.get(reservationId);
    }

    public Restaurant findRestaurantById(int i) {
        return restaurantService.findById(i);
    }

    public Set<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    public void acceptReservation(Integer reservationId) {
        reservationService.acceptReservation(reservationId);
    }

    public List<Review> getReviewsFromWebservice(String slug) {
        return this.reviewService.getReviewsFor(slug);
    }
}
