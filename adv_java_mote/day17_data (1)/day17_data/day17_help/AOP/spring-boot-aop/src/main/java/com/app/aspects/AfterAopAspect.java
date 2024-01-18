package com.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP

//@Aspect
//@Component
@Slf4j
public class AfterAopAspect {

	//private Logger log = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.app.service.*.*(..))",
			returning = "result123")
	public void afterReturning(JoinPoint joinPoint, Object result123) {
		log.info("After Ret advice : {} returned with value {}", joinPoint.getSignature(), result123);
	}

	@After(value = "execution(* com.app.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		// getSignature() : rets entire method signature.
		log.info("After advice : after execution of {}", joinPoint.getSignature());
	}

	@AfterThrowing(value = "execution(* com.app.service.*.*(..))", throwing = "exc")
	public void afterThrowing(Exception exc) {
		log.info("After throwing advice : Exception occurred 123456 : " + exc);
	}
}