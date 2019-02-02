package lixin.gan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Use_URL {
	public static void getURLinfo() throws MalformedURLException {
		
		PrintStream out = System.out;
		
		URL url = new URL("http://localhost:80/di/user.html?name=abc&age=99#a");
		
		
		out.println(url.getProtocol());	// http
		out.println(url.getHost());		// localhost
		out.println(url.getFile());		// /di/user.html?name=abc&age=99
		out.println(url.getPort());		// 80
		out.println(url.getQuery());	// name=abc&age=99
		out.println(url.getRef());      // a
		
	}
	
	public static void downloadURL() {
		URL url = null;
		try {
			url = new URL("http://localhost:80/di/user.html?name=abc&age=99#a");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			// 打开连接
			InputStream inputStream = url.openStream();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			
			String content = "";
			while ((content = bufferedReader.readLine()) != null) {
				System.out.println(content);
			}
			bufferedReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		downloadURL();
	}
	
}
