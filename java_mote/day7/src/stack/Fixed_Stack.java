package stack;

import java.util.Arrays;

public class Fixed_Stack implements Stack {

	protected Customer[] cust;
	protected int top;

	public Fixed_Stack() {
		System.out.println("in Fixed_Stack()");
		cust = new Customer[STACK_SIZE];
		top = -1;
	}

	@Override
	public void push(Customer c) {
		System.out.println("in push of fixed_stack");
		cust[++top] = c;
	}

	public int getTop() {
		return top;
	}

	@Override
	public Customer pop() {
		System.out.println("in pop of fixed_stack");
		return cust[top--];
	}

}
