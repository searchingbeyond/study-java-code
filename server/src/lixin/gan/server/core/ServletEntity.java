package lixin.gan.server.core;

/**
 * ����web.xmlʱ��ServletEntity��Ӧservlet��ǩ
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
