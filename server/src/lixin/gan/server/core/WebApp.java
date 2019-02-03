package lixin.gan.server.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
	private static WebContext webContext = null;
	
	/**
	 * 静态初始化块，只执行一次
	 */
	static {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			WebHandler handler=  new WebHandler();
			
			parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), handler);
			
			webContext = new WebContext(handler.getServletEntities(), handler.getServletMappingEntities());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("解析配置文件失败");
		}
	}
	
	public static Servlet getServletFromUrl(String urlPattern) {
		String className = webContext.getServletClass(urlPattern);
		Class clas = null;
		
		try {
			clas = Class.forName(className);
			Servlet servlet = (Servlet)clas.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
