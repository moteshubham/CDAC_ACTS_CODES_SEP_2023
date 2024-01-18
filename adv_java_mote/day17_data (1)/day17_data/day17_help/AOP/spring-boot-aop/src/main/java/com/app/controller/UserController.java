package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller // mandatory
@RequestMapping("/user") // optional
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add req handling method (to service GET) : to show login form
	@GetMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showLoginForm() {
			return "/user/login";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method(to service POST) : to process the form
	@PostMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=POST
	// value : com.app.controller.UserController.processLoginForm
	// Which req params will be sent from the clnt ? email n pwd
	public String processLoginForm(@RequestParam String email, 
			@RequestParam(name = "password") String pwd, Model map,
			HttpSession hs)
	// SC : String email=request.getParameter("email");
	// String pwd=request.getParameter("password");
	// RECO : Match req param names with method arg names!
	{
		System.out.println("in process login form " + email + " " + pwd);
		try {
			System.out.println("in process login form : user service  "
+ userService.getClass());
			
			// invoke service layer method for user validation
			User user = userService.validateUser(email, pwd);
			// => valid login		
			hs.setAttribute("user_details", user);
			// role checking
			if (user.getRole().equals(Role.ROLE_ADMIN))
				return "redirect:/admin/details";
			//controller --> redirect view name --> D.S
			//D.S --> resp.sendRedirect(resp.encodeRedirectURL("/admin/details");
			//resp is sent to clnt SC 302 | location : /admin/details ,...| body : EMPTY
			//clnt next req --> .... /aop/admin/details
			return "redirect:/customer/details";

		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			map.addAttribute("message", "Invalid Login , Please retry !!!!!!");
			return "/user/login";// Actual View Name(AVN) : /WEB-INF/views/user/login.jsp
		}

	}
}
