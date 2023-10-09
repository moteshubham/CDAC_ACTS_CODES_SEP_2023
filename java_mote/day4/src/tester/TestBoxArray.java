package tester;
import java.util.Scanner;
import com.cdac.core.Box;

public class TestBoxArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many boxes to make");
		Box[] boxes = new Box[sc.nextInt()];
		for(Box b : boxes) {
			System.out.println(b);
		}
		System.out.println("Enter box dimensions for");
		for (int i = 0; i < boxes.length; i++) {
			System.out.println("Box number : " + i+1);
			boxes[i] = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());	
		}
		
	}

}
