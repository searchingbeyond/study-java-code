package lixin.gan.servlet;

import lixin.gan.server.core.Request;
import lixin.gan.server.core.Response;
import lixin.gan.server.core.Servlet;

public class DemoServlet implements Servlet {
	@Override
	public void service(Request request, Response response) {
		response.append("hello world");
	}
}
