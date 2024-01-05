package sets2;

import java.util.HashSet;

import com.app.core.Employee;

public class EmpSet2 {

	public static void main(String[] args) {
		// BBBB AaBB AaAa BBAa
		Employee e1=new Employee("BBBB", "abc1", 10000);
		Employee e2=new Employee("AaBB", "abc1", 10000);
		Employee e3=new Employee("AaAa", "abc1", 10000);
		Employee e4=new Employee("BBAa", "abc1", 10000);
		Employee e5=new Employee("AaAa", "abc1", 10000);
		
		//create empty HS of emps
		HashSet<Employee> emps=new HashSet<>();
		System.out.println("Added "+emps.add(e1));//t , hc : 1, eq : 0
		System.out.println("Added "+emps.add(e2));//t , hc : 1 , eq : 1
		System.out.println("Added "+emps.add(e3));//t , hc : 1 , eq : 2
		System.out.println("Added "+emps.add(e4));//t , hc : 1 , eq : 3
		System.out.println("Added "+emps.add(e5));//f , hc : 1 , eq : 3
			System.out.println("size "+emps.size());//4
		System.out.println("Emps : ");
		for(Employee e : emps)
			System.out.println(e);//detect the dups


	}

}
