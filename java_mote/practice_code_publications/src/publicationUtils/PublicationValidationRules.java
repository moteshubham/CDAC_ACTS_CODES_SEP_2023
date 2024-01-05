package publicationUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.app.core.Book;
import com.app.core.Publications;
import com.app.core.Tape;

import custom_exception.PublicationException;

public class PublicationValidationRules {
	
	public static void checkForDups(String title, List<Publications> pubs) 
	throws PublicationException{
		Publications pub = new Publications(title);
		if(pubs.contains(pub)) {
			throw new PublicationException("Title already Exists!");
		}
	}
	
	public static int validateRating(int ratings) throws PublicationException {
		if(ratings > 11 || ratings < 0) {
			throw new PublicationException("Invalid Rating!");
		}
		return ratings;
	}
	
	public static LocalDate parseDate(String publish) throws DateTimeParseException {
		return LocalDate.parse(publish);
	}
	
	public static Publications validateBook(String title, double price, String publish, int ratings, int pages, List<Publications> pubs) throws PublicationException {
		checkForDups(title, pubs);
		LocalDate date = parseDate(publish);
		int rating = validateRating(ratings);
		return new Book(title, price, date, rating, pages);
	}
	
	public static Publications validateTape(String title, double price, String publish, int ratings, int minutes, List<Publications> pubs) throws PublicationException {
		checkForDups(title, pubs);
		LocalDate date = parseDate(publish);
		validateRating(ratings);
		int rating = validateRating(ratings);
		return new Tape(title, price, date, rating, minutes);
	}
	
	public static boolean Item5YrsOld(LocalDate d) {
		LocalDate today = LocalDate.now();
		int years = Period.between(d, today).getYears();
		if(years == 5)
			return true;
		return false;	
	}
	
}
