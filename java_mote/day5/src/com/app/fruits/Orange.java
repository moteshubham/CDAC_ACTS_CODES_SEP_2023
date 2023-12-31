package com.app.fruits;

public class Orange extends Fruit{
	
	public Orange() {
		super("Orangish", 80.2, "Orange", true);
	}
	
	public String taste() {
		return "sour";
	}
	public String toString() {
		return  super.toString();
	}
	public void juice() {
		System.out.println(this.getName()+", weight: "+this.getWeight()+" making extracting juice");
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
* 4.7 Add all of above classes under the package "com.app.fruits" 4.8 Create
* java application FruitBasket , with main method , as a tester 4.9 Prompt user
* for the basket size n create suitable data structure
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