package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emps") // to specify table name
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Employee extends BaseEntity {
	//@JsonProperty(value = "fn")
	@Column( length = 20) // varchar(20)
	private String firstName;//dervied col name : first_name
	@Column( length = 20)
	private String lastName;
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	@Column(length = 20, nullable = false) // NOT NULL constraint
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;	
	private LocalDate joinDate;
	private double salary;
	@Column(length = 30)
	private String location;
	@Column(length = 30)
	private String department;	
}
