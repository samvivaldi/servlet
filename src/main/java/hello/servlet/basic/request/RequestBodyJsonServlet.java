package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * http://localhost:8080/request-body-json
 *
 * JSON 형식 전송 content-type: application/json message body: {"username": "hello", "age": 20}
 *
 */
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-bodyjson")
public class RequestBodyJsonServlet extends HttpServlet {

	private static final long serialVersionUID = -9221567127499974411L;

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		System.out.println("messageBody = " + messageBody);
		
		JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
		Map<String,Object> parseMap = jacksonJsonParser.parseMap(messageBody);
		
		parseMap.forEach((key, obj) -> System.out.println("map key :" +  key + ": " + obj));
		
		
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
		
		
		System.out.println("helloData.username = " + helloData.getUsername());
		
		System.out.println("helloData.age = " + helloData.getAge());
		
		
		System.out.println("helloData.toString() = " + helloData);
		
		response.getWriter().write("ok");
	}

}
