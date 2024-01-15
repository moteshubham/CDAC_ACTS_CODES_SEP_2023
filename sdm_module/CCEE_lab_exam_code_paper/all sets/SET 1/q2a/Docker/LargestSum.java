public class LargestSum {
    public static void main(String[] args) {
        // Initialize three integers
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;

        // Find the largest of the three numbers
        int largest = Math.max(num1, Math.max(num2, num3));

        // Calculate the sum of the largest number
        int sum = largest + largest + largest;

        // Display the sum
        System.out.println("The sum of the largest number is: " + sum);
    }
}