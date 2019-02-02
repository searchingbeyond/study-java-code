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
		 * ���ڶ����������ͣ���Ҫʹ��Object��������
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
