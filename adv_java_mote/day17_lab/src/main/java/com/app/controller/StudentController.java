package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.entities.Student;
import com.app.service.StudentService;

//@CrossOrigin   : if using react as front end
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("in ctor of student controller : " + getClass());
	}
//	1. Add Student details from Postman / Swagger
//	Validation Rules: student name must be supplied , city string len must < 15 , DoB must be in the past.
//	2. Send all student details from backend to REST clnt
//	3. Accept course name from user and display all Students' Rollno and Student Name enrolled for that course.
//	4. Change CourseName of the student specified by id.
//	5. Delete Studentdetails  , specified by id.

	// add REST API end point to add student details
	// URL: http://host:port/students, method=POST
	// request payload: StudentDTO : no id
	// resp: Success :-- SC 201, StudentDTO : id
	// resp : err -- SC 500, ApiResp DTO
	@PostMapping
	public ResponseEntity<?> addNewStudent(@RequestBody StudentDTO dto) {
		System.out.println("in add student " + dto);

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudentDetails(dto));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}

	}

	@GetMapping
	public List<Student> getAllStudentDetails() {
		System.out.println("in getAllStudentDetails");
		return studentService.getAllStudentDetails();
	}

}
