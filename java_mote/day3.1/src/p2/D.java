//sub class in a different pkg
package p2;
import p1.A;
class D extends A {
   
 D() {
	 //super(); impl added by javac
    System.out.println("D's state "+i+" "+j+" "+k+" "+l);
 }
 public static void main(String [] args){}
}