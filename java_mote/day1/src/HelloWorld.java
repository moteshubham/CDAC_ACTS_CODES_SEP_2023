//You can use all the classes from the package : java.lang (available implicitly)
//import java.lang.*;
class HelloWorld
{
//public : access modifier : accessible from anywhere(from within same package or from any different pkg
//static : can be accessed w/o instance
//void : does not ret anything to the caller
//args : cmd line args , String : name of the class from the pkg java.lang

  public static void main(String[] args) 
  {
    //c : printf , c++ : cout , java : System.out => std o/p stream (console o/p)
	//Methods : print / println / printf
	 System.out.println("Welcome 2 Java ");
	 System.out.println("Hello , "+args[0]);
	 
  }
}

