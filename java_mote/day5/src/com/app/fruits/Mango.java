package com.app.fruits;

public class Mango extends Fruit{

	public Mango() {
		super("Yellow", 150.9, "Mango", true);
	}
	public String taste() {
		return "sweet";
	}
	public String toString() {
		return  super.toString();
	}
	public void pulp() {
		System.out.println(this.getName() + ", color: "+this.getColor() +" craeting pulp" );
	}

}
/* 4.3 Add suitable constructor
* 

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