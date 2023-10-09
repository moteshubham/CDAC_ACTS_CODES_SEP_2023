package arrays;

import java.util.Scanner;

/*Objective -- Accept no of data samples(of type double) from User(using scanner)
Create suitable array & display it using for-loop , to confirm default values.

Accept data from User(scanner) & store it in the array.
Display array data using  for loop.

Display array data using for-each loop

for-each loop(enhanced for loop)
syntax
eg : Display array data using for-each loop
for(int i : data) //i=data[0] ,i=data[1],.....i=data[data.length-1]
 sop(i);*/

public class TestPrimArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many elemnts you want in array");
		double[] doubleArray = new double[sc.nextInt()];
		System.out.println("Enter array elements.");
		for (int i = 0; i < doubleArray.length; i++) {
			doubleArray[i] = sc.nextDouble();		
		}
		System.out.println("Entered elemnts are : ");
		for (int i = 0; i < doubleArray.length; i++) {
			System.out.println(doubleArray[i]);
		}
		for (double  i: doubleArray) {
			System.out.println(i);
		}
		sc.close();
	}

}
