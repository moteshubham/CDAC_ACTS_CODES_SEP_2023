package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class AddEmpToDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println(
					"Enter emp details : firstName,  lastName,  email,  password,  joinDate,	 empType,  salary");
			// create transient entity /pojo
			Employee emp = new Employee(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			//accept dept id
			System.out.println("Enter dept id");			
			System.out.println(empDao.saveEmpDetails(emp,sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
