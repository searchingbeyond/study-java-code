package lixin.gan.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	/**
	 * 服务器socket
	 * 
	 */
	private ServerSocket serverSocket;
	
	/**
	 * server是否正在运行
	 */
	private boolean isRunning;

	public static void main(String[] args) {
		Server server = new Server();
		server.start(8889);
		server.accept();
	}
	
	/**
	 * 监听端口，并启动服务器，监听请求
	 * @param port
	 */
	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			isRunning = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 监听客户端请求
	 */
	public void accept() {
		while(isRunning) {
			try {
				Socket connection = serverSocket.accept();
				// 多线程处理，使用分发器
				new Thread(new Dispacher(connection)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("与客户端建立连接失败");
			}
		}
	}
	
	public void stop() {
		isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("服务器已经停止");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
