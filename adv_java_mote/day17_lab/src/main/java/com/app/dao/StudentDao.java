package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
	// for adding student details: use inherited api :save

}
