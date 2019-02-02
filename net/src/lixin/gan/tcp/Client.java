package lixin.gan.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

/*
 * 创建客户端额流程
 * 1、使用Socket创建和服务器的连接， 指定服务器端的ip和port
 * 2、操作输入输出流
 * 3、关闭连接
 * 
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Creates a stream socket and connects it to the specified portnumber on the named host. 
		Socket connection = new Socket("localhost", 8888);
		
		// 获得连接的流
		//connection.getOutputStream();
		
		DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
		dataOutputStream.writeUTF("hello world");
		dataOutputStream.writeBoolean(false);
		dataOutputStream.flush();
		dataOutputStream.close();
		
		connection.close();
		
	}
}
