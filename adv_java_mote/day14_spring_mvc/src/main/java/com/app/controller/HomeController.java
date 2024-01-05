package com.app.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of " + getClass());
	}
	//how to tell SC , following method is going handle a rq ending in /
	@RequestMapping("/")
	//SC will add the  entry : HandlerMapping bean
	//key : /
	//Value : com.app.controller.HomeController.showHomePage
	public String showHomePage() {
		System.out.println("in showHomePage");
		return "/index";//LVN --D.S ----> V.R
	}
}