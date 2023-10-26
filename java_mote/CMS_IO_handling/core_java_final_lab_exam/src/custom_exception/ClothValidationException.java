package custom_exception;

public class ClothValidationException extends Exception {
	public ClothValidationException(String errmsg) {
		super(errmsg);
	}
}
