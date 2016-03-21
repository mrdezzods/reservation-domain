package db;

/**
 * Created by mrdezzods on 21/03/16.
 */
public class ReservationRepositoryFactory {

    public static ReservationRepository make(String type) {
        if (type.equals("fake")) {
            return new ReservationFakeRepository();
        } else {
            return new ReservationSQLRepository();
        }
    }
}
