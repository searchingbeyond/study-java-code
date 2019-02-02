package lix.gan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 **接收端的几个步骤
 * 1、使用DatagramSocket 指定ip+port， 创建接收端
 * 2、准备容器，封装为DatagramPacket, 用来保存接收到的数据
 * 3、阻塞式接收数据 receive(DatagramPacket p)
 * 4、拆数据包 
 * 5、释放资源
 */
public class Server {

	public static void main(String[] args) throws IOException {
		
		System.out.println("接收端启动");
		
		SocketAddress serverSocketAddress = new InetSocketAddress("localhost", 8888);
		DatagramSocket server = new DatagramSocket(serverSocketAddress);
		
		SocketAddress clientSocketAddress = new InetSocketAddress("localhost", 9999);
		
		byte[] container = new byte[1024 * 5];
		DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
		
		server.receive(datagramPacket);
		
		byte[] data = datagramPacket.getData();
		int length = datagramPacket.getLength();
		
		System.out.println(new String(data, 0, length));
		
		server.close();
		
	}

}
