package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.dto.SignupRequest;
import com.app.jwt_utils.JwtUtils;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserAuthController {
//dep :
	@Autowired
	private AuthenticationManager mgr;
	@Autowired
	private JwtUtils utils;

	@Autowired
	private UserService userService;

	// add end point for user registration
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody SignupRequest request) {
		System.out.println("in user reg " + request);
		return ResponseEntity.ok(userService.registerNewUser(request));
	}

	/*
	 * request payload : Auth req DTO : email n password resp payload : In case of
	 * success : Auth Resp DTO : mesg + JWT token + SC 200 IN case of failure : SC
	 * 401
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody @Valid SigninRequest request) {
		System.out.println("in sign in " + request);
		// invoke autheticate(...) of Authenticate for auth
		Authentication principal = mgr
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		// generate JWTS
		String jwtToken = utils.generateJwtToken(principal);
		return ResponseEntity.ok(new SigninResponse(jwtToken, "User authentication success!!!"));
	}
}
