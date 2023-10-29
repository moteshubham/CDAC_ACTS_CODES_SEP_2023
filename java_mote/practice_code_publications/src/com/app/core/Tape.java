package com.app.core;

import java.time.LocalDate;

public class Tape extends Publications{
	public int minutes;

	public Tape(String title, double price, LocalDate publish, int ratings, int minutes) {
		super(title, price, publish, ratings);
		this.minutes = minutes;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return "Tape [minutes=" + minutes + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getPrice()="
				+ getPrice() + ", getPublish()=" + getPublish() + ", getRatings()=" + getRatings() + "]";
	}
}
