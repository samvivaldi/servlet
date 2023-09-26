package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = { "/hello", "/hello/"  })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -3143561734505661317L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet.servicea");
		System.out.println("request = " + request);
		System.out.println("response = " + response);
		String username = request.getParameter("username");
		System.out.println("username = " + username);
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("hello " + username);
	}

}
