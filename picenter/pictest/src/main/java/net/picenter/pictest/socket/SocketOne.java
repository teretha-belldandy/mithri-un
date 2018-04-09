package net.picenter.pictest.socket;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketOne {

	// public static final Logger LOG =
	// LoggerFactory.getLogger(SocketOne.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket socServer = new ServerSocket(10099);
			while (true) {
				System.out.println("socket one is ready ...");
				final Socket socket = socServer.accept();
				new Thread(new Runnable() {
					public void run() {
						try {
							InputStream inStream = socket.getInputStream();
							byte[] strBytes = input2byte(inStream);
							String msg = String.format("Thread@%s--%s", Thread.currentThread().getId(),
									new String(strBytes, "UTF-8"));
							System.out.println(msg);
							socket.shutdownInput();
							BufferedWriter bufWriter = new BufferedWriter(
									new OutputStreamWriter(socket.getOutputStream()));
							bufWriter.write("got it, thanks from ");
							bufWriter.flush();
							socket.shutdownOutput();
							System.out.println("socket finished ...");
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								if (null != socket && !socket.isClosed())
									socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final byte[] input2byte(InputStream inStream) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}
}
