// Java program to demonstrate assigning 
// of object reference variables 
java.lang.*;
// Box class 
class Box 
{ 
	double width; 
	double height; 
	double depth; 
} 

// Driver class 
public class Test 
{ 
	// Driver method 
	public static void main(String[] args) 
	{ 
		// creating box object 
		Box b1 = new Box(); 
		
		// assigning b2 to b1 
		Box b2 = b1; 



		
		// height via b1 and b2 
		System.out.println(b1.height); 
		System.out.println(b2.height); 
		
		// changing height via b2 
		b2.height = 20; 
		
		// height via b1 and b2 
		// after modification through b2 
		System.out.println(b1.height); 
		b1 = null;
		System.out.println(b2.height); 
System.gc()
	} 
	
} 
