package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	// add a method for user validation
	User validateUser(String email, String pass);
}
