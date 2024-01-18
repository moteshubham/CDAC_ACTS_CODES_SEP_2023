package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentDao;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentDao.findById(id).orElseThrow();
	}	
	
	@Override
	public Student addNewStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public String deleteStudent(Integer id) {
		String mesg = "Student deletion failed !!!! invalid student id";
		if (studentDao.existsById(id)) {
			studentDao.deleteById(id);
			mesg = "Student details deleted ....";
		}
		return mesg;
	}

	

}