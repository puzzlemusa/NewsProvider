package musa.cefalo.assignment.NewsProvider.exceptions;

/**
 * Created by Asus on 6/30/2017.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
