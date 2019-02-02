package lixin.gan.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 创建服务器流程
 * 1、使用ServerSocket创建服务器，指定本机监听的port
 * 2、调用accept()方法，阻塞式的等待客户端的请求
 * 3、获得连接后，进行操作输入输出流
 * 4、释放连接
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
