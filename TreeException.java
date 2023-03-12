package ADTBinarySearchTree;
/**
 * Defines an exception that is thrown when occurs with an anomaly.
 */
public class TreeException extends RuntimeException{
    /**
     * Constructs an object with specific message
     * @param message A string literal specifying the details of this exception
     */
    public TreeException(String message){super(message);}
}
