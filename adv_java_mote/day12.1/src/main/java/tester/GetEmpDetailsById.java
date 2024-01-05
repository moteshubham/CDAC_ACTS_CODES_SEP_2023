package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class GetEmpDetailsById {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("Enter emp id , to fetch details");
			Employee emp = empDao.getEmpDetailsById(sc.nextLong());
			if (emp != null) {
				System.out.println(emp.getClass());
				System.out.println(emp);
			} else
				System.out.println("Emp id invalid !!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
