package lixin.gan.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	/**
	 * ������socket
	 * 
	 */
	private ServerSocket serverSocket;
	
	/**
	 * server�Ƿ���������
	 */
	private boolean isRunning;

	public static void main(String[] args) {
		Server server = new Server();
		server.start(8889);
		server.accept();
	}
	
	/**
	 * �����˿ڣ�����������������������
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
	 * �����ͻ�������
	 */
	public void accept() {
		while(isRunning) {
			try {
				Socket connection = serverSocket.accept();
				// ���̴߳���ʹ�÷ַ���
				new Thread(new Dispacher(connection)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("��ͻ��˽�������ʧ��");
			}
		}
	}
	
	public void stop() {
		isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("�������Ѿ�ֹͣ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
