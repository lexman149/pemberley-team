
package byui.cit260.permberleyGame.exceptions;

/**
 *
 * @author jpmanning
 */
public class ItemControlException extends Exception {
    
    public ItemControlException() {
    }

    public ItemControlException(String message) {
        super(message);
    }

    public ItemControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemControlException(Throwable cause) {
        super(cause);
    }

    public ItemControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
