package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// add request handling method to cust details
	@GetMapping("/details")
	public String showCustomerDetails() {
		System.out.println("in cust details");		
		return "/customer/details";
	}

}
