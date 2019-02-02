package lix.gan.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Client_Send_Object {
	public static void main(String[] args) throws IOException {

		System.out.println("发送端启动");
		
		/**
		 * 创建发送端， 下面的例子是localhost:9999 发送给 localhost:8888
		 */
		SocketAddress clientSocketAddress = new InetSocketAddress("localhost", 9999);
		DatagramSocket client = new DatagramSocket(clientSocketAddress);
		
		/**
		 * 指定接收端的ip+port
		 */
		SocketAddress serverSocketAddress = new InetSocketAddress("localhost", 8888);
		
		/**
		 * 组装为数据包
		 * 对于对象（引用类型），要使用Object流来传输
		 */
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		
		/**
		 * 
		 */
		objectOutputStream.writeObject(new Person(1, "abc", 9999));
		objectOutputStream.writeObject(new Person(2, "xyz", 8888));
		objectOutputStream.flush();
		
		byte[] data = byteArrayOutputStream.toByteArray();
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length, serverSocketAddress);
		
		/**
		 * 发送数据
		 */
		try {
			client.send(datagramPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		client.close();
	}
}
