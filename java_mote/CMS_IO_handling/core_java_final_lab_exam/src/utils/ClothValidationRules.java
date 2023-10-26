package utils;

import java.text.ParseException;
import java.util.List;

import com.app.core.Cloth;

import custom_exception.*;
import enums.Category;
import enums.Size;

public class ClothValidationRules {

	public static void isClothIDavailable(int clothIDtoSearch, List<Cloth> clothes) throws ClothValidationException {
		Cloth clothNew = new Cloth(clothIDtoSearch);
		if (!clothes.contains(clothNew)) {
			throw new ClothValidationException("Cloth ID not found!!!");
		}
		System.out.println("Cloth ID is present");
	}

	public static Category parseAndValidateCategory(String category) throws ParseException {
		return enums.Category.valueOf(category);
	}

	public static Size parseAndValidateSize(String Size) throws ParseException {
		return enums.Size.valueOf(Size);
	}

	public static double validatePrice(double price) throws InvalidPriceException {
		if (price <= 0) {
			throw new InvalidPriceException("Enter Valid Price");
		}
		return price;
	}

	public static int validateStock(int stock) throws InvalidStockExcpetion {
		if (stock <= 0) {
			throw new InvalidStockExcpetion("Enter Valid Stock");
		}
		return stock;
	}

	public static Cloth validateCloth(String category, int stock, String size, double price, String brand, String color,
			List<Cloth> clothes) throws ParseException, InvalidPriceException, InvalidStockExcpetion {
//		checkDup( clothID, clothes);

		Category validatedCategory = parseAndValidateCategory(category);
		Size validatedSize = parseAndValidateSize(size);
		double validatedPrice = validatePrice(price);
		int validatedStock = validateStock(stock);
		Cloth validatedCloth = new Cloth(validatedCategory, validatedStock, validatedSize, validatedPrice, brand,
				color);
		return validatedCloth;
	}
}
