package byui.cit260.permberleyGame.exceptions;

/**
 *
 * @author mbp
 */
public class InventoryControlException extends Exception{

    public InventoryControlException() {
    }

    
    public InventoryControlException(String message) {
        super(message);
    }

    public InventoryControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryControlException(Throwable cause) {
        super(cause);
    }

    public InventoryControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
