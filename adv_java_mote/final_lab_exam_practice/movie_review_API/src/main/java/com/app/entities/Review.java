package com.app.entities;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String content;
	@Column
	private Double rating;
	@Column
	private int userid;
	@Column
	private int movieid;
	
	
}
