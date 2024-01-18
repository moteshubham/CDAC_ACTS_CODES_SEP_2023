package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student addNewStudent(Student student);

	Student updateStudent(Student student);

	String deleteStudent(Integer id);

	Student getStudentById(int id);

}
