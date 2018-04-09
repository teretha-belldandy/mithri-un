package net.picenter.pictest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteTestDemo {

	public static void main(String[] args) throws IOException {
		byte a = 127;
		while (true) {
			System.out.println("byte value is " + ++a);
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
			if(bufReader.readLine().equals("0"))
				break;
		}
	}

}
