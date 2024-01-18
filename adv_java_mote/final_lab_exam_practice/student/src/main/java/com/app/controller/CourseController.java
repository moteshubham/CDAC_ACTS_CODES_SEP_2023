package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable int id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping
	public Course addNewCourse(@RequestBody Course course) {
		return courseService.addNewCourse(course);
	}

	@PutMapping("{id}")
	public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
		course.setCourseId(id);
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("{id}")
	public String deleteCourse(@PathVariable int id) {
		return courseService.deleteCourse(id);
	}
}
