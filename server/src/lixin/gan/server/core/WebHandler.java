package lixin.gan.server.core;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 使用SAX对web.xml进行解析，此类为处理器类
 * @author 13550
 *
 */
public class WebHandler extends DefaultHandler {
	
	/**
	 * 用来保存当前正在处理的servlet标签
	 */
	private ServletEntity servletEntity;
	
	/**
	 * 用来保存当前正在处理的servlet-mapping标签
	 */
	private ServletMappingEntity servletMappingEntity;
	
	/**
	 * 包含web.xml中的所有servlet标签
	 */
	private List<ServletEntity> servletEntities = new ArrayList<>();
	
	/**
	 * 包含web.xml中的所有servlet-mapping标签
	 */
	private List<ServletMappingEntity> servletMappingEntities = new ArrayList<>();
	
	/**
	 * 当前正在解析的tag名称
	 */
	private String tagName;
	
	/**
	 * 是否为servlet-mapping标签
	 */
	private boolean isMapping = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (null != qName) {
			tagName = qName;
			if (tagName.equals("servlet")) {
				servletEntity = new ServletEntity();
				isMapping = false;
			} else if (tagName.equals("servlet-mapping")) {
				servletMappingEntity = new ServletMappingEntity();
				isMapping = true;
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length).trim();
		if (null != tagName) {
			if (isMapping) {  // 当前正在解析servlet-mapping
				if (tagName.equals("servlet-name")) {
					servletMappingEntity.setServletName(content);
				} else if (tagName.equals("url-pattern")) {
					servletMappingEntity.addUrlPattern(content);
				}
			} else {  // 当前正在解析servlet标签
				if (tagName.equals("servlet-name")) {
					servletEntity.setServletName(content);
				} else if (tagName.equals("servlet-class")) {
					servletEntity.setServletClass(content);
				}
				
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (null != qName) {
			if (qName.equals("servlet")) {
				servletEntities.add(servletEntity);
			} else if (qName.equals("servlet-mapping")) {
				servletMappingEntities.add(servletMappingEntity);
			}
		}
		tagName = null;
	}
	
	public List<ServletMappingEntity> getServletMappingEntities() {
		return this.servletMappingEntities;
	}
	
	public List<ServletEntity> getServletEntities() {
		return this.servletEntities;
	}
}
