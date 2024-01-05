package tester;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Number;
import com.core.find.*;
public class TestMax {

	public static void main(String[] args) {
		List<Integer> newList = new ArrayList<>(Arrays.asList(1,4,34,7,8,9));
		
		List<Double> newList2 = new ArrayList<>(Arrays.asList(1.1,4.4,3.4,4.7,4.8,3.9));
		
		
		FindMax.findMax(newList);
		FindMax.findMax(newList2);
		
		
		
		for (Number n : newList) {
			System.out.println(n.getClass());
		}
	}

}
