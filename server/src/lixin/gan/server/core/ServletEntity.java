package lixin.gan.server.core;

/**
 * 解析web.xml时，ServletEntity对应servlet标签
 * @author ganlixn
 */
public class ServletEntity {
	private String servletName;
	private String servletClass;
	
	public ServletEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServletEntity(String servletName, String servletClass) {
		super();
		this.servletName = servletName;
		this.servletClass = servletClass;
	}

	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public String getServletClass() {
		return servletClass;
	}

	public void setServletClass(String servletClass) {
		this.servletClass = servletClass;
	}
	
}
