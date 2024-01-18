package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Role;
import com.app.pojos.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class TestUserDao {
	@Autowired
	private UserDao userDao;

	@Test
	void testSaveUsers() {
		List<User> list = List.of(
				new User("Rama1", "Kher1", "rama1@gmail.com", "abc#1234", Role.ROLE_ADMIN, LocalDate.of(2020, 10, 20),
						1000, "admin desc"),
				new User("Mihir1", "Rao1", "mihir@gmail.com", "xyz#1234", Role.ROLE_CUSTOMER, LocalDate.of(2021, 1, 20),
						2000, "customer desc"));
		List<User> persistentEntities = userDao.saveAll(list);
//JUnit Testing API of Assertions class 
		// static method public void assertEquals(int expected,int actual);
		assertEquals(2, persistentEntities.size());
		//added  as extra confirmation , print the result (NOT RECO in test case !)
		persistentEntities.forEach(System.out::println);
	}

}
