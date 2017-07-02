package musa.cefalo.assignment.NewsProvider.exceptions;

/**
 * Exception for no resource.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
