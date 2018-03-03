package nks.contacts.web;

public class WebException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -6929384993246243938L;

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

}
