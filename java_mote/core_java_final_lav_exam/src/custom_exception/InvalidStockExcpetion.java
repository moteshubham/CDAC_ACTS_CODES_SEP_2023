package custom_exception;

@SuppressWarnings("serial")
public class InvalidStockExcpetion extends Exception {
	private String customMessage;
	
	
	public InvalidStockExcpetion(String errmsg) {
		customMessage = errmsg;
	}
	 @Override
	    public String toString() {
	        return customMessage; 
	    }
	 
}
