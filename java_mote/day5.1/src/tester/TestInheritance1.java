package tester;

import inheritance.*;

//Test ctro invocation , in inh hierarchy + super(...)
public class TestInheritance1 {

	public static void main(String[] args) {
		// super ref --> sub class obj
		Person p = new Student("Aditya", "Sethi", 2022, "DAC", 1234567, 80);// upcasting
		System.out.println(p);//p.toString()
		// create faculty object
		// super class ref --> sub class obj(INDIRECT referencing)
		p = new Faculty("Rama", "Kher", 10, "Java React DB");
		System.out.println(p);
		
		  ((Student)p).study();//javac err ! , javac checks it by : Type of the ref (it
		  //chks for study in Person class) Soln : to satisfy javac -- down
		 // casting(equivalent to : narrowing) ((Student)p).study();//no javac n no run
		 //time err 
		 //p=new Faculty(...);//no javac err : up casting ! p.teach();//javac
		 //err ((Faculty)p).teach(); //works ! ((Student)p).study();//run time err :
		//  java.lang.ClassCastException :Faculty CAN NOT be cast into a Student!

	}

}
/*
 * Overriding of toString Super class version java.lang.Object class Method
 * public String toString() : Rets the string containing Fully Qualified(F.Q)
 * className@hashCode Not useful in a practical scenario. So instead of adding
 * new functionality in sub classes (eg : getDetails() in Person ,
 * Student,Faculty) can we override toString itself ? YESS!
 * 
 * 
 * 
 * 
 * 
 * Apply above concepts in event organizer app
 * 
 * Objective : Arrange an event to invite students n faculties
 * 
 * Prompt user for event capacity. Create suitable data structure to hold the
 * participant details Person[] members=new Person[sc.nextInt()];
 * 
 * Options 1. Register Student : if(....) { sop("Enter student details .....");
 * members[counter] =new Student(...); counter++; sop(...); break; } 2. Register
 * Faculty : 3. Display participant details : for-each //eg :
 * {s1,s2,f1,s3,s4,f2,null,.......null} for(Person p : members)
 * //p=members[0],p=members[1],.... if(p != nul) sop(p);
 * 
 * 0. Exit
 * 
 * 
 * 
 * 
 * 
 * Add a new method "study" in Student class & "teach" in Faculty class Option 5
 * : User i/p : seat no Check if seat no is valid . In case of valid seat no ---
 * If it's a Student , invoke study method , if it's a Faculty invoke teach
 * method
 * 
 * 
 * When is downcasting required ? Iff you are invoking sub class specific
 * functionality (eg : study or teach), using super class reference . eg :
 * Person p=new Student(....);//up casting : done impl by javac : no err
 * sop(p);//p.toString() : no javac err : since Person class has toString
 * method. p.study();//javac err ! , javac checks it by : Type of the ref (it
 * chks for study in Person class) Soln : to satisfy javac -- down
 * casting(equivalent to : narrowing) ((Student)p).study();//no javac n no run
 * time err p=new Faculty(...);//no javac err : up casting ! p.teach();//javac
 * err ((Faculty)p).teach(); //works ! ((Student)p).study();//run time err :
 * java.lang.ClassCastException :Faculty CAN NOT be cast into a Student!
 * 
 * Solution : instanceof : keyword in java refer to : readme eg : Object
 * <----Emp <---Mgr <---SalesMgr, HRMgr Object <---- Emp <--- Worker
 * <--TempWorker
 * 
 * Emp e=new SalesMgr(......);//up casting e instanceof SalesMgr : t e
 * instanceof HRMgr : f e instanceof Worker : f e instanceof Mgr : t e
 * instanceof TempWorker : f e instanceof Emp : t e instanceof Object : t e=null
 * e instanceof SalesMgr : f e instanceof HRMgr e instanceof WorkerMgr e
 * instanceof Mgr e instanceof TempWorker e instanceof Emp e instanceof Object :
 * f
 * 
 * 
 * Object class Method public boolean equals(Object anotherObj) Returns true :
 * iff invoker n anotherObj : referring to the SAME instance (i.e checks by
 * reference equality) Otherwise : false. Need of overriding equals : To replace
 * reference equality by contents equality (Identity based) To be continued
 * tomorrow....
 * 
 * 
 */








