package lix.gan.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Server_Receive_Basic_Data_Type {

	public static void main(String[] args) throws IOException {
		
		System.out.println("���ն�����");
		
		SocketAddress serverSocketAddress = new InetSocketAddress("localhost", 8888);
		DatagramSocket server = new DatagramSocket(serverSocketAddress);
		
		SocketAddress clientSocketAddress = new InetSocketAddress("localhost", 9999);
		
		byte[] container = new byte[1024 * 5];
		DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
		
		server.receive(datagramPacket);
		
		/**
		 * ��ȡ����ʱ�����ڻ������ͣ���Ҫʹ��Data��
		 */
		byte[] data = datagramPacket.getData();
		int length = datagramPacket.getLength();
		
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
		String str = dataInputStream.readUTF();
		boolean flag = dataInputStream.readBoolean();
		int number = dataInputStream.readInt();
		System.out.println(str);
		System.out.println(flag);
		System.out.println(number);
		
		server.close();
		
	}

}
