package lixin.gan;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Use_InetSocketAddress {
	public static void main(String[] args) {
		InetSocketAddress inetSocketAddress = null;
		
		//inetSocketAddress = new InetSocketAddress(InetAddress.getByName("www.baidu.com"), 8080);
		
		inetSocketAddress = new InetSocketAddress("127.0.0.1", 80);
		
		InetAddress address = inetSocketAddress.getAddress();
		String hostName = inetSocketAddress.getHostName();
		int port = inetSocketAddress.getPort();
		
	}
}
