package com.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserEntityRepositoryTest {
	// dep
	@Autowired
	private UserEntityRepository userRepo;

	@Autowired
	private PasswordEncoder enc;

	@Test
	void testAddUsers() {
		List<UserEntity> list = List.of(
				new UserEntity("a1", "b1", "a1@gmail.com", enc.encode("12345"), UserRole.ROLE_ADMIN),
				new UserEntity("a2", "b2", "a2@gmail.com", enc.encode("2345"), UserRole.ROLE_CUSTOMER),
				new UserEntity("a3", "b3", "a3@gmail.com", enc.encode("1345"), UserRole.ROLE_USER));
		List<UserEntity> list2 = userRepo.saveAll(list);
		assertEquals(3, list2.size());

	}

}
