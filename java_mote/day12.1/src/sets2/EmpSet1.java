package sets2;

import java.util.HashSet;

import com.app.core.Employee;

public class EmpSet1 {

	public static void main(String[] args) {
		Employee e1=new Employee("rnd-001", "abc1", 10000);
		System.out.println("e1 : " + e1.hashCode());
		Employee e2=new Employee("rnd-001", "abc1", 10000);
		System.out.println(e2.hashCode());
		Employee e3=new Employee("rnd-001", "abc1", 10000);
		Employee e4=new Employee("rnd-006", "abc1", 10000);
		Employee e5=new Employee("rnd-005", "abc1", 10000);
		Employee e6=new Employee("rnd-004", "abc1", 10000);
		Employee e7=new Employee("rnd-002", "abc1", 10000);
		//create empty HS of emps
		
	System.out.println("================");
		HashSet<Employee> emps=new HashSet<>();
		System.out.println("Added "+emps.add(e1));//t
	System.out.println("\n");
		System.out.println("Added "+emps.add(e2));//f
		System.out.println("\n");
		System.out.println("Added "+emps.add(e3));//f
		System.out.println("\n");
		System.out.println("Added "+emps.add(e4));//t
		System.out.println("\n");
		System.out.println("Added "+emps.add(e5));//t
		System.out.println("\n");
		System.out.println("Added "+emps.add(e6));//t
		System.out.println("\n");
		System.out.println("Added "+emps.add(e7));//t
		System.out.println("\n");
		System.out.println("size "+emps.size());//5
		System.out.println("Emps : ");
		for(Employee e : emps)
			System.out.println(e);//detect the dups


	}

}
