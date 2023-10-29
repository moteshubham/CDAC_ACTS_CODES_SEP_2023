package custom_ordering;

import java.util.Comparator;

import com.app.core.Publications;

public class RatingComparator implements Comparator<Publications>{

	@Override
	public int compare(Publications o1, Publications o2) {
		// TODO Auto-generated method stub
		if(o1.getRatings() > o2.getRatings())
			return -1;
		else if(o1.getRatings() < o2.getRatings())
			return 1;
		return 0;
	}
}
