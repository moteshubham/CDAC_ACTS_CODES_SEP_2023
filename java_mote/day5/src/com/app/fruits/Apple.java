package com.app.fruits;

public class Apple extends Fruit {

	public Apple() {
		super("Red", 101.3, "Apple", true);
	}

	public String taste() {
		return "sweet n sour";
	}

	public String toString() {
		return super.toString();
	}

	public void jam() {
		System.out.println(this.getName() + " : making jam");
	}
}

/*
 * 

 * 
 * 7. Mark all sour fruits stale Hint : Use equals() method of the String class.
 * 
 * 8. Invoke fruit specific functionality (pulp / juice / jam) i/p : index
 * Invoke correct functionality (pulp / juice / jam)

 */