package recursive;
//Write a method to check whether the number is palindrome or not?
import java.util.Scanner;

public class PalindromeorNot  {
    public static boolean isPalindrome(int num) {
        int temp = num, reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return num == reverse;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        if (isPalindrome(num)) System.out.println(num + " is a palindrome number.");
        else System.out.println(num + " is not a palindrome number.");
    }
}
