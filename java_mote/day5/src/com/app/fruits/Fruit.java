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
	public double getWeight() {
		return this.weight;
	}
	public String getColor() {
		return this.color;
	}
	public boolean getFresh() {
		return this.fresh;
	}
	public void setFreshStale() {
		 this.fresh = false;
	}
	public String toString() {
		return "name : " + this.name + ", color : " + this.color + ", weight : " + this.weight + "\n";
	}

}


/*


7. Mark all sour fruits stale 
Hint : Use equals() method of the String class.

8. Invoke fruit specific functionality (pulp / juice / jam)
i/p : index
Invoke correct functionality (pulp / juice / jam)


 */