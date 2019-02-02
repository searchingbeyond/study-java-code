package lixin.gan.server.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Response {

	/**
	 * 输出缓冲字符流
	 */
	private BufferedWriter bufferedWriter;
	
	/**
	 * 正文的内容
	 */
	private StringBuilder content;
	
	/**
	 * 头部信息
	 */
	private StringBuilder headerInfo;
	
	/**
	 * 正文的长度
	 */
	private int length;
	
	/**
	 * 状态码和解释
	 */
	private static Map<Integer, String> status;
	
	static {
		status = new HashMap<>();
		status.put(200, "OK");
		status.put(404, "NOT FOUND");
		status.put(500, "SERVER ERROR");
	}
	
	private final String BLANK = " ";
	private final String CRLF = "\r\n";
	
	private Response() {
		content = new StringBuilder();
		headerInfo = new StringBuilder();
		length = 0;
	}
	
	public Response(Socket client) {
		this();
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			headerInfo = null;
		}
		
	}
	
	public Response(OutputStream outputStream) {
		this();
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
	}
	
	/**
	 * 在相应内容中追加内容
	 * @param info
	 * @return
	 */
	public Response append(String info) {
		content.append(info);
		length += info.getBytes().length;
		return this;
	}
	
	/**
	 * 在相应内容中新增加一行内容
	 * @param info
	 * @return
	 */
	public Response appendLine(String info) {
		content.append(info).append(CRLF);
		length += (info + CRLF).getBytes().length;
		return this;
	}
	
	/**
	 * 构建头部信息
	 * @param code
	 */
	private void createHeaderInfo(int code) {
		headerInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK).append(status.get(code));
		headerInfo.append("Date:").append(new Date()).append(CRLF);
		headerInfo.append("Server:").append("testing server").append(CRLF);
		headerInfo.append("Content-type: text/html; charset=utf-8").append(CRLF);
		headerInfo.append("Content-length:").append(length).append(CRLF);
		headerInfo.append(CRLF);
	}
	
	/**
	 * 返回响应给客户端
	 * @param code
	 * @throws IOException
	 */
	public void pushToBrowser(int code) throws IOException {
		if (null == headerInfo) {
			code = 505;
		}
		createHeaderInfo(code);
		
		bufferedWriter.append(headerInfo);
		bufferedWriter.append(content);
		bufferedWriter.flush();
		
	}
}
