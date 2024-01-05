package custom_exception;

public class InvalidPriceException extends Exception {
	private String customMessage;
	
	public InvalidPriceException(String errmsg) {
		customMessage = errmsg;
	}

	 @Override
	    public String toString() {
	        return customMessage; 
	    }
}
