package fa.training.exception;

public class MyOwnRuntimeException extends RuntimeException {
    public MyOwnRuntimeException() {
    }

    public MyOwnRuntimeException(String message) {
        super(message);
    }
}
