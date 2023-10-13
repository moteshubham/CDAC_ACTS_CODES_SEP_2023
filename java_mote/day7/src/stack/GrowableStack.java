package stack;

public class GrowableStack extends Fixed_Stack  {

	public GrowableStack() {
		super();
		System.out.println("in Growable()");
		
	}
	@Override
	public void push(Customer c) {
		System.out.println("growable() : push() : data pushed");
		cust[++top] = c;
	}
	public void pushGrow(Customer c) {
		System.out.println("array size increased and elements copied");
		//created new Customer[] stored in ref newCust of size old cust * 2
		Customer[] newCust = new Customer[cust.length*2];
		//copied elements from old cust to newCust
		for (int i = 0; i < cust.length; i++) {
			newCust[i] = cust[i];
		}
		//now assigning newCust ref to old cust
		//so cust pointing to new big array
		cust = newCust;
		this.push(c);
	}

	@Override
	public Customer pop() {
		System.out.println("growable() :element popped");
		return cust[top--];
	}
	public int getTop() {
		return top;
	}
	public int getTopTop() {
		System.out.println("growable() :checking new top");
		return cust.length;
	}
	

}
