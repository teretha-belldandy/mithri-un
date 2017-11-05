package org.picenter.pictest.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketOne {
	
	public static final Logger LOG = LoggerFactory.getLogger(SocketOne.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket socServer = new ServerSocket(1099);
			while (true) {
				final Socket socket = socServer.accept();
				new Thread(new Runnable() {
					public void run() {
						try {
							BufferedReader bufReader = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
							StringBuilder sb = new StringBuilder();
							for (String line = bufReader.readLine(); line != null; line = bufReader.readLine()) {
								sb.append(line);
							}
							LOG.info("Thread@{}--{}", Thread.currentThread().getId(), sb.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
