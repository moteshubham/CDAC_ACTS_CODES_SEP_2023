package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "dob", callSuper = true) // base entity ka tostring super call krega
@Entity
@Table(name = "students")
public class Student extends BaseEntity {
// id, Rollno, StudentFirstName, StudentLastName, City, CourseName,DoB
	@Column(unique = true, length = 20)
	private String rollNo;
	@Column(length = 20)
	private String studentFirstName;
	@Column(length = 20)
	private String studentLastName;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String courseName;
	private LocalDate dob;

}
