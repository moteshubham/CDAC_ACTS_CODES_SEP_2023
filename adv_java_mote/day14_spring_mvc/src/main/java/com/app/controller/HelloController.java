package com.app.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory cls level anno , to tell SC ,
//following class is req handling  spring bean : singleton n eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of " + getClass());
	}
	//how to tell SC , following method is going handle a rq ending in /hello
	@RequestMapping("/hello")
	//SC will add the  entry : HandlerMapping bean
	//key : /hello
	//Value : com.app.controller.HelloController.sayHello
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";//LVN --D.S ----> V.R
	}
}
