package com.sin90lzc.train.java_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9090);
			ExecutorService es = Executors.newCachedThreadPool();
			while (true) {
				System.out.println("Server has Started!");
				es.execute(new Handler(serverSocket.accept()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class Handler implements Runnable {
		private ThreadLocal<Socket> localSocket = new ThreadLocal<Socket>();;
		private Socket socket;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		private synchronized void initSocket() {
			localSocket.set(socket);
		}

		@Override
		public void run() {
			initSocket();
			Socket s = localSocket.get();
			try {
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				PrintWriter writer = new PrintWriter(os, true);
				String content = null;

				while ((content = reader.readLine()) != "exit" && content!=null) {
					System.out.println(content);
					writer.println(content+"\n");
					//writer.flush();
				}
				System.out.println("exit!");
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
