package com.app.dto;

import java.time.LocalDate;

import com.app.entities.EmpType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class EmployeeRespDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate joinDate;
	private EmpType type;
	private double salary;

}
