package com.app.controlller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;


	@RequestMapping("/add")
	public String addEmployee(Model map, Employee transientEmployee, HttpSession session) {

		try {
			map.addAttribute("mesg",
					employeeService.addEmployeeDetails(transientEmployee, transientEmployee.getEmpId()));
			System.out.println("returned from service layer");
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			e.printStackTrace();
//			session.setAttribute("mesg", e.getMessage());

			return "redirect:/employees/abbrs";
		}
		System.out.println("going to add empoyee form");
		return "/add_employee_form";

	}
	
	
	@RequestMapping("/show")
	public String showEmployee(Model map, Employee transientEmployee, HttpSession session) {
System.out.println("in show employee()");
		try {
			map.addAttribute("list",
					employeeService.viewAllEmployees());
			System.out.println("returned from service layer");
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			e.printStackTrace();
//			session.setAttribute("mesg", e.getMessage());

			return "redirect:/index";
		}
		System.out.println("going to show empoyee form");
		return "/show_employees";

	}

}
