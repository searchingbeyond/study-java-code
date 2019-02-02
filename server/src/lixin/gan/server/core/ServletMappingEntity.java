package lixin.gan.server.core;

import java.util.HashSet;
import java.util.Set;

/**
 * 解析web.xml时，ServletMappingEntity对应servlet-mapping标签
 * @author ganlixin
 *
 */
public class ServletMappingEntity {
	private String servletName;
	private Set<String> urlPattern;
	
	public ServletMappingEntity() {
		super();
		urlPattern = new HashSet<>();
	}
	
	public ServletMappingEntity(String servletName, Set<String> urlPattern) {
		super();
		this.servletName = servletName;
		this.urlPattern = urlPattern;
	}
	
	public String getServletName() {
		return servletName;
	}
	
	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	
	public Set<String> getUrlPattern() {
		return urlPattern;
	}
	
	public void setUrlPattern(Set<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
	public void addUrlPattern(String urlPattern) {
		this.urlPattern.add(urlPattern);
	}
	
}
