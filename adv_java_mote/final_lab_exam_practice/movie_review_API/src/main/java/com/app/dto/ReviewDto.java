package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReviewDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	private String content;

	private Double rating;

	private int userid;

	private int movieid;
}
