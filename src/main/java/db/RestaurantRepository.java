package db;

import domain.Restaurant;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;

/**
 * Created by mrdezzods on 27/02/16.
 */
@NoRepositoryBean
public interface RestaurantRepository {

    Set<Restaurant> getAll();

    void delete(Restaurant restaurant);

    void add(Restaurant restaurant);


    Restaurant findBySlug(String slug);

    Restaurant findById(Integer restaurantId);
}
