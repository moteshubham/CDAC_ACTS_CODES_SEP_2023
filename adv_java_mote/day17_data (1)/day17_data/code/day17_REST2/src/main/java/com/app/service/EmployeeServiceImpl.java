package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.dto.AuthRequestDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dep : dao layer i/f
	@Autowired
	private EmployeeDao empDao;
	// dep : model mapper bean
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public List<Employee> getEmpsByDepartmentName(String deptName) {
		// TODO Auto-generated method stub
		return empDao.findByDepartment(deptName);
	}

	@Override
	public Employee addNewEmp(Employee emp) {
		return empDao.save(emp);
	}

	@Override
	public Employee getEmpById(Long empId) {
		// TODO Auto-generated method stub
		return empDao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!!"));
	}// in case of valid emp id --> rets DETACHED emp to the caller
		// o.w : throws custom exc to the caller

	@Override
	public Employee updateEmpDetails(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.save(emp);
	}// tx.commit --> update

	@Override
	public String deleteEmpDetails(Long empId) {
		String mesg = "Emp deletion failed !!!! invalid emp id";
		if (empDao.existsById(empId)) {
			empDao.deleteById(empId);
			mesg = "Emp details deleted ....";
		}
		return mesg;
	}

	@Override
	public AuthRespDTO authenticateEmp(AuthRequestDTO request) {
		// Extract em n password auth req n then invoke dao's method
		Employee employee = empDao.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid emp login : bad credentials!!!!!"));
		return mapper.map(employee, AuthRespDTO.class);
	}

}
