package com.app.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in home controller");
	}
	
	@RequestMapping("/")
	public String renderIndexPage() {
		System.out.println("in renderIndexPage()");
		return "/index";
	}
}
