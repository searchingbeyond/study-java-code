package lix.gan.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Client_Send_Basic_Data_Type {
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
		 * ���ڻ����������ͣ�Ҫʹ��Data��������
		 */
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
		
		dataOutputStream.writeUTF("hello data");
		dataOutputStream.writeBoolean(true);
		dataOutputStream.writeInt(99);
		dataOutputStream.flush();
		
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
