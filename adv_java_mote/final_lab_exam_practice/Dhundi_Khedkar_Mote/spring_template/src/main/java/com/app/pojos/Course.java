package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long id;
    
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private double fees;
    private int minScore;
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public double getFees() {
		return fees;
	}



	public void setFees(double fees) {
		this.fees = fees;
	}



	public int getMinScore() {
		return minScore;
	}



	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}



	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Course(String title, LocalDate startDate, LocalDate endDate, double fees, int minScore) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	}



	@Override
	public String toString() {
		return "Course [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", fees="
				+ fees + ", minScore=" + minScore + "]";
	}

    
    
}
