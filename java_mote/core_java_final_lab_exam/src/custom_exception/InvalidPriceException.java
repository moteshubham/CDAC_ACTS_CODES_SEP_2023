package custom_exception;

public class InvalidPriceException extends Exception {

	
	public InvalidPriceException(String errmsg) {
		super(errmsg);
	}
}
