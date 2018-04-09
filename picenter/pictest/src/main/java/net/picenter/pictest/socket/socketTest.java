package net.picenter.pictest.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import com.google.common.collect.Lists;

public class socketTest {

	public static void main(String[] args) {
		new Thread(genSocketServerRunner()).start();
		new Thread(genSocketClientRunner()).start();
	}

	public static Runnable genSocketClientRunner() {
		return new Runnable() {
			public void run() {
				Socket socket = null;
				BufferedWriter bufWriter = null;
				BufferedReader bufReader = null;
				try {
					socket = new Socket("localhost", 10099);
					System.out.println("client ok...");
					System.out.println("client socket input..." + socket.isInputShutdown());
					System.out.println("client socket output..." + socket.isOutputShutdown());
					bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					System.out.println("client ready...");
					for (int i = 0; i < 10; i++) {
						String out = String.format("buddy, client send you msg, give you %d\n", i);
						bufWriter.write(out);
						bufWriter.flush();
					}
					socket.shutdownOutput();
					System.out.println("client socket input..." + socket.isInputShutdown());
					System.out.println("client socket output..." + socket.isOutputShutdown());
					System.out.println("client read ready...");
					bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					System.out.println("client read ok...");
					for (String line = bufReader.readLine(); null != line; line = bufReader.readLine()) {
						System.out.println("client socket get:" + line);
					}
					// socket.shutdownInput();
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != bufReader)
							bufReader.close();
						if (null != bufWriter)
							bufWriter.close();
						if (null != socket)
							socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	public static Runnable genSocketServerRunner() {
		return new Runnable() {
			public void run() {
				ServerSocket socServer = null;
				Socket socket = null;
				BufferedReader bufReader = null;
				BufferedWriter bufWriter = null;
				try {
					socServer = new ServerSocket(10099);
					System.out.println("server ok...");
					socket = socServer.accept();
					bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					System.out.println("server ready...");
					List<String> strList = Lists.newArrayList();
					for (String line = bufReader.readLine(); null != line; line = bufReader.readLine()) {
						System.out.println("server socket get:" + line);
						strList.add(line);
					}
					// bufReader.close();
					// socket.shutdownInput();
					bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					int i = 0;
					for (String line : strList) {
						String out = String.format("buddy, server get your info <%s>, got your %s\n", line, i++);
						bufWriter.write(out);
						bufWriter.flush();
					}
					// bufWriter.close();
					// socket.shutdownOutput();
					System.out.println("==============================================");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != bufReader)
							bufReader.close();
						if (null != bufWriter)
							bufWriter.close();
						if (null != socket)
							socket.close();
						if (null != socServer)
							socServer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

}
