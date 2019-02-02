package lixin.gan;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress����ͨ�����ַ���������InetAddress����
public class Use_InetAddress {
	public static void main(String[] args) {
		
		InetAddress inetAddress = null;
		
		try {
			// ��ñ�����InetAddress����
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost.getHostName());  // ���������         DESKTOP-IKPJ8II
			System.out.println(localhost.getHostAddress()); // ��ñ���ip 192.168.228.1

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			// ͨ��������ȡInetAddress����
			inetAddress = InetAddress.getByName("www.ganlixin.cn");
			System.out.println(inetAddress.getHostAddress());  // 140.143.12.251
			System.out.println(inetAddress.getHostName());		// www.ganlixin.cn
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			// ͨ��ip��ȡInetAddress����
			inetAddress = InetAddress.getByName("140.143.12.251");
			System.out.println(inetAddress.getHostAddress());
			System.out.println(inetAddress.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
