package lixin.gan.server.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��������Ϣ��������web.xml�е���Ϣ
 * @author ganlixin
 */
public class WebContext {
	/**
	 * ���浥����һ��web.xml�е�servlet��ǩ����
	 */
	private List<ServletEntity> servletEntities  = null;
	
	/**
	 * ���浥����һ��web.xml�е�servlet-mapping��ǩ����
	 */
	private List<ServletMappingEntity> servletMappingEntities = null;
	
	/**
	 * ��������servlet��ǩ�е�servlet-name��servlet-class�Ķ�Ӧ��ϵ
	 * key:servlet-name		value:servlet-class
	 */
	private Map<String, String> servletMap = new HashMap<>();
	
	/**
	 * �������е�servlet-mapping�е�url-pattern��servlet-name�Ķ�Ӧ��ϵ
	 * key:url-pattern		value:servlet-name
	 */
	private Map<String, String> servletMappingMap = new HashMap<>();

	public WebContext() {
		
	}
	
	public WebContext(List<ServletEntity> servletEntities, List<ServletMappingEntity> servletMappingEntities) {
		this.servletEntities = servletEntities;
		this.servletMappingEntities = servletMappingEntities;
		
		/**
		 * ��servletEntities�е�servletת��Ϊmap
		 */
		for (ServletEntity tmp : servletEntities) {
			servletMap.put(tmp.getServletName(), tmp.getServletClass());
		} 
		
		/**
		 * ��servletMappingEntities�е�servlet-mappingת��Ϊmap
		 */
		for (ServletMappingEntity tmp : servletMappingEntities) {
			for (String url_tmp : tmp.getUrlPattern()) {
				servletMap.put(url_tmp, tmp.getServletName());
			}
		} 
	}
	
	/**
	 * ͨ��urlPattern����ȡclass��·��
	 * @param urlPattern
	 * @return
	 */
	public String getServletClass(String urlPattern) {
		String servletName = servletMappingMap.get(urlPattern);
		return servletMap.get(servletName);
	}
}
