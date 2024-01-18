package com.app.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;

@Service("image_db")
@Transactional
public class ImageHandlingServiceImplDB implements ImageHandlingService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public ApiResponse uploadImage(Long empId, MultipartFile image) throws IOException {
		// get emp from emp id
		Employee emp = empRepo.findById(empId).
				orElseThrow(() -> 
				new ResourceNotFoundException("Invalid emp ID!!!!"));
		// emp found --> PERSISTENT
		// to store the img directly in DB as a BLOB
		emp.setImage(image.getBytes());
		return new ApiResponse("Image file uploaded successfully for emp id " + empId);
	}

	@Override
	public byte[] downloadImage(Long empId) throws IOException {
		// get emp by id
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp ID!!!!"));
		// emp found --> PERSISTENT
		return emp.getImage();
	}

}
