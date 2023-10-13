package var_args;

public class Test1 {

	public static void main(String... args) {
		// no args
		displayDetails();
		System.out.println("-----------------------");
		// arg[]
		displayDetails(new Fruit[] { new Apple(), new Orange() });
		System.out.println("-----------------------");
		// fruits : , separated
		displayDetails(new Orange(),new Apple());
		//printf : formatted printing : Emp details
		System.out.printf("ID %d Name %s Salary %.1f %n"
				,101,"Madhura",12345.6789);
		
	}

//add a static method to display details(toString) of all the fruits
	static void displayDetails(Fruit... fruits) {
		for (Fruit f : fruits)
			System.out.println(f);
	}
}

class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}
