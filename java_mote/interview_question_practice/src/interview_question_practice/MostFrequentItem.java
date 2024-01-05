package interview_question_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MostFrequentItem {

	public static void myFunction(int[] arr) {

		Map<Integer, Integer> hs = new HashMap<>();
		System.out.println("as");
		for (int i = 0; i < arr.length; i++) {

			if (hs.containsKey(arr[i])) {
				hs.put(arr[i], hs.get(arr[i]) + 1);
			} else {
				hs.put(arr[i], 1);
			}
		}
		System.out.println(hs);
		
		Set<Integer> myList = new HashSet<Integer>(hs.entrySet());
		System.out.println(myList);
		
		//int a = hs.values().stream().map((Integer o1, Integer o2) -> o1.compareTo(o2));
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 1, 2, 1, 4, 3, 3, 3 };
		myFunction(arr);
	}

}
