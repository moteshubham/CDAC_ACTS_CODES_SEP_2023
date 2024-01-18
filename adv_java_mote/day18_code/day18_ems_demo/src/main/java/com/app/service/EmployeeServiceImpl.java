package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddEmployeeDTO;
import com.app.dto.EmployeeRespDTO;
import com.app.entities.Address;
import com.app.entities.Department;
import com.app.entities.Employee;
import com.app.entities.Project;
import com.app.repository.AddressRepository;
import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dep
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository adrRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<EmployeeRespDTO> getAllEmployeesFromDept(Long deptId) {
		List<Employee> empList = empRepo.findByDeptId(deptId);
		return empList.stream() // Stream<Emp>
				.map(emp -> mapper.map(emp, EmployeeRespDTO.class)) // Stream<DTO>
				.collect(Collectors.toList());
	}

	@Override
	public String deleteEmpDetails(Long empId) {
		// checking if adr is assigned for this emp , using emp id (=adr id : since
		// @MapsId)
		Optional<Address> optionalAdr = adrRepo.findById(empId);
		if (optionalAdr.isPresent()) // child rec : adr exists ,so first delete that
			adrRepo.delete(optionalAdr.get());
		// what is the relationship between Emp n Project ?
		// Employee *<--------->* Project : both are parents , child : join table
		// (project_emps)
		// You will have to delete those links in the join table , for the emp assigned
		// to the project first n then delete parent emp record
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));

		Iterator<Project> projectItr = emp.getProjects().iterator();
		while (projectItr.hasNext())
			projectItr.next().getEmps().remove(emp);
		empRepo.delete(emp);
		return "Emp Details deleted....";
	}

	@Override
	public EmployeeRespDTO addNewEmployee(AddEmployeeDTO dto) {

		// validate confirm password --o.w throw the exc
		if (dto.getConfirmPassword().equals(dto.getPassword())) {
			// validate dept --o.w throw the exc
			Department dept = deptRepo.findById(dto.getDeptId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept id !!!"));
			// dept : PERSISTENT
			// set up a bi dir relationship
			Employee employee = mapper.map(dto, Employee.class);
			dept.addEmployee(employee);// cascade on save
			// IMPORTANT : since you have not explicitly called save : hib has NOT YET
			// assigned the id
			// only for sending correct id to the REST clnt --> call save
			// map entity --> dto n return
			return mapper.map(empRepo.save(employee), EmployeeRespDTO.class);
		} else
			throw new ApiException("Passwords don't match!!!!!");

	}

	@Override
	public EmployeeRespDTO updateEmployee(Long empId, AddEmployeeDTO dto) {
		// validate if emp exists by id
		Employee emp = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emo ID , Emp not found !!!!"));
		// => emp exists
		// validate confirm password
		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			Department dept = deptRepo.findById(dto.getDeptId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
			// dto contains the updates , so apply it --> to entity
			mapper.map(dto, emp);// but after this id : null
			emp.setId(empId);// so setting it again
			// System.out.println("after mapping " + emp);
			dept.addEmployee(emp);
			return mapper.map(emp, EmployeeRespDTO.class);
		}
		throw new ApiException("Passwords don't match");

	}

	@Override
	public EmployeeRespDTO getEmpDetails(Long deptId, Long empId) {
		Employee employee = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		if (employee.getDept().getId() != deptId)
			throw new ResourceNotFoundException("Dept id does not match !!!");
		return mapper.map(employee, EmployeeRespDTO.class);
	}

	@Override
	public List<EmployeeRespDTO> getAllEmployees(int pageNumber, int pageSize) {
		//Creates a PageRequest(imple class of Pageable : i/f for pagination) based upon page no n size
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		//fetches the Page of Emps --> getContent() --> List<Emp>
		List<Employee> empList = empRepo.findAll(pageable).getContent();
		return empList.stream().
				map(emp -> mapper.map(emp, EmployeeRespDTO.class))
				.collect(Collectors.toList());
	}

}
