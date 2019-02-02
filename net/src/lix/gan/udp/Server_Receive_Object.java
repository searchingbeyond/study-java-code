package lix.gan.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Server_Receive_Object {
	public static void main(String[] args) throws IOException {
		
		System.out.println("接收端启动");
		
		SocketAddress serverSocketAddress = new InetSocketAddress("localhost", 8888);
		DatagramSocket server = new DatagramSocket(serverSocketAddress);
		
		SocketAddress clientSocketAddress = new InetSocketAddress("localhost", 9999);
		
		byte[] container = new byte[1024 * 5];
		DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
		
		server.receive(datagramPacket);
		
		/**
		 * 读取数据时，对于基本类型，需要使用Data流
		 */
		byte[] data = datagramPacket.getData();
		int length = datagramPacket.getLength();
		
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Person p1 = null;
		Person p2 = null;
		try {
			p1 = (Person)objectInputStream.readObject();
			p2 = (Person)objectInputStream.readObject();
			
			System.out.println(p1);
			System.out.println(p2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		server.close();
	}
}
