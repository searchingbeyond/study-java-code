package lixin.gan.server.core;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ʹ��SAX��web.xml���н���������Ϊ��������
 * @author 13550
 *
 */
public class WebHandler extends DefaultHandler {
	
	/**
	 * �������浱ǰ���ڴ����servlet��ǩ
	 */
	private ServletEntity servletEntity;
	
	/**
	 * �������浱ǰ���ڴ����servlet-mapping��ǩ
	 */
	private ServletMappingEntity servletMappingEntity;
	
	/**
	 * ����web.xml�е�����servlet��ǩ
	 */
	private List<ServletEntity> servletEntities = new ArrayList<>();
	
	/**
	 * ����web.xml�е�����servlet-mapping��ǩ
	 */
	private List<ServletMappingEntity> servletMappingEntities = new ArrayList<>();
	
	/**
	 * ��ǰ���ڽ�����tag����
	 */
	private String tagName;
	
	/**
	 * �Ƿ�Ϊservlet-mapping��ǩ
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
			if (isMapping) {  // ��ǰ���ڽ���servlet-mapping
				if (tagName.equals("servlet-name")) {
					servletMappingEntity.setServletName(content);
				} else if (tagName.equals("url-pattern")) {
					servletMappingEntity.addUrlPattern(content);
				}
			} else {  // ��ǰ���ڽ���servlet��ǩ
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
