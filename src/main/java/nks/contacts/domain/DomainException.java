package nks.contacts.domain;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 7528992141089464196L;

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }
}
