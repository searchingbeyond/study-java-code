package lixin.gan.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 分发器
 * @author 13550
 *
 */
public class Dispacher implements Runnable{
	private Socket connection;
	
	private Request request;
	private Response response;
	
	public Dispacher(Socket connection) {
		this.connection = connection;
		
		try {
			request = new Request(connection);
			System.out.println("request ---------\n" + request);
			response =  new Response(connection);
		} catch (IOException e) {
			e.printStackTrace();
			this.freeResource();
		}
	}
	
	@Override
	public void run() {
		try {
			if (null == request.getUrl() || request.getUrl().equals("")) {
				InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[] data = new byte[1024*10];
				int length = inputStream.read(data);
				response.append(new String(data, 0, length));
				response.pushToBrowser(200);
				inputStream.close();
				return;
			} 
			
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			
			if (null != servlet) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			} else {
				InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[] data = new byte[1024*10];
				int length = inputStream.read(data);
				response.append(new String(data, 0, length));
				response.pushToBrowser(404);
				inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.appendLine("服务器出现异常，请稍后再试");
				response.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		freeResource();
	}
	
	private void freeResource() {
		try {
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
