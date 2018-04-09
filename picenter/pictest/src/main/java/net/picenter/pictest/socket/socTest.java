package net.picenter.pictest.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socTest {

	public static void main(String[] args) {
		new Thread(genServer()).start();
		new Thread(genClient()).start();
	}

	public static Runnable genServer() {
		return new Runnable() {
			public void run() {
				try {
					ServerSocket socServer = new ServerSocket(10099);
					System.out.println("server ok...");
					Socket socket = socServer.accept();
					System.out.println("server socket ok...");
					BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					System.out.println("server input stream ok...");
					
					socket.close();
					System.out.println("server socket close...");
					socServer.close();
					System.out.println("server close...");
					
					bufReader.close();
					System.out.println("server input stream close...");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
	
	public static Runnable genClient() {
		return new Runnable() {
			public void run() {
				try {
					Socket socket = new Socket("localhost", 10099);
					System.out.println("client socket ok...");
					BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					System.out.println("client output stream ok...");
					bufWriter.close();
					System.out.println("client output stream close...");
					socket.close();
					System.out.println("client socket close...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
