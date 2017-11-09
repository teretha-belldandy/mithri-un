package com.picenter.picutils.comm;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class StringHelper {

	public static String asHex(byte[] bytes) {
		StringBuilder hexStr = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			hexStr.append(hex.toUpperCase());
		}
		return hexStr.toString();
	}

	public static String formatXml(String str) {
		StringReader in = new StringReader(str);
		SAXReader reader = new SAXReader();

		OutputFormat formater = OutputFormat.createPrettyPrint();
		formater.setEncoding("utf-8");
		StringWriter out = new StringWriter();
		XMLWriter writer = new XMLWriter(out, formater);

		Document doc = null;
		try {
			doc = reader.read(in);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}

		if (null != doc) {
			try {
				writer.write(doc);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return out.toString();
	}

	public static void main(String[] args) {
		byte[] b = new byte[] { 10, 111 };
		System.out.println(asHex(b));
		System.out.println(Integer.parseInt(asHex(b), 16));
		
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cqfrCreditAmountRequest><batch_no>batch no</batch_no><data_type>data type</data_type><quota_info><certificate_no>certificat no</certificate_no><contract_amount>1000000</contract_amount></quota_info><record_count>10</record_count></cqfrCreditAmountRequest>";
		System.out.println(formatXml(str));
	}

}