package tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import custom_exceptions.DrivingLicenceExpiredException;
import custom_exceptions.SpeedOutOfRangeException;
import utils.VehicleValidationRules;

public class Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the speed");
			VehicleValidationRules.validateSpeed(sc.nextInt());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("Enter the licence expiry date");
			Date expDate = sdf.parse(sc.next());
			VehicleValidationRules.checkDrivingLicenceExpiry(expDate);
			
		} catch (SpeedOutOfRangeException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (DrivingLicenceExpiredException p) {
			System.out.println(p);
			p.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	

}
	

//
//4. Optional work
//Add another validation rule,  (in addition to speed checking) , in VehicleValidationRules class
//Check Driving license expiry
//I/p : License expiry date (in string form, using scanner)
//O/P : in case of success , Valid License OR throw custom exception with suitable err mesg .
//Now modify TestSpeed tester , to validate both rules