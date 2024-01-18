package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;

@RestController // =@Controller+@RespBody
public class TestController {
	public TestController() {
		System.out.println("in ctor " + getClass());
	}
	// a method to test simple API : rets List<Integer>
	// URL : http://host:port/test
	@GetMapping("/test")
	public List<Integer> testMe() {
		System.out.println("in test me");
			return List.of(1,2,3,5,6,7);
	}
}
