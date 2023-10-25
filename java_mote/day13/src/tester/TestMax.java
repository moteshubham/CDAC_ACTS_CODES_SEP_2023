package tester;
import java.util.Arrays;
import java.util.List;
import java.lang.Number;
import com.core.find.*;
public class TestMax {

	public static void main(String[] args) {
		List<Integer> newList = Arrays.asList(1,4,34,7,8,9);
		
		FindMax.findMax(newList);
		for (Number n : newList) {
			System.out.println(n.getClass());
		}
	}

}
