package db;

import domain.Restaurant;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrdezzods on 29/02/16.
 */
public class RestaurantFakeRepository implements RestaurantRepository {

    protected Set<Restaurant> restaurants = new HashSet<Restaurant>();

    public RestaurantFakeRepository() {
        //fill restaurants
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(1);
        restaurant1.setName("Restaurant 1");
        restaurant1.setAddress("Leuvensestraat 12");
        restaurant1.setSlug("restaurant-1");
        restaurant1.setLogo("http://image.naldzgraphics.net/2011/11/4-BonafideRestaurant.jpg");
        restaurants.add(restaurant1);

        Restaurant restaurant2 = new Restaurant();
        restaurant1.setId(2);
        restaurant2.setName("Restaurant 2");
        restaurant2.setAddress("Brusselsestraat 1");
        restaurant2.setSlug("restaurant-2");
        restaurant2.setLogo("http://www.magazinehive.com/wp-content/uploads/2013/01/Good-Looking-Restaurant-Logos-Design-for-Inspiration.jpg");
        restaurants.add(restaurant2);
    }

    public Set<Restaurant> getAll() {
        return restaurants;
    }

    public void delete(Restaurant restaurant) {

    }

    public void add(Restaurant restaurant) {
        if (restaurant != null) {
            restaurants.add(restaurant);
        } else {
            throw new DBException("Restaurant cannot be null");
        }
    }

    public Restaurant findBySlug(String slug) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getSlug().equals(slug)) {
                return restaurant;
            }
        }
        throw new DBException("Restaurant not found");
    }

    public Restaurant findById(Integer restaurantId) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                return restaurant;
            }
        }
        throw new DBException("Restaurant not found");
    }
}
