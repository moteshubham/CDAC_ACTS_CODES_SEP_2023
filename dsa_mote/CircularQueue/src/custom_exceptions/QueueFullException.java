package custom_exceptions;

public class QueueFullException extends Exception {
public QueueFullException(String errmsg) {
	super(errmsg);
}
}
