package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//id , firstname,lastname , salary
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthRespDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private double salary;

}
