package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
	private String mesg;
	private LocalDate timestamp;

	public ApiResponse(String mesg) {
		super();
		this.mesg = mesg;
		this.timestamp = LocalDate.now();
	}

}
