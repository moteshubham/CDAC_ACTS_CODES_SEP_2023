package com.cdac.core;


public class Box {

	private double depth;
	private double height;
	private double width;
	
	public Box() {
		this(-1);
	}
	
	public Box(double d, double h, double w) {
		this.depth = d;
		this.height = h;
		this.width = w;
	}
	
	public Box(double d) {
		this(d, d, d);
	}
	
	
}
