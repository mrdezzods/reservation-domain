package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
        List restaurants = facade.getAllRestaurants();
        assertNotNull(restaurants);
    }

    @Test
    public void test_if_facade_returns_restaurant_by_slug() {
        Restaurant restaurant = facade.findRestaurantBySlug("buddha-house");
        assertNotNull(restaurant);
    }

    @Test(expected = DomainException.class)
    public void test_if_null_slug_throws_exception() {
        facade.findRestaurantBySlug(null);
    }


    @Test(expected = DomainException.class)
    public void test_if_invalid_id_throws_exception() {
        facade.findRestaurantById(-22);
    }


}
