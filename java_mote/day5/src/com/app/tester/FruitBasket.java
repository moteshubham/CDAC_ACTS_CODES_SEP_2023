package com.app.tester;

import java.util.Scanner;
import com.app.fruits.*;

public class FruitBasket {

	public static void main(String[] args) {
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to FruitBasket\nEnter basket size : ");
		Fruit[] fruits = new Fruit[sc.nextInt()];

		boolean exit = false;
		while (!exit) {
			System.out.println("\n\n1. Add Mango \n2. Add Orange \n3. Add Apple \n"
					+ "4. Display names of all fruits in the basket.\n"
					+ "5. Display name,color,weight , taste of all fresh fruits , in the basket.\n"
					+ "6. Mark a fruit in a basket , as stale(=not fresh)\n" + "7. Mark all sour fruits stale\n"
					+ "8. Invoke fruit specific functionality (pulp / juice / jam)\n" + "0. Exit\n");
			switch (sc.nextInt()) {
			
			case 1:
				if (counter >= 0 && counter < fruits.length) {
					fruits[counter++] = new Mango();
				} else
					System.out.println("Basket full");
				break;
				
			case 2:
				if (counter >= 0 && counter < fruits.length) {
					fruits[counter++] = new Orange();
				} else
					System.out.println("Basket full");
				break;
				
			case 3:
				if (counter >= 0 && counter < fruits.length) {
					fruits[counter++] = new Apple();
				} else
					System.out.println("Basket full");
				break;
				
			case 4:
				for (Fruit f : fruits) {
					if (f != null)
						System.out.println(f.getName() + " is " + f.getFresh());
				}
				break;

			case 5:
				for (Fruit f : fruits) {
					if (f != null)
						System.out.println(f + f.taste());
				}
				break;

			case 6:
				System.out.println("Enter indice to make it stale :");
				int index = sc.nextInt() - 1;
				if (index >= 0 && index < counter) {
					fruits[index].setFreshStale();
					System.out.println("fruit: " + index + 1 + " marked stale");
				}
				else
					System.out.println("Invalid index");
				break;

			case 7:
				for (int i = 0; i < fruits.length; i++) {
					if(fruits[i].taste().equals("sour") || fruits[i].taste().equals("sweet n sour"));
					fruits[i].setFreshStale();
				}
//				alternative
//				for (int i = 0; i < fruits.length; i++) {
//					if (fruits[i] instanceof Orange || fruits[i] instanceof Orange)
//						fruits[i].setFreshStale();
//				}
				break;

			case 8:
				System.out.println("Enter indice to invoke fruit specific functionality (pulp / juice / jam) :");
				index = sc.nextInt() - 1;

				if (index >= 0 && index < counter) {
					if (fruits[index] instanceof Apple)
						((Apple) (fruits[index])).jam();
					else if (fruits[index] instanceof Orange)
						((Orange) (fruits[index])).juice();
					else
						((Mango) (fruits[index])).pulp();
				} else
					System.out.println("Invalid index");
				break;
				
			case 0:
				exit = true;
				break;
			default:
				System.out.println("bye");
				break;
			}
		}

	}

}
/*
 * 7. Mark all sour fruits stale Hint : Use equals() method of the String class.
 */