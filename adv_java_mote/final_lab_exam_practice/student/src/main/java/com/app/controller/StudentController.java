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

import com.app.dto.StudentDto;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.service.CourseService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping
	public Student addNewStudent(@RequestBody StudentDto studentDto) {
		int courseId = studentDto.getCourseId();
		Course course = courseService.getCourseById(courseId);
		
		Student student = new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setScore(studentDto.getScore());
		student.setCourse(course);
		
		return studentService.addNewStudent(student);
	}

	@PutMapping("{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody StudentDto studentDto) {
		Student student = studentService.getStudentById(id);
		
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setScore(studentDto.getScore());
		
		if (studentDto.getCourseId() > 0) {
			Course course = courseService.getCourseById(studentDto.getCourseId());
			student.setCourse(course);
		}
		
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
}