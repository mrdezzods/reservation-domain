package services;

import db.RestaurantRepository;
import db.RestaurantRepositoryFactory;
import domain.Restaurant;

import java.util.List;


public class RestaurantService {


    RestaurantRepository repository;

    public RestaurantService(String type) {
        repository = RestaurantRepositoryFactory.make(type);
    }


    public List<Restaurant> getAll() {
        return repository.getAll();
    }


    public Restaurant findBySlug(String slug) {
        return repository.findBySlug(slug);
    }

    public Restaurant findById(Integer restaurantId) {
        return repository.findById(restaurantId);
    }
}
