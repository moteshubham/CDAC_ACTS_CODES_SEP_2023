package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	String name;

	String productCode;

	LocalDate mfgDate;

	Category category;
}
