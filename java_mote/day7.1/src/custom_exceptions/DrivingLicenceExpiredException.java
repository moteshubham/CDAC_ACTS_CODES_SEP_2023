package custom_exceptions;

public class DrivingLicenceExpiredException extends Exception{
	public DrivingLicenceExpiredException(String msg) {
		super(msg);
	}
}
