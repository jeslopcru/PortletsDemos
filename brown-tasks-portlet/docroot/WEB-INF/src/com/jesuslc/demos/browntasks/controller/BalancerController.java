package com.jesuslc.demos.browntasks.controller;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.jesuslc.demos.browntasks.util.ModelAndView;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BalancerController extends MVCPortlet {
	
	public void processAction(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		String action="";
		if ( request.getParameter("action")!=null ) action=request.getParameter("action");

		if ( action.equals("addList") ) new AddListController().handleActionRequest(request,response);
		else if ( action.equals("addItem") ) new AddItemController().handleActionRequest(request,response);
		else new DefaultController().handleActionRequest(request,response);
		}


	public void render(RenderRequest request,RenderResponse response) throws IOException, PortletException {
		String action="";
		if ( request.getParameter("action")!=null ) action=request.getParameter("action");

		ModelAndView mav=null;

		if ( action.equals("addList") ) mav=new AddListController().handleRenderRequest(request,response);
		else if ( action.equals("addItem") ) mav=new AddItemController().handleRenderRequest(request,response);
		else mav=new DefaultController().handleRenderRequest(request,response);

		

		Map<String, Object> v=mav.getMap();
		for( int i=0;i<v.keySet().toArray().length;i++ ) {
			String k=""+v.keySet().toArray()[i];

			request.setAttribute( k, v.get( k ) );		
			}

		 
		include("/jsp/"+mav.getPage()+".jsp", request, response);
		}

}
