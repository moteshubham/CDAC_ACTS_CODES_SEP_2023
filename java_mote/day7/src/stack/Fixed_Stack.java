package stack;

import java.util.Arrays;

public class Fixed_Stack implements Stack {

	protected Customer[] cust;
	protected int top;
	
	public Fixed_Stack() {
		cust=new Customer[STACK_SIZE];
		top=-1;
	}
	@Override
	public void push(Customer c) {

		cust[++top] = c;
	}
	

	@Override
	public String toString() {
		return "Fixed_Stack [cust=" + Arrays.toString(cust) + ", top=" + top + "]";
	}
	
	@Override
	public Customer pop() {
		
		return cust[++top];
	}

}
