package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Course;
import com.app.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
    private CourseService courseService;

	@GetMapping(produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> list=courseService.getAllCourses();
		System.out.println(list);
		return ResponseEntity.ok(list);
    }

    @PostMapping(produces = "application/json")
    public String launchNewCourse(@RequestBody Course course) {
    	System.out.println("Course: "+course);
        return courseService.launchNewCourse(course);
    }
}
