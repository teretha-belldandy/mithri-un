package net.learn.sdkstudy;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encode_str=java.net.URLEncoder.encode("credoo_xxx.cer", "utf-8");
        System.out.println(encode_str);
        String src_str = java.net.URLDecoder.decode(encode_str, "GBK");
        System.out.println(src_str);
	}

}
