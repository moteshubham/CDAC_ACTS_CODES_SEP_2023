package custom_exceptions;

@SuppressWarnings("serial")
public class PenNotFoundException extends Exception {
	public PenNotFoundException(String errmsg) {
		super(errmsg);
	}
}
