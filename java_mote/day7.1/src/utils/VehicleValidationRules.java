package utils;

import java.util.Date;

import custom_exceptions.DrivingLicenceExpiredException;
import custom_exceptions.SpeedOutOfRangeException;

public class VehicleValidationRules {
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	public static final Date curDate;
	static {
		MIN_SPEED = 20;
		MAX_SPEED = 80;
		curDate = new Date();
	}
	
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException
	{
		if(speed<MIN_SPEED) {
			throw new SpeedOutOfRangeException("Speed too slow");
		}
		
		if(speed>MAX_SPEED) {
			throw new SpeedOutOfRangeException("Speed too fast");
		}
		
		System.out.println("Speed in range");
	}
	
	public static void checkDrivingLicenceExpiry(Date expDate) throws DrivingLicenceExpiredException
	{
		if(curDate.after(expDate)) {
			throw new DrivingLicenceExpiredException("Your Licence is expired please renew it");
		}
		System.out.println("good to go");
	}
}
