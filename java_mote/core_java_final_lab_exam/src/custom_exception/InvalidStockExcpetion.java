package custom_exception;

public class InvalidStockExcpetion extends Exception {
	public InvalidStockExcpetion(String errmsg) {
		super(errmsg);
	}
}
