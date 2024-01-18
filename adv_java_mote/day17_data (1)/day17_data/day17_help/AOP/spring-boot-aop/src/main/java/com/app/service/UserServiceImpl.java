package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.pojos.User;

@Service // => class containing B.L
@Transactional // => automatic Tx management (done by spring supplied hibernate tx mgr
				// configured in hibernate-persistece.xml file
public class UserServiceImpl implements IUserService {
	// dependency
	@Autowired // autowire=byType =>SC searches for any spring bean that has imple. IUserDao n
				// supplies it's instance
	private UserDao userDao;

	@Override
	public User validateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndPassword(email, pass)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials!!!!"));
	}

}
