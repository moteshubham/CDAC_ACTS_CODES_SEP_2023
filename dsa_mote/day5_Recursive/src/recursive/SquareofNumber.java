package recursive;
//2. Write a recursive function to find the square of the number.
import java.util.Scanner;

public class SquareofNumber {
    public static int square(int num) {
        if (num == 0) 
        
        	
        return 0;
        
        return square(num - 1) + (2 * num) - 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int res = square(num);
        System.out.println("The square of " + num + " is: " + res);
    }
}
