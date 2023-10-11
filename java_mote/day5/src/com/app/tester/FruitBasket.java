package com.app.tester;

import java.util.Scanner;
import com.app.fruits.*;


public class FruitBasket {

	public static void main(String[] args) {
		int counter =0;
		Scanner sc = new Scanner(System.in);
 		System.out.println("welcome to FruitBasket\nEnter basket size : ");
		Fruit[] fruits = new Fruit[sc.nextInt()];
		
		boolean exit = false;
		while (!exit) {
			System.out.println("1. Add Mango \n2. Add Orange \n3. Add Apple \n"
					+ "4. Display names of all fruits in the basket.\n"
					+ "5. Display name,color,weight , taste of all fresh fruits , in the basket.\n"
					+ "6. Mark a fruit in a basket , as stale(=not fresh)\n"
					+ "7. Mark all sour fruits stale\n"
					+ "8. Invoke fruit specific functionality (pulp / juice / jam)\n"
					+ "0. Exit");
			switch (sc.nextInt()) {
			case 1:
				if (counter >= 0 && counter < fruits.length) {
//					System.out.println("Is the fruit fresh? true or false");
//					if (sc.nextBoolean() == true) {
//						System.out.println("Enter color weight name");
						fruits[counter++] = new Mango();
//					} else
//						System.out.println("Bring fresh fruit please!!");
				} else
					System.out.println("Basket full");
				break;
			case 2:
				if (counter >= 0 && counter < fruits.length) {
//					System.out.println("Is the fruit fresh? true or false");
//					if (sc.nextBoolean() == true) {
//						System.out.println("Enter color wight name");
						fruits[counter++] = new Orange();
//					} else
//						System.out.println("Bring fresh fruit please!!");
				} else
					System.out.println("Basket full");
			
				break;
			case 3:
				if (counter >= 0 && counter < fruits.length) {
//					System.out.println("Is the fruit fresh? true or false");
//					if (sc.nextBoolean() == true) {
//						System.out.println("Enter color weight name");
						fruits[counter++] = new Apple();
//					} else
//						System.out.println("Bring fresh fruit please!!");
				} else
					System.out.println("Basket full");
				break;
			case 4:
				for(Fruit f : fruits) {
					if(f!=null)
					System.out.println(f.getName());
				}
				break;			
								
			case 5:
				for(Fruit f : fruits) {
					if(f!=null)
					System.out.println(f+f.taste());
				}
				
				break;
				
			case 6:
				System.out.println("Enter indice to make it stale :");
				int index = sc.nextInt() -1 ;
				fruts[index].set

				break;
				
			case 7:
			
				break;
				
			case 8:
				
				break;
				
			default:
				break;
			}
		}

	}

}
/* 4.3 Add suitable constructor
* 
* 4.4 Override toString correctly to return state of all fruits (return only :
* name ,color , weight )
* 

* 
* 4.6 Add specific functionality , in the sub classes In Mango : public void
* pulp() {Display name n color of the fruit + a mesg creating pulp!} In Orange
* : public void juice() {Display name n weight of the fruit + a mesg extracting
* juice!} In Apple : public void jam() {Display name of the fruit + a mesg
* making jam!}
* 
* 4.10 Supply options 1. Add Mango 2. Add Orange 3. Add Apple NOTE : You will
* be ALWAYS adding a fresh fruit in the basket , in all of above options.
* 
* 4. Display names of all fruits in the basket.
* 
* 5. Display name,color,weight , taste of all fresh fruits , in the basket.
* 
* 
* 6. Mark a fruit in a basket , as stale(=not fresh) i/p : index o/p : error
* message (in case of invalid index) or mark it stale
* 
* 7. Mark all sour fruits stale Hint : Use equals() method of the String class.
* 
* 8. Invoke fruit specific functionality (pulp / juice / jam) i/p : index
* Invoke correct functionality (pulp / juice / jam)
* 
* 9. Exit
*/