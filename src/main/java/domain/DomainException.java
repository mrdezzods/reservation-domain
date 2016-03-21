package domain;

/**
 * Created by mrdezzods on 28/02/16.
 */
public class DomainException extends RuntimeException {
    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Exception e) {
        super(message, e);
    }
}
