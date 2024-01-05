package com.app.core;

import java.time.LocalDate;

public class Publications {
	private int id;
	private String title;
	private double price;
	private LocalDate publish;
	private int ratings;
	private static int idgenerator = 100;
	
	public Publications(String title, double price, LocalDate publish, int ratings) {
		super();
		this.id = ++idgenerator;
		this.title = title;
		this.price = price;
		this.publish = publish;
		this.ratings = ratings;
	}
	public Publications(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getPublish() {
		return publish;
	}

	public int getRatings() {
		return ratings;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPublish(LocalDate publish) {
		this.publish = publish;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
}
