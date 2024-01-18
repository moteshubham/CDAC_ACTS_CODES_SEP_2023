package com.app.service;

import com.app.dto.SignupRequest;

public interface UserService {
SignupRequest registerNewUser(SignupRequest request);
}
