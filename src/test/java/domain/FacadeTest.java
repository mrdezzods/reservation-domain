package domain;

import db.DBException;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mrdezzods on 28/02/16.
 */

public class FacadeTest {

    AppFacade facade;

    @Before
    public void setUp() {
        facade = new AppFacade("fake");
    }

    @Test
    public void test_if_facade_returns_restaurants() {
        Set restaurants = facade.getAllRestaurants();
        assertNotNull(restaurants);
    }

    @Test
    public void test_if_facade_returns_restaurant_by_slug() {
        Restaurant restaurant = facade.findRestaurantBySlug("restaurant-1");
        assertNotNull(restaurant);
    }

    @Test(expected = DBException.class)
    public void test_if_null_slug_throws_exception() {
        facade.findRestaurantBySlug(null);
    }


    @Test(expected = DBException.class)
    public void test_if_invalid_id_throws_exception() {
        facade.findRestaurantById(-22);
    }


}
