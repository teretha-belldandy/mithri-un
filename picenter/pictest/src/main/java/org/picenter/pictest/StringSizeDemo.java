package org.picenter.pictest;

public class StringSizeDemo {
	
	public static void main(String[] args) {
		String str = "abcdefg张";
		System.out.println(str.length());
		byte[] b = str.getBytes();
		System.out.println(b.length);
	}

}
