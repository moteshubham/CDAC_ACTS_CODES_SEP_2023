package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class TestEmployeeDao {
	@Autowired
	private EmployeeDao empDao;

	@Test // to specify a method as the test case
	void testAddEmps() {
		List<Employee> list = List.of(
				new Employee("a1", "b1", "a1@gmail.com", "1234", LocalDate.parse("2020-10-20"), 34567, "Pune", "RnD"),
				new Employee("a2", "b2", "a2@gmail.com", "2234", LocalDate.parse("2020-11-20"), 44567, "Pune", "RnD"),
				new Employee("a3", "b3", "a3@gmail.com", "1274", LocalDate.parse("2023-10-20"), 14567, "Pune", "RnD"),
				new Employee("a4", "b4", "a4@gmail.com", "2234", LocalDate.parse("2022-10-20"), 40567, "Mumbai",
						"Finance"));
		List<Employee> savedEmps = empDao.saveAll(list);
		//1st arg : expected , 2nd arg :actual
		assertEquals(4, savedEmps.size());
	}

}
