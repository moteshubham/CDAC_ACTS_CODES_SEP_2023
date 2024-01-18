package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
  
}
