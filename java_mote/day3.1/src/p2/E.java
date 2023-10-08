//non sub class in the different pkg
package p2;
import p1.A;
class E {
  
 E() {
	 A a1=new A();
    System.out.println("A's state "+a1.i+" "+a1.j+" "+a1.k+" "+a1.l);
   public static void main(String [] args){}}
}
