package com.app.service;

import java.util.List;

import com.app.entities.Course;

public interface CourseService {

	List<Course> getAllCourses();

	Course getCourseById(int id);

	Course addNewCourse(Course student);

	Course updateCourse(Course student);

	String deleteCourse(int id);

}
