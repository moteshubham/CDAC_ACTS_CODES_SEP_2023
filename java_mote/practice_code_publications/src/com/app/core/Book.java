package com.app.core;

import java.time.LocalDate;

public class Book extends Publications{
	public int pages;

	public Book(String title, double price, LocalDate publish, int ratings, int pages) {
		super(title, price, publish, ratings);
		this.pages = pages;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [pages=" + pages + ", getPages()=" + getPages() + ", getId()=" + getId() + ", getTitle()="
				+ getTitle() + ", getPrice()=" + getPrice() + ", getPublish()=" + getPublish() + ", getRatings()="
				+ getRatings() + "]";
	}
}
