package db;

import domain.Restaurant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestaurantSQLRepository implements RestaurantRepository {

    public RestaurantSQLRepository() {
        openConnection();
    }

    private EntityManagerFactory factory;
    private EntityManager manager;

    public void openConnection() {
        factory = Persistence.createEntityManagerFactory("reservation");
        manager = factory.createEntityManager();
    }

    public void closeConnection() {
        try {
            manager.close();
            factory.close();
        } catch (Exception e) {
            throw new DBException(e.getMessage(), e);
        }
    }


    public Set<Restaurant> getAll() {
        List results = manager.createQuery("from Restaurant").getResultList();
        return new HashSet<Restaurant>(results);

    }

    public void delete(Restaurant restaurant) {

    }

    public void add(Restaurant restaurant) {

    }


    public Restaurant findBySlug(String slug) {
        if (slug == null || slug.isEmpty()) {
            throw new DBException("Slug cannot be empty");
        }

        try {
            Restaurant restaurant = (Restaurant) manager.createQuery("select r from Restaurant r where r.slug = :slug")
                    .setParameter("slug", slug)
                    .getSingleResult();
            return restaurant;
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        }

    }

    public Restaurant findById(Integer restaurantId) {
        try {
            return manager.find(Restaurant.class, restaurantId);
        } catch (Exception ex) {
            throw new DBException(ex.getMessage(), ex);
        }

    }


}
