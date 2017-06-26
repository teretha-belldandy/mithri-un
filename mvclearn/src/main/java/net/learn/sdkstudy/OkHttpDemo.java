package net.learn.sdkstudy;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class OkHttpDemo {

	public static void main(String[] args) throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder().url("http://www.baidu.com").build();
		Response response = okHttpClient.newCall(request).execute();
		if (response.isSuccessful()) {
			System.out.println(response.body().string());
		}
	}

}
