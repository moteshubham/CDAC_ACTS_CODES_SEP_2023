



import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> l1 = new LinkedList<>();
		Collections.addAll(l1, "one", "two", "three", "four", "five");
		System.out.println(l1);
		Iterator<String> itr = l1.descendingIterator();
		while (itr.hasNext())
			System.out.println(itr.next());

	}

}


