package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.SignupRequest;
import com.app.entities.UserEntity;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserEntityRepository userRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public SignupRequest registerNewUser(SignupRequest request) {
		//encode pwd
		request.setPassword(encoder.encode(request.getPassword()));
		UserEntity persistentUser = userRepo.save(mapper.map(request, UserEntity.class));
		return mapper.map(persistentUser, SignupRequest.class);
	}

}
