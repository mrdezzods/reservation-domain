package db;

import domain.Restaurant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mrdezzods on 29/02/16.
 */
public class RestaurantFakeRepository implements RestaurantRepository {

    protected Set<Restaurant> restaurants = new HashSet<Restaurant>();

    public RestaurantFakeRepository(){
        //fill restaurants
    }

    public List<Restaurant> getAll() {
        return null;
    }

    public void delete(Restaurant restaurant) {

    }

    public void add(Restaurant restaurant) {

    }

    public Restaurant findBySlug(String slug) {
        return null;
    }

    public Restaurant findById(Integer restaurantId) {
        return null;
    }
}
