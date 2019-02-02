package lixin.gan.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
	
	/**
	 * http����Э������
	 */
	private String requestInfo;
	
	/**
	 * ���󷽷�
	 */
	private String method;
	
	/**
	 * �����url
	 */
	private String url;
	
	/**
	 * ��ѯ�ַ���
	 */
	private String queryString;
	
	/**
	 * ��������󣬱������������map
	 */
	private Map<String, List<String>> parameterMap;
	
	/**
	 * ���з�
	 */
	private final String CRLF = "\r\n";
	
	public Request(Socket client) throws IOException {
		this(client.getInputStream());
	}
	
	public Request(InputStream inputStream) {
		parameterMap = new HashMap<>();
		
		byte[] data = new byte[1024 * 10];
		
		try {
			int length = inputStream.read(data);
			this.requestInfo = new String(data, 0, length);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		parseRequestInfo();
	}
	
	/**
	 * ����������Ϣ
	 */
	public void parseRequestInfo() {
		int firstBlank = this.requestInfo.indexOf(" ");
		int httpStart = this.requestInfo.indexOf(" HTTP/");
		
		this.method = this.requestInfo.substring(0, firstBlank).toLowerCase();
		
		this.url = this.requestInfo.substring(firstBlank + 1, httpStart);
		
		int queryIndex = this.url.indexOf("?");
		
		// url�����������
		if (queryIndex >= 0) {  
			String[] urlArray = this.url.split("\\?");
			this.url = urlArray[0];
			this.queryString = urlArray[1];
		}
		
		// �����post���󣬻�Ҫ���������е�����
		if (this.method.equals("post")) {
			String tmp = this.requestInfo.substring(this.requestInfo.lastIndexOf(this.CRLF)).trim();
			
			if (null == this.queryString) {
				queryString = tmp;
			} else {
				queryString += "&" + tmp;
			}
		}
		
		
		
	}
	
	/**
	 * ��ԭ���������ַ�������ΪMap��ʽ
	 */
	public void convertQueryStringToMap() {
		String[] items = this.queryString.split("&");
		String key = null;
		String value = null;
		for (String str : items) {
			String[] item = Arrays.copyOf(str.split("="), 2);
			key = item[0];
			value = (item[1] == null) ? null : decode(item[1], "utf8");
			
			if (parameterMap.containsKey(key)) {
				parameterMap.put(key, new ArrayList<>());
			}
			
			parameterMap.get(key).add(value);
		}
	}
	
	
	/**
	 * ������תΪָ���ַ��������ʽ
	 * @param str
	 * @param charset
	 * @return
	 */
	public String decode(String str, String charset) {
		try {
			return java.net.URLDecoder.decode(str, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ȡkey��Ӧ�Ķ��ֵ��checkbox)
	 * @param key
	 * @return
	 */
	public String[] getParameterValues(String key) {
		List<String> values = this.parameterMap.get(key);
		if (null == values || values.size() < 1) {
			return null;
		}
		return values.toArray(new String[0]);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getParameterValue(String key) {
		List<String> values = this.parameterMap.get(key);
		if (null == values || values.size() < 1) {
			return null;
		}
		return values.get(0);
	}
	
	public String getMethod() {
		return this.method;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getQueryString() {
		return this.queryString;
	}
}
