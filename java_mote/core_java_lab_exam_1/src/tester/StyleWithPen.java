package tester;

import core.com.app.Pen;
import enums.InkColor;
import utils.PopulatePenStore;
import utils.PenStoreHandlingRules;
import static utils.PenStoreHandlingRules.validatePen;
import static utils.PenStoreHandlingRules.checkAvailable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*1. Add new Pen
2. Update stock of aPen
3.Set discount of 20% for all the pens which are not at all sold in last 3 months
4. Remove Pens which are never sold once listed in 9 months

You can define a class Pen with the following fields – 
a.	ID (unique identifier for each Pen, should be generated automatically)
b.	Brand (Example:  Cello, Parker, Reynolds etc.)
c.	Color
d.	InkColor
e.	Material (Example: Plastic, Alloy Steel, Metal etc.)
f.	Stock (Available quantity)
g.	Stock Update Date (it changed every time when admin update stock or user order executed)
h.	Stock Listing Date (date on which product is added to site for sale)
i.	Price (in INR) 
j.	Discounts (in percentage)
*/

public class StyleWithPen {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Map<Integer, Pen> penMap = new HashMap<>();

			penMap.putAll(PopulatePenStore.populateMap());
			// Cello Cyan blue Plastic 50 2023-10-20 2023-10-25 10 10.0
			// Parker grey red Steel 15 2023-10-10 2023-10-18 90 5.0
			// Parker pink black Metal 30 2023-10-15 2023-10-23 20 10.0
			boolean exit = false;
			while (!exit) {

				System.out.println("\nOptions : \n" + "1. Add new Pen \n" + "2. Update stock of a Pen \n"
						+ "3. Set discount of 20% for all the pens which are not at all sold in last 3 months \n"
						+ "4. Remove Pens which are never sold once listed in 9 months \n5. Display all\n"
						+ "0.Exit\n");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter pen details :  brand,  color,  inkColor,  material,  stock,"
										+ " stockListingDate,  price)");
						Pen validatedPen = validatePen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),
								 sc.nextInt());
						penMap.put(validatedPen.getPenID(), validatedPen);

						break;

					case 2:
						System.out.println("Enter PenID to update the stock and the amount : ");
						checkAvailable(sc.nextInt(), penMap, sc.nextInt());
				
						break;

					case 3:
//						3.Set discount of 20% for all the pens which are not at all sold in last 3 months
						
						break;

					case 4:

						break;

					case 5:
						for (Pen p : penMap.values()) {
							System.out.println(p);
						}
						break;

					case 0:
						exit = true;
						break;

					}
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Pls retry....");
					// to read off all pending i/ps
					sc.nextLine();
				}
			}

		} // sc.close()
		System.out.println("main over....");
	}
}
