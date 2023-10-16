package utils;

import custom_exceptions.SpeedOutOfRangeException;

public class VehicleValidationRules {
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	static {
		MIN_SPEED = 20;
		MAX_SPEED = 80;
	}
	
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException
	{
		if(speed<MIN_SPEED) {
			throw new SpeedOutOfRangeException("Speed badhao bhai");
		}
		
		if(speed>MAX_SPEED) {
			throw new SpeedOutOfRangeException("Pori jara halu halu chaal..");
		}
		
		System.out.println("Sahi ja rahe ho");
	}
}
