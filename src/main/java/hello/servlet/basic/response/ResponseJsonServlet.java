package hello.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
* http://localhost:8080/response-json
*
*/
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
	

	private static final long serialVersionUID = -2956644374966314425L;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse	response) throws IOException {
	
		//Content-Type: application/json
		response.setHeader("content-type", "application/json");
		response.setCharacterEncoding("utf-8");
		HelloData data = new HelloData();
		data.setUsername("kim");
		data.setAge(20);
		
//		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		
		//{"username":"kim","age":20}
		String result = objectMapper.writeValueAsString(data);
		//response.getWriter().write(result);
		response.getWriter().println(result);
	}
	

}
