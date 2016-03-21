package db;

/**
 * Created by mrdezzods on 21/03/16.
 */
public class DBException extends RuntimeException {
    public DBException(String message, Exception e) {
        super(message, e);
    }

    public DBException(String message) {
        super(message);
    }
}
