package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import core.com.app.Pen;
import enums.InkColor;

public class PopulatePenStore {
	public static Map<Integer, Pen> populateMap() {
		Map<Integer, Pen> populatedMap = new HashMap<Integer, Pen>();
		populatedMap.put(1, new Pen("Cello", "Cyan", InkColor.BLUE, "Plastic", 50,
				LocalDate.parse("2023-10-20"), LocalDate.parse("2023-10-25"), 10));
		populatedMap.put(2, new Pen("Parker", "Grey", InkColor.RED, "Steel", 50,
				LocalDate.parse("2023-10-10"), LocalDate.parse("2023-10-18"), 90));
		populatedMap.put(3, new Pen("Reynolds", "Pink", InkColor.BLACK, "Metal", 30,
				LocalDate.parse("2023-10-15"), LocalDate.parse("2023-10-23"), 20));
		// Parker grey red Steel 15 2023-10-10 2023-10-18 90 5.0
		// Parker pink black Metal 30 2023-10-15 2023-10-23 20 10.0
		return populatedMap;
//		(String brand, String color, InkColor inkColor, String material, int stock, LocalDate stockUpdateDate,
//				LocalDate stockListingDate, int price, double discount)
	}
}
