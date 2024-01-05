package com.app.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass // to tell hibernate following class is a
//common super class for all other entities n DO NOT generate any tables for it .
@Getter
@Setter
@ToString
public class BaseEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // customizes col name
	private Long id;
}
