package lixin.gan.servlet;

import lixin.gan.server.core.Request;
import lixin.gan.server.core.Response;
import lixin.gan.server.core.Servlet;

public class LoginServlet implements Servlet {
	@Override
	public void service(Request request, Response response) {
		response.appendLine("×ð¾´µÄ " + request.getParameterValue("username"));
		response.appendLine("<h1>Hello World</h1>");
	}
}
