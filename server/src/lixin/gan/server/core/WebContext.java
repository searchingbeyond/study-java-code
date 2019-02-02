package lixin.gan.server.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上下文信息，保存有web.xml中的信息
 * @author ganlixin
 */
public class WebContext {
	/**
	 * 保存单独的一个web.xml中的servlet标签内容
	 */
	private List<ServletEntity> servletEntities  = null;
	
	/**
	 * 保存单独的一个web.xml中的servlet-mapping标签内容
	 */
	private List<ServletMappingEntity> servletMappingEntities = null;
	
	/**
	 * 保存所有servlet标签中的servlet-name和servlet-class的对应关系
	 * key:servlet-name		value:servlet-class
	 */
	private Map<String, String> servletMap = new HashMap<>();
	
	/**
	 * 保存所有的servlet-mapping中的url-pattern和servlet-name的对应关系
	 * key:url-pattern		value:servlet-name
	 */
	private Map<String, String> servletMappingMap = new HashMap<>();

	public WebContext() {
		
	}
	
	public WebContext(List<ServletEntity> servletEntities, List<ServletMappingEntity> servletMappingEntities) {
		this.servletEntities = servletEntities;
		this.servletMappingEntities = servletMappingEntities;
		
		/**
		 * 将servletEntities中的servlet转换为map
		 */
		for (ServletEntity tmp : servletEntities) {
			servletMap.put(tmp.getServletName(), tmp.getServletClass());
		} 
		
		/**
		 * 将servletMappingEntities中的servlet-mapping转换为map
		 */
		for (ServletMappingEntity tmp : servletMappingEntities) {
			for (String url_tmp : tmp.getUrlPattern()) {
				servletMap.put(url_tmp, tmp.getServletName());
			}
		} 
	}
	
	/**
	 * 通过urlPattern来获取class类路径
	 * @param urlPattern
	 * @return
	 */
	public String getServletClass(String urlPattern) {
		String servletName = servletMappingMap.get(urlPattern);
		return servletMap.get(servletName);
	}
}
