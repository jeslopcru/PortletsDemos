package com.jesuslc.code;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public void handleActionRequest(ActionRequest arg0, ActionResponse arg1)
			throws Exception {
	}

	@Override
	public ModelAndView handleRenderRequest(RenderRequest arg0,
			RenderResponse arg1) throws Exception {
		Map<String, Object> model =	new HashMap<String, Object>();
		model.put("helloWorldMessage", "Hello World Jesuslc.com");
		return new ModelAndView("HelloWorld", model);
	}

}
