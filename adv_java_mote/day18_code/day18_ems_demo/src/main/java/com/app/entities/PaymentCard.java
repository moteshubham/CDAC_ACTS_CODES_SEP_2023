package com.app.entities;

import java.time.LocalDate;
import javax.persistence.*;

@Embeddable
public class PaymentCard {
	@Column(name="card_type",length = 20)
	private String cardType;
	@Column(name="exp_date")
	private LocalDate expDate;
	@Column(length = 10)
	private String cvv;
	public PaymentCard() {
		// TODO Auto-generated constructor stub
	}
	public PaymentCard(String cardType, LocalDate expDate, String cvv) {
		super();
		this.cardType = cardType;
		this.expDate = expDate;
		this.cvv = cvv;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "PaymentCard [cardType=" + cardType + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}
	
}
