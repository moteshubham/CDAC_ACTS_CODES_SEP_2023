package custom_exceptions;

public class QueueEmptyException extends Exception {
	public QueueEmptyException(String errmsg) {
		super(errmsg);
	}
}
