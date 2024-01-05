package custom_exceptions;

public class ValidationException extends Exception {
	public ValidationException(String errmsg) {
		super(errmsg);
	}
}
