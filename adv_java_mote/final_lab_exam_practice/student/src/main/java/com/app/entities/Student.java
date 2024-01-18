package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column( length = 20)
	private String firstName;
	@Column( length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@ManyToOne(optional = false /*, fetch = FetchType.LAZY */)
	@JoinColumn(name = "course_id")
//	@JsonIgnore
	private Course course;	
	@Column
	private int score;
}
