package api.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -642045799876625537L;
    private static final String DESCRIPTION = "Not Found Exception";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
