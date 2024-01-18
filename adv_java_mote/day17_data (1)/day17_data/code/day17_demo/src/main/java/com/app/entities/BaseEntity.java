package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass // to tell hib , not to create any tables n other entities will extend from it
@Getter
@Setter
public class BaseEntity {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
	private Long id;	
}
