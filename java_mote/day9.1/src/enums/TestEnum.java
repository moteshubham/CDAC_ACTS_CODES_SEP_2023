package enums;

import java.util.Scanner;

public class TestEnum {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			//display all available colors to the user
			System.out.println("Available colors : ");
			for(Color c : Color.values())
				System.out.print(c+" ");
			//prompt user to choose one n parse it 
			System.out.println("Choose a color");
			Color chosenColor=Color.valueOf(sc.next().toUpperCase());
			System.out.println("You chose "+chosenColor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("code continues....");

	}

}
