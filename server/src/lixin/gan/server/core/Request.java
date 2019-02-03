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
	 * http请求协议内容
	 */
	private String requestInfo;
	
	/**
	 * 请求方法
	 */
	private String method;
	
	/**
	 * 请求的url
	 */
	private String url;
	
	/**
	 * 查询字符串
	 */
	private String queryString;
	
	/**
	 * 解析请求后，保存请求参数的map
	 */
	private Map<String, List<String>> parameterMap = new HashMap<String, List<String>>();
	
	/**
	 * 换行符
	 */
	private final String CRLF = "\r\n";
	
	public Request(Socket client) throws IOException {
		this(client.getInputStream());
	}
	
	public Request(InputStream inputStream) {
		try {
			byte[] data = new byte[1024 * 10];
			int length = inputStream.read(data);
			if (length == -1) {
				return;
			}
			this.requestInfo = new String(data, 0, length);
			System.out.println("requestInfo\n" + requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		parseRequestInfo();
		
		convertQueryStringToMap();
		
		System.out.println("完成请求信息的解析");
	}
	
	/**
	 * 解析请求信息
	 */
	public void parseRequestInfo() {
		System.out.println("开始解析请求");
		int firstBlank = this.requestInfo.indexOf(" ");
		int httpStart = this.requestInfo.indexOf(" HTTP/");
		
		this.method = this.requestInfo.substring(0, firstBlank).toLowerCase();
		
		this.url = this.requestInfo.substring(firstBlank + 1, httpStart);
		
		System.out.println("method " + method);
		int queryIndex = this.url.indexOf("?");
		
		// url中有请求参数
		if (queryIndex >= 0) {  
			String[] urlArray = this.url.split("\\?");
			this.url = urlArray[0];
			this.queryString = urlArray[1];
		}
		
		System.out.println("url " + url);
		// 如果是post请求，还要处理主体中的数据
		if (this.method.equals("post")) {
			String tmp = this.requestInfo.substring(this.requestInfo.lastIndexOf(this.CRLF)).trim();
			System.out.println("tmp " + tmp);
			if (tmp != "" && tmp != null && null == queryString) {
				queryString = tmp;
			} else {
				queryString += "&" + tmp;
			}
		}
		System.out.println("" + queryString);
	}
	
	/**
	 * 将原生的请求字符串解析为Map形式
	 */
	public void convertQueryStringToMap() {
		if (queryString != null) {
			String[] items = queryString.split("&");
			System.out.println(parameterMap.size());
			for (String str : items) {
				String[] item = Arrays.copyOf(str.split("="), 2);
				String key = item[0];
				String value = (item[1] == null) ? null : decode(item[1], "utf8");
				System.out.println(key + " => " + value);
				if (! parameterMap.containsKey(key)) {
					parameterMap.put(key, new ArrayList<String>());
				}
				
				System.out.println(parameterMap.get(key));
				parameterMap.get(key).add(value);
			}
		}
	}
	
	
	/**
	 * 将内容转为指定字符集编码格式
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
	 * 获取key对应的多个值（checkbox)
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

	public String getRequestInfo() {
		return requestInfo;
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getQueryString() {
		return queryString;
	}

	public Map<String, List<String>> getParameterMap() {
		return parameterMap;
	}

	public String getCRLF() {
		return CRLF;
	}

	@Override
	public String toString() {
		return "Request [requestInfo=" + requestInfo + ", method=" + method + ", url=" + url + ", queryString="
				+ queryString + ", parameterMap=" + parameterMap + "]";
	}
}
