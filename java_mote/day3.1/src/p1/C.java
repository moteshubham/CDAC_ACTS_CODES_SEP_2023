//non sub class in the same pkg
package p1;
class C  {
    
 C() {
	A a1=new A();
    System.out.println("A's state "+a1.i+" "+a1.j+" "+a1.k+" "+a1.l);
 }
   public static void main(String [] args){ }
}