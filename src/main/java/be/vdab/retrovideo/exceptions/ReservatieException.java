package be.vdab.retrovideo.exceptions;

public class ReservatieException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ReservatieException() {
    }
    public ReservatieException(String message) {
        super(message);
    }
    public ReservatieException(String message, Throwable cause) {
        super(message, cause);
    }
}
