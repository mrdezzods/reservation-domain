package db;

/**
 * Created by mrdezzods on 21/03/16.
 */
public class RestaurantRepositoryFactory {

    public static RestaurantRepository make(String type) {
        if (type.equals("fake")) {
            return new RestaurantFakeRepository();
        } else {
            return new RestaurantSQLRepository();
        }
    }
}
