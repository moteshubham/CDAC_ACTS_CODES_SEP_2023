package stack;

public class Customer {
	int id;
	String name;
	String address;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	public Customer() {
		super();
		this.id = 00;
		this.name = null;
		this.address = null;
	}
	

	public Customer(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
}
