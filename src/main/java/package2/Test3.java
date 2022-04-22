package package2;

import package1.MyObject3;

public class Test3 extends MyObject3 {
 public static void main(String args[]) throws CloneNotSupportedException {
 MyObject3 obj = new MyObject3();
 obj.clone(); // Compile error.
 Test3 tobj = new Test3();
 tobj.clone();// Complie OK.
 }
}
