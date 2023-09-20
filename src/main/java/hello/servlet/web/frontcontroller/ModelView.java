package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter 
public class ModelView {
	private String viewName;
	private Map<String, Object> model = new HashMap<>();

	public ModelView(String viewName) {
		this.viewName = viewName; 
	}
	
}
