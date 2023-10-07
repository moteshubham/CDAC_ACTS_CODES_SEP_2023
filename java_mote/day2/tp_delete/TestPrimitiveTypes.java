class TestPrimitiveTypes {
 public static void main(String[] args)
  {
    byte b1=12;
	short b2=10;
	short b3=(short)(b1+b2);
	long l1=13678676;
	float f=l1;
	double d=123.456;
	f=123.456f;
	char ch='A';
	ch=65;
	boolean flag=true;
	System.out.println(flag);
	int counter=10;
	if(counter == 10)
		System.out.println("Yes");
	else 
		System.out.println("No");
	byte b4=20;
	b4 += 10; //b4=(byte)(b4+10);
   }
}