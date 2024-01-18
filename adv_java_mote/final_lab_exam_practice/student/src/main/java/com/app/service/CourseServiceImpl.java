package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseDao;
import com.app.entities.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseDao.findAll();
		//System.out.println(courses.toString());
		return courses;
	}

	@Override
	public Course getCourseById(int id) {
		Course course = courseDao.findById(id).get();
		//System.out.println(course.toString());
		return course;
	}

	@Override
	public Course addNewCourse(Course course) {
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseDao.save(course);
	}

	@Override
	public String deleteCourse(int id) {
		String mesg = "Course deletion failed !!!! invalid course id";
		if (courseDao.existsById(id)) {
			courseDao.deleteById(id);
			mesg = "Course details deleted ....";
		}
		return mesg;
	}

}
