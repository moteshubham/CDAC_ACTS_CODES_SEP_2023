package generic;

//generic class T : Type
public class Holder<T> {
//HAS-A  Object type of a ref , that can refer to ANY type 
	private T ref;

	public Holder(T ref) {
		super();
		this.ref = ref;
	}

	public T getRef() {
		return ref;
	}
}
