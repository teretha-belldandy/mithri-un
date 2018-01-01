package org.picenter.pictest.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class socTesta {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("113.200.27.105", 7074);
			BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			@SuppressWarnings("unused")
			String msg = "00000816<?xml version=\"1.0\" encoding=\"UTF-8\"?><transaction><header><msg><SERVICE_CODE>SVR_PTLN</SERVICE_CODE><TRAN_CODE>PTLN001</TRAN_CODE><TRAN_TYPE></TRAN_TYPE><TRAN_MODE>ONLINE</TRAN_MODE><BRANCH_ID>67842312-7</BRANCH_ID><TRAN_DATE>20140930</TRAN_DATE><TRAN_TIMESTAMP>124514201</TRAN_TIMESTAMP><SERVER_ID>********</SERVER_ID><WS_ID>127.0.0.1</WS_ID><USER_LANG> CHINESE </USER_LANG><SEQ_NO>************</SEQ_NO><SOURCE_BRANCH_NO>******</SOURCE_BRANCH_NO><DEST_BRANCH_NO>********</DEST_BRANCH_NO><MODULE_ID>CL</MODULE_ID><MESSAGE_TYPE>1200</MESSAGE_TYPE><MESSAGE_CODE>0001</MESSAGE_CODE><FILE_PATH></FILE_PATH></msg></header><body><GetTx><CONTRACT_NO>12345</CONTRACT_NO><LOAN_CATE>*****</LOAN_CATE><CON_FEE>25.54</CON_FEE><CUSTOMER_TYPE>*****</CUSTOMER_TYPE><CUSTOMER_NAME>*****</CUSTOMER_NAME></GetTx></body></transaction>";
			bufWriter.write("testa data sent...");
			bufWriter.flush();
			socket.shutdownOutput();
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(bufReader.readLine());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != socket)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
