package custom_exceptions;

public class StackFullException extends Exception {
	public StackFullException(String errmsg) {
		super(errmsg);
	}
}
