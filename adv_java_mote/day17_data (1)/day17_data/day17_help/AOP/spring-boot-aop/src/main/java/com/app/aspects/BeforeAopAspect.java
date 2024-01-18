package com.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


//@Aspect // to tell SC , class below contains cross cutting concerns(i.e repeatative
//task)
//@Component // to tell SC : it's a spring bean (i.e manage it's life cycle)
@Slf4j
public class BeforeAopAspect {

//	private Logger logger = LoggerFactory.getLogger(BeforeAopAspect.class);

	// What kind of method calls It would intercept ? : Methods having ANY ret type
	// , from the pkg : com.app.service , any class having any args
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	@Before("execution(* com.app.service.*.*(..))")
	public void before12345(JoinPoint joinPoint) {
		// Advice
		log.info(" Before Advice : Intercepting Service Layer ");
		log.info(" Executing  {}", joinPoint);
	}
}