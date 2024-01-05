package custom_exception;

@SuppressWarnings("serial")
public class ClothValidationException extends Exception {
	private String customMessage;

	public ClothValidationException(String errmsg) {
		customMessage = errmsg;
	}

	@Override
	public String toString() {
		return customMessage;
	}
}
