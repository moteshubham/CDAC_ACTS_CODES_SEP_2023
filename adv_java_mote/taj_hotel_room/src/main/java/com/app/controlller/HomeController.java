
package com.app.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {



	public HomeController() {
		System.out.println("in ctor of home controller");
		
	}
	
	@RequestMapping("/")

	public String showHomePage() {
		return "/index";
	}
}
