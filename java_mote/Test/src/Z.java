
class X {
	int a =2;
	String ab = "asdf";
	 Y b ;

	X() {
		System.out.print("X");
	}
}

class Y {
	Y() {
		System.out.print("Y");
	}
}

public class Z extends X {
	Y y = new Y();

	Z() {
		System.out.print("Z");
	}

	public static void main(String[] args) {
		new Z();
	}
}