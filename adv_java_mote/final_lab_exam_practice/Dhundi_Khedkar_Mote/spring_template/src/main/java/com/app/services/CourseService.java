package com.app.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseDao;
import com.app.pojos.Course;

@Service
@Transactional
public class CourseService {
	
	
	@Autowired
    private CourseDao courseRepository;

	 public List<Course> getAllCourses() {
	        return courseRepository.findAll();
	    }

    public String launchNewCourse(Course course) {
    	
        courseRepository.save(course);
        return "Course launched successfully!";
    }
}
