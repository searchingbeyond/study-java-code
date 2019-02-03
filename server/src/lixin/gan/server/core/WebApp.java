package lixin.gan.server.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
	private static WebContext webContext = null;
	
	/**
	 * ��̬��ʼ���飬ִֻ��һ��
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
			System.out.println("���������ļ�ʧ��");
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
