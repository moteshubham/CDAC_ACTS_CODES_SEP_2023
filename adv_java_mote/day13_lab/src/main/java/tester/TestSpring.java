package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// launch SC
		try (ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running ....");
			//deposit funds
			//get rdy to use (ready for servicing) spring bean from SC
			ATMImpl ref1=ctx.getBean("my_atm", ATMImpl.class);
			ref1.deposit(12345);
			ref1.withdraw(90);
		
	
			
			
			
		} //ctx.close() => shutting down SC --
		//searches for singleton beans --if it has custom destroy method --
		//invokes it --marks the bean for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
