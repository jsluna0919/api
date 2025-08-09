package co.floristeria.domain.usecase;

public class NotFoundExceptions {

    public static class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}
