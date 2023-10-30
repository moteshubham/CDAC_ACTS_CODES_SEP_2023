package custom_exceptions;

public class StackEmptyException extends Exception {
	public StackEmptyException(String errmsg) {
		super(errmsg);
	}
}
