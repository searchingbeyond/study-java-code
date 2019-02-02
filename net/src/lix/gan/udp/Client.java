package lix.gan.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 **���Ͷ˵ļ�������
 * 1��ʹ��DatagramSocket ָ��ip+port�� �������Ͷˣ�ע�ⲻ�ǽ��նˣ�
 * 2����Ҫ���͵�����ת��Ϊ�ֽ����飬��װΪDatagramPacket, ��������Ҫ���͵�����
 * 3���������� send(DatagramPacket p)
 * 4���ͷ���Դ
 */

public class Client {
	public static void main(String[] args) throws SocketException {
		
		System.out.println("���Ͷ�����");
		
		/**
		 * �������Ͷˣ� �����������localhost:9999 ���͸� localhost:8888
		 */
		SocketAddress clientSocketAddress = new InetSocketAddress("localhost", 9999);
		DatagramSocket client = new DatagramSocket(clientSocketAddress);
		
		/**
		 * ָ�����ն˵�ip+port
		 */
		SocketAddress serverSocketAddress = new InetSocketAddress("localhost", 8888);
		
		/**
		 * ��װΪ���ݰ�
		 */
		byte[] data = "�������� data".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length, serverSocketAddress);
		
		/**
		 * ��������
		 */
		try {
			client.send(datagramPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		client.close();
	}
}
