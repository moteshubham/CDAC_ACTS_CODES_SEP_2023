package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * If you don't separate DTOs from Entities : 
 * you will have a to live with a mix up like below !!!!!
 * first name : can't be blank .(min : 4 chars , max =20 chars)
last name : can't be blank 
valid email 
valid strong password (alpha numeric, special character , min 5 max 20)
eg : ((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})
reg amount in the range : 500 ---5000
reg date must be in future

 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class User extends BaseEntity {
	@NotBlank(message = "First name can't be blank")
	@Length(min = 4, max = 20, message = "Invalid first name!!!!!!")
	@Column(name = "first_name", length = 20)
	private String firstName;
	@NotBlank(message = "Last  name can't be blank")
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 20, unique = true)
	@Email(message = "Invalid email format")
	private String email;
	@Column(length = 20)
//	@JsonIgnore : skipped during ser n de-ser
	@JsonProperty(access = Access.WRITE_ONLY) // skipped during ser(=marshalling) n kept during de-ser (un marshalling)
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Password !")
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@NotNull(message = "Role must be supplied")
	private Role role;
	// @Column(name="reg_Date") : will be auto added by Spring Data
	@NotNull(message = "Reg Date must be supplied")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Invalid Date!")
	private LocalDate regDate;
	@NotNull(message = "reg amount is required")
	@Range(min = 500, max = 5000)
	private double regAmount;
	@Column(length = 300)
	private String description;

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// You DON'T need this ctor below typically , I am just using it in a test case
	// , to set up the data !
	public User(String firstName, String lastName, String email, String password, Role role, LocalDate regDate,
			double regAmount, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regDate = regDate;
		this.regAmount = regAmount;
		this.description = description;
	}

}
