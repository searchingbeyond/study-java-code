package lixin.gan.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ��������������
 * 1��ʹ��ServerSocket������������ָ������������port
 * 2������accept()����������ʽ�ĵȴ��ͻ��˵�����
 * 3��������Ӻ󣬽��в������������
 * 4���ͷ�����
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		
		System.out.println("Listen localhost:8888");
		
		/*Listens for a connection to be made to this socket and acceptsit. 
		 *The method blocks until a connection is made. */
		Socket connection = server.accept();
		
		System.out.println("a connection has been established");
		
		DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
		String str = dataInputStream.readUTF();
		boolean flag = dataInputStream.readBoolean();
		System.out.println(str + "---" + flag);
		
		dataInputStream.close();
		server.close();
	}
}
