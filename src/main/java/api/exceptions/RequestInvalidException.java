package api.exceptions;

public class RequestInvalidException extends RuntimeException {
    private static final long serialVersionUID = -642045799876625537L;
    private static final String DESCRIPTION = "Request Invalid Exception";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
