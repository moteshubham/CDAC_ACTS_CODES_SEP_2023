package tester;

import java.util.Scanner;

import custom_exceptions.SpeedOutOfRangeException;
import utils.VehicleValidationRules;

public class Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the speed");
			VehicleValidationRules.validateSpeed(sc.nextInt());
		} catch (SpeedOutOfRangeException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
	