package lixin.gan;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress可以通过多种方法来返回InetAddress对象
public class Use_InetAddress {
	public static void main(String[] args) {
		
		InetAddress inetAddress = null;
		
		try {
			// 获得本机的InetAddress对象
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost.getHostName());  // 获得主机名         DESKTOP-IKPJ8II
			System.out.println(localhost.getHostAddress()); // 获得本机ip 192.168.228.1

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			// 通过域名获取InetAddress对象
			inetAddress = InetAddress.getByName("www.ganlixin.cn");
			System.out.println(inetAddress.getHostAddress());  // 140.143.12.251
			System.out.println(inetAddress.getHostName());		// www.ganlixin.cn
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			// 通过ip获取InetAddress对象
			inetAddress = InetAddress.getByName("140.143.12.251");
			System.out.println(inetAddress.getHostAddress());
			System.out.println(inetAddress.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
