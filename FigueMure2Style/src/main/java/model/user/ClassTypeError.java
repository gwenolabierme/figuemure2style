package model.user;

/**
 * Messages d'erreurs.
 * 
 * @author jeremy
 */
public class ClassTypeError extends Exception {

    public ClassTypeError() {
        super();
    }

    public ClassTypeError(String message) {
        super(message);
    }

    public ClassTypeError(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassTypeError(Throwable cause) {
        super(cause);
    }
}
