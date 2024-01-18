package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentDTO {
	@JsonProperty(access = Access.READ_ONLY) //used during serialization
	private Long id;
	@NotBlank
	//assume : json prop name : deptLocation
	@JsonProperty(value = "deptLocation")
	private String location;
	@NotBlank
	private String deptName;
}
