package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Student;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
