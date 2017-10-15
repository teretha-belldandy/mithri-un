package org.picenter.pictest;

public class StaticInheritDemo {

	public static void main(String[] args) {
		A one = new B();
		B two = new B();

		System.out.println("-------------class A--------------");
		System.out.println(A.a);
		System.out.println(A.b);
		System.out.println(A.geta());
		System.out.println(A.getb());
		System.out.println("-------------class B--------------");
		System.out.println(B.a);
		System.out.println(B.b);
		System.out.println(B.geta());
		System.out.println(B.getb());
		System.out.println("-------------obj one--------------");
		System.out.println(one.a);
		System.out.println(one.b);
		System.out.println(one.geta());
		System.out.println(one.getb());
		System.out.println("-------------obj two--------------");
		System.out.println(two.a);
		System.out.println(two.b);
		System.out.println(two.geta());
		System.out.println(two.getb());
	}
}

class A {
	static int a = 10;
	static int b = 11;

	static int geta() {
		return a;
	}

	static int getb() {
		return b;
	}
}

class B extends A {
	static int a = 100;
	static int b = 101;

	static int geta() {
		return a;
	}

	static int getmyb() {
		return 102;
	}
}