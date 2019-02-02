package lix.gan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 **发送端的几个步骤
 * 1、使用DatagramSocket 指定ip+port， 创建发送端（注意不是接收端）
 * 2、将要发送的数据转换为字节数组，封装为DatagramPacket, 用来保存要发送的数据
 * 3、发送数据 send(DatagramPacket p)
 * 4、释放资源
 */

public class Client {
	public static void main(String[] args) throws SocketException {
		
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
		 */
		byte[] data = "这是数据 data".getBytes();
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
