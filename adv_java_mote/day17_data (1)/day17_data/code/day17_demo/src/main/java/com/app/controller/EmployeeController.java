package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddEmployeeDTO;
import com.app.dto.EmployeeRespDTO;
import com.app.service.EmployeeService;
import com.app.service.ImageHandlingService;
import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ImageHandlingService imgService;

	// 1. add new emp to existing dept
	// http://host:port/employees , method=POST , request payload : AddEmp dto
	// containing dept id
	@PostMapping
	public ResponseEntity<?> addEmpToExistingDept(@RequestBody @Valid AddEmployeeDTO dto) {
		System.out.println("in add emp " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addNewEmployee(dto));
	}

	// 2. Get all emps by dept id
	// http://host:port/employees/departments/{deptId} , method=GET
	@GetMapping("/departments/{deptId}")
	public ResponseEntity<?> getEmpsByDepartment(@PathVariable Long deptId) {
		System.out.println("in get emps " + deptId);
		List<EmployeeRespDTO> list = employeeService.getAllEmployeesFromDept(deptId);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// emps found
		return ResponseEntity.ok(list);
	}

	// 3. http://host:port/employees/departments/{deptId}/{empId}
	// add req handling method(API end point) to get emp details by emp id n dept id
	// dept id is here just used for validation : H.W

	// 4. upload image
	// http://host:port/employees/images/{empId} , method=POST , req param :
	// multipart file(image data)
	@PostMapping(value = "/images/{empId}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long empId, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in upload img " + empId);
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(empId, imageFile));
	}

	// 5 . serve(download image) of specific emp
	// http://host:port/employees/images/{empId} , method=GET
	@GetMapping(value="/images/{empId}",produces = {IMAGE_GIF_VALUE,
			IMAGE_JPEG_VALUE,IMAGE_PNG_VALUE})
	public ResponseEntity<?> serveEmpImage(@PathVariable Long empId) throws IOException {
		System.out.println("in download img " + empId);
		return ResponseEntity.ok(imgService.downloadImage(empId));
	}
	// 6. Pagination demo
	// Get all emps
	// http://host:port/employees , method=GET
	// req params : pageNumber , def val 0 , optional
	// pageSize : def val 3 , optional

	@GetMapping
	public ResponseEntity<?> getAllEmpsPaginated(@RequestParam(defaultValue = "0", required = false) int pageNumber,
			@RequestParam(defaultValue = "3", required = false) int pageSize) {
		System.out.println("in get all emps " + pageNumber + " " + pageSize);
		List<EmployeeRespDTO> list = employeeService.getAllEmployees(pageNumber, pageSize);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// emps found
		return ResponseEntity.ok(list);
	}

}
