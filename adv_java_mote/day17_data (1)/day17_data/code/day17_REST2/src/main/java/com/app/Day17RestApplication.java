package com.app;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day17RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day17RestApplication.class, args);
	}
	@Bean //equivalent to <bean id ..../> in xml file
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();	
		modelMapper.getConfiguration().
		setMatchingStrategy(MatchingStrategies.STRICT) 
		//only MATCHING prop names n types between src n dest will be transferred , during the mapping
		.setPropertyCondition(Conditions.isNotNull());
		// only non null properties will be transferred from src --> dest , during the mapping
		return modelMapper;//method rets configured  ModelMapper instance to SC
		//SC registers it as a spring bean n manages it's life cycle.

	}

}
