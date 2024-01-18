package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
	//add a finder to get user details by it's email
	Optional<UserEntity> findByEmail(String email);

}
