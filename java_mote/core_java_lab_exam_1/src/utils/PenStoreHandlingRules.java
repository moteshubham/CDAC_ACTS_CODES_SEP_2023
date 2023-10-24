package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

import core.com.app.Pen;
import custom_exceptions.PenNotFoundException;
import custom_exceptions.ValidationException;
import enums.InkColor;

public class PenStoreHandlingRules {

	public static void checkAvailable(int penID, Map<Integer, Pen> penMap, int amount) throws PenNotFoundException {
		if (penMap.containsKey(penID)) {
			penMap.get(penID).setStock(amount);
			System.out.println("Stock updated for : "+penID + " to : "+amount);
		}
		else
		throw new PenNotFoundException("Pen Not Found");
	}

	public static InkColor checkInkColor(String inkClr) throws ValidationException {
		return InkColor.valueOf(inkClr.toUpperCase());
	}

	public static LocalDate parseAndValidateDate(String date) throws DateTimeParseException {
		return LocalDate.parse(date);
	}

	public static Pen validatePen(String brand, String color, String inkClr, String material, int stock,
			String stockUpdateDate, String stockListingDate, int price, double discount)
			throws ValidationException, DateTimeParseException {
		InkColor inkColor = checkInkColor(inkClr);
		LocalDate stockListedDate = parseAndValidateDate(stockListingDate);
		LocalDate stockUpdatedDate = parseAndValidateDate(stockUpdateDate);
		Pen newPen = new Pen(brand, color, inkColor, material, stock, stockUpdatedDate, stockListedDate, price);
		return newPen;

	}
}
