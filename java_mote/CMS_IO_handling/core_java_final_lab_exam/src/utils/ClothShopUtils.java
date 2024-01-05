package utils;

import java.util.List;

import com.app.core.Cloth;

import enums.Category;

public class ClothShopUtils {
	public static void setDiscountToCloth(Category category, String brand, List<Cloth> clothes) {
		for (Cloth c : clothes) {
			if (c.getCategory().equals(category) && c.getBrand().equals(brand)) {
				c.setDiscount(50);
			}
		}

	}
}
