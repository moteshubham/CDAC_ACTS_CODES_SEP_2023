package arrays;

import java.util.Scanner;

/*
 * Objective -- Accept no of data samples(of type double)
 *  from User(using scanner)
Create suitable array & display it using for-loop , 
to confirm default values.

 */
public class TestPrimitiveArray {

	public static void main(String[] args) {
		//create scanner class instance
		Scanner sc=new Scanner(System.in);
		System.out.println("cls loaded for scanner "+sc.getClass());//java.util.Scanner
		System.out.println("Enter how many double values to enter");
		double[] doubleArray;
		doubleArray=new double[sc.nextInt()];
		System.out.println("cls loaded for the array "+doubleArray.getClass());//[D
		//attach for loop , to display array contents
		System.out.println("Def contents of the array");
		for(int i=0;i<doubleArray.length;i++)
			System.out.print(doubleArray[i]+" ");
		sc.close();
		
	}

}
