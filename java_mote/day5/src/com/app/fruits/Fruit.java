package com.app.fruits;


import com.app.fruits.Apple;
public class Fruit {
	private String color;
	private double weight;
	private String name;
	private boolean fresh;
	
	public Fruit(String c, double w, String n, boolean f) {
		this.color = c;
		this.weight = w;
		this.name = n;
		this.fresh = f;
	}
	
	public String taste() {
		return "no specific taste";
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return "name : " + this.name + ", color : " + this.color + ", weight : " + this.weight + "\n";
	}

}


/*

4.1 Can you arrange Fruit,Apple,Orange,Mango in inheritance hierarchy ?
Use tight encapsulation.

4.2 Properties (instance variables)  : color : String , weight : double , name:String, fresh : boolean

4.3 Add suitable constructor

4.4 Override  toString correctly to return state of all fruits (return only  : name ,color , weight )

4.5 Add a taste() method : public String taste()

For Fruit : Can you identify taste of any general fruit ? NO
So add a taste() with this definition : returns "no specific taste" 

Apple : should return  "sweet n sour"
Mango : should return  "sweet"
Orange : should return  "sour"

4.6 Add specific functionality , in the sub classes
In Mango : public void pulp() {Display name n color of the fruit + a mesg  creating  pulp!}
In Orange : public void juice() {Display name n weight of the fruit + a mesg extracting juice!}
In Apple : public void jam() {Display name of the fruit + a mesg  making jam!}

4.7 Add all of above classes under the package "com.app.fruits"
4.8 Create java application FruitBasket , with main method , as a tester
4.9 Prompt user for the basket size n create suitable data structure

4.10 Supply options
1. Add Mango
2. Add Orange
3. Add Apple
NOTE : You will be ALWAYS adding a fresh fruit in the basket , in all of above options.

4. Display names of all fruits in the basket.

5. Display name,color,weight , taste of all fresh fruits , in the basket.


6. Mark a fruit in a basket , as stale(=not fresh)
i/p : index 
o/p : error message (in case of invalid index) or mark it stale

7. Mark all sour fruits stale 
Hint : Use equals() method of the String class.

8. Invoke fruit specific functionality (pulp / juice / jam)
i/p : index
Invoke correct functionality (pulp / juice / jam)

9. Exit 

 */