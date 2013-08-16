package com.sin90lzc.train.java_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SimpleClientSocket extends TestCase {
	public void testClientSocket() throws Exception {
		Socket socket = new Socket("127.0.0.1", 9090);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		final PrintWriter writer = new PrintWriter(socket.getOutputStream(),
				true);
		final String abc = "abc";
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					// writer.println(abc);
					// 这里千万千万要记得加上"\n"，因为服务器端使用了reader.readLine()来读取输入信息，而readLine方法需要以"\n"为标记来读取信息
					writer.write(abc + "\n");
					writer.flush();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		Assert.assertEquals(abc, reader.readLine());
		socket.close();
	}
}
