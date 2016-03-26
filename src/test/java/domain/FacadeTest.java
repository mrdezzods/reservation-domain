package domain;

import db.DBException;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
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
    public void testIfResturnsRestaurantsCorrectly() {
        Set restaurants = facade.getAllRestaurants();
        assertNotNull(restaurants);
    }

    @Test
    public void testIfFindsRestaurantBySlug() {
        Restaurant restaurant = facade.findRestaurantBySlug("restaurant-1");
        assertNotNull(restaurant);
    }

    @Test(expected = DBException.class)
    public void testEmptySlugThrowsException() {
        facade.findRestaurantBySlug(null);
    }


    @Test(expected = DBException.class)
    public void testInvalidIdThrowsException() {
        facade.findRestaurantById(22);
    }


}
