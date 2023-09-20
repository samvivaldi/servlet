package hello.servlet.basic.request;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final MyLogger myLogger;
	
//	private final ObjectProvider<MyLogger> myLoggerProvider;

	@RequestMapping("/log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestURL = request.getRequestURL().toString();
		
//		MyLogger myLogger = myLoggerProvider.getObject();
		
		myLogger.setRequestURL(requestURL);
		myLogger.log("controller test");
		
		logDemoService.logic("testId");
		return "OK";
	}

}
