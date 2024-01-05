package com.app.service;

import java.util.List;

import com.app.dto.StudentDTO;
import com.app.entities.Student;

public interface StudentService {
	StudentDTO addStudentDetails(StudentDTO dto);

	List<Student> getAllStudentDetails();

}
