package stack;

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
	public Customer pop() {
		
		return cust[++top];
	}

}
