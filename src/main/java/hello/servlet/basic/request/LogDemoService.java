package hello.servlet.basic.request;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	
	private final MyLogger myLogger;
	
//	private final ObjectProvider<MyLogger> myLoggerProvider;

	public void logic(String id) {
		
//		MyLogger myLogger = myLoggerProvider.getObject();
		
		myLogger.log("service id = " + id);
	}
}