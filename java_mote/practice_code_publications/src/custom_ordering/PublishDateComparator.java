package custom_ordering;

import java.util.Comparator;

import com.app.core.Publications;

public class PublishDateComparator implements Comparator<Publications>{

	@Override
	public int compare(Publications o1, Publications o2) {
		// TODO Auto-generated method stub
		if(o1.getPublish().compareTo(o2.getPublish()) > 0)
			return -1;
		else if(o1.getPublish().compareTo(o2.getPublish()) < 0)
			return 1;
		return 0;
	}
}
