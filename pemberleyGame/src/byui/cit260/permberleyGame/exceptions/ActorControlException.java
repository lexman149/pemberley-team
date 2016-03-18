
package byui.cit260.permberleyGame.exceptions;

/**
 *
 * @author Sheila
 */
public class ActorControlException extends Exception{

    public ActorControlException() {
    }

    public ActorControlException(String message) {
        super(message);
    }

    public ActorControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActorControlException(Throwable cause) {
        super(cause);
    }

    public ActorControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
