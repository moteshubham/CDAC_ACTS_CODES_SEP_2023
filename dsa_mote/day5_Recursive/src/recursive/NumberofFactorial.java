package recursive;
//Write a program to demonstrate the tail recursion for finding the factorial of the number.
import java.util.Scanner;

public class NumberofFactorial {
    public static int factorial(int n, int result) {
        if (n == 0) 
        return result;
        
        return factorial(n - 1, n * result);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int res = factorial(num, 1);
        System.out.println("The factorial of " + num + " is: " + res);
    }
}
