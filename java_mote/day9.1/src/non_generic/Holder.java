package non_generic;

public class Holder {
//HAS-A  Object type of a ref , that can refer to ANY type 
	private Object ref;
	public Holder(Object ref) {
		super();           
		this.ref = ref;
	}
	public Object getRef() {
		return ref;
	}	
}
