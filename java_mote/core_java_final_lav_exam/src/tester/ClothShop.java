package tester;

import static utils.ClothShopUtils.setDiscountToCloth;
import static utils.ClothShopUtils.removeOlderClothes;
import static utils.ClothValidationRules.isClothIDavailable;
import static utils.ClothValidationRules.parseAndValidateCategory;
import static utils.ClothValidationRules.validateCloth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Cloth;

import enums.Category;

public class ClothShop {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Cloth> clothes = new ArrayList<>();
			clothes.add(new Cloth(Category.MENS_SHIRTS, 30, enums.Size.XL, 1600, "Van Heusen", "Yellow"));
			clothes.add(new Cloth(Category.WOMENS_JEANS, 50, enums.Size.L, 900, "Wrangler", "Black"));
			clothes.add(new Cloth(Category.MENS_TSHIRT, 20, enums.Size.S, 1500, "Being Human", "White"));
			clothes.add(new Cloth(Category.WOMENS_JEANS, 50, enums.Size.M, 1200, "Pepe Jeans", "Red"));
			clothes.add(new Cloth(Category.OTHER, 0, enums.Size.M, 120, " Jeans", "Red"));
			clothes.get(0).setUpdateDate(LocalDate.parse("2023-07-01"));
			clothes.get(3).setUpdateDate(LocalDate.parse("2023-04-11"));
			boolean exit = false;
			while (!exit) {
				System.out.println("\n***** WELCOME *****");
				System.out.println("1. Add New Cloth");
				System.out.println("2. Update stock of a Cloth");
				System.out.println("3. Set discpount for all Clothes of given Category and Brand");
				System.out.println("4. Remove Clothes which are out of stock for Last 2 month");
				System.out.println("5. List out Clothes which are out of stock today");
				System.out.println("6. Display all");
				System.out.println("0. Exit");
				System.out.println("Choose an option : ");

				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Enter Category, Stock, Size, Price, Brand, Color");
						Cloth validatedCloth = validateCloth(sc.next(), sc.nextInt(), sc.next(), sc.nextDouble(),
								sc.next(), sc.next(), clothes);
						clothes.add(validatedCloth);
						break;

					case 2:
						System.out.println("Enter ClothId to update its Stock : ");
						int clothIDtoCheck = sc.nextInt() - 1;
						sc.nextLine();
						isClothIDavailable(clothIDtoCheck, clothes);
						Cloth clothToUpdateStock = clothes.get(clothIDtoCheck);
						System.out.println("Enter new Stock size : ");
						int newStock = sc.nextInt();
						sc.nextLine();
						clothToUpdateStock.setStock(newStock);
						System.out.println(clothToUpdateStock);
						break;

					case 3:
						System.out.println("Enter Cloth Category to set Discount : ");
						Category categoryToSetDiscount = parseAndValidateCategory(sc.next());
						System.out.println("Enter Cloth Brand to set Discount : ");
						String brandToSetDiscount = sc.next();
						setDiscountToCloth(categoryToSetDiscount, brandToSetDiscount, clothes);
						System.out.println("Discount  set done ");
						clothes.forEach(c -> System.out.println(c));
						break;

					case 4:
						removeOlderClothes(clothes);
						clothes.forEach(c -> System.out.println(c));
						break;

					case 5:
						System.out.println("Out of Stock!!");
						clothes.stream().filter(c -> c.getStock() == 0).forEach(c -> System.out.println(c));
						break;

					case 6:
						clothes.forEach(c -> System.out.println(c));
						break;

					case 0:
						exit = true;
						System.out.println("Visit next time...");
						break;

					default:
						break;
					}

				} catch (Exception e) {
					System.out.println("ERROR : " + e);
					sc.nextLine();
				}
			}
		}

	}

}
