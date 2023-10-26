package com.app.core;

import java.time.LocalDate;

import enums.Category;
import enums.Size;

public class Cloth {
	private int clothID;
	private static int idGenerator;
	private Category category;
	private int stock;
	private LocalDate updateDate;
	private Size size;
	private double price;
	private String brand;
	private String color;
	private int discount;
	static {
		idGenerator = 0;
	}
	public Cloth(Category category, int stock, Size size, double price, String brand, String color) {
		super();
		this.category = category;
		this.stock = stock;
		this.size = size;
		this.price = price;
		this.brand = brand;
		this.color = color;
		this.clothID = ++idGenerator;
		this.updateDate = LocalDate.now();
	}

	public Cloth(int clothIDtoSearch) {
		this.clothID = clothIDtoSearch;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cloth) {
			return this.clothID==((Cloth)obj).clothID;
		}
		return false;
	}



	@Override
	public String toString() {
		return "Cloth [clothID=" + clothID + ", category=" + category + ", stock=" + stock + ", updateDate="
				+ updateDate + ", size=" + size + ", price=" + price + ", brand=" + brand + ", color=" + color
				+ ", discount=" + discount + "]";
	}

	public int getClothID() {
		return clothID;
	}

	public void setClothID(int clothID) {
		this.clothID = clothID;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		Cloth.idGenerator = idGenerator;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
		this.setUpdateDate(LocalDate.now());
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
	
	
	
}
