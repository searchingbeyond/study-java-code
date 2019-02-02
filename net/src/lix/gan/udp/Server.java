package lix.gan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 **���ն˵ļ�������
 * 1��ʹ��DatagramSocket ָ��ip+port�� �������ն�
 * 2��׼����������װΪDatagramPacket, ����������յ�������
 * 3������ʽ�������� receive(DatagramPacket p)
 * 4�������ݰ� 
 * 5���ͷ���Դ
 */
public class Server {

	public static void main(String[] args) throws IOException {
		
		System.out.println("���ն�����");
		
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
