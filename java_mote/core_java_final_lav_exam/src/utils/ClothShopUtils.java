package utils;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

import com.app.core.Cloth;

import custom_exception.ClothValidationException;
import enums.Category;

public class ClothShopUtils {

	public static void setDiscountToCloth(Category category, String brand, List<Cloth> clothes)
			throws InputMismatchException, ClothValidationException {
		boolean found = false;
		for (Cloth c : clothes) {
			if (c.getCategory().equals(category) && c.getBrand().toLowerCase().equals(brand.toLowerCase())) {
				System.out.println("In SetDisco ");
				c.setDiscount(50);
				found = true;
			}
		}
		if (!found) {
			throw new ClothValidationException("Not Found");
		}
	}

	public static void removeOlderClothes(List<Cloth> clothes) {
		Iterator<Cloth> itr = clothes.iterator();
		while (itr.hasNext()) {
			LocalDate beforeTwoMonths = LocalDate.now().minusMonths(2);
			if (itr.next().getUpdateDate().isBefore(beforeTwoMonths)) {
				itr.remove();
			}
		}
	}
}
