package publicationUtils;

import java.util.ArrayList;
import java.util.List;

import static publicationUtils.PublicationValidationRules.validateBook;
import static publicationUtils.PublicationValidationRules.validateTape;

import com.app.core.Publications;

import custom_exception.PublicationException;

public class PopulateData {
	public static List<Publications> populateData() throws PublicationException {
		List<Publications> list = new ArrayList<>();
		list.add(validateBook("states", 100.0, "2002-02-02", 7, 200, list));
		list.add(validateBook("grey", 200.0, "1998-02-02", 6, 200, list));
		list.add(validateBook("water", 25000.0, "2005-02-02", 8, 200, list));
		list.add(validateBook("fire", 564.0, "1977-02-02", 5, 200, list));
		list.add(validateTape("dragon", 245.0, "2000-05-02", 10, 10, list));
		list.add(validateTape("closer", 225.0, "2000-05-10", 9, 5, list));
		list.add(validateTape("hills", 214.0, "2005-01-02", 7, 20, list));
		list.add(validateTape("hills", 214.0, "2018-01-02", 8, 7, list));
		return list;
	}
}
