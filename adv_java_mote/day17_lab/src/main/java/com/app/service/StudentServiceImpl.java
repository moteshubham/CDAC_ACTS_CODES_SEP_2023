package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.dto.StudentDTO;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	// dep : ModelMapper
	@Autowired
	private ModelMapper mapper;

	@Override
	public StudentDTO addStudentDetails(StudentDTO dto) {
		// adding student to database
		// dto --> entity
		Student student = mapper.map(dto, Student.class);
		// entity --> dto
		return mapper.map(studentDao.save(student), StudentDTO.class);

	}

	@Override
	public List<Student> getAllStudentDetails() {
		
		return studentDao.findAll();
	}

}
