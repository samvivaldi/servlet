package hello.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV2HandlerAdapter implements MyHandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return handler instanceof ControllerV2;
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

		ControllerV2 controller = (ControllerV2) handler;

		MyView view = controller.process(request, response);
		String viewPath = view.getViewPath();

		String viewName = this.changeViewName(viewPath);

		ModelView mv = new ModelView(viewName);
		mv.setModel(new HashMap<>());

		return mv;
	}

	private String changeViewName(String viewPath) {
		Map<String, String> nameMap = new HashMap<String, String>();
		nameMap.put("/WEB-INF/views/new-form.jsp", "new-form");
		nameMap.put("/WEB-INF/views/members.jsp", "members");
		nameMap.put("/WEB-INF/views/save-result.jsp", "save-result");
		return nameMap.get(viewPath);
	}

}
